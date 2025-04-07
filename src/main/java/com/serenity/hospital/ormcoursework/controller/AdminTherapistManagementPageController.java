package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.custom.TherapistBO;
import com.serenity.hospital.ormcoursework.bo.custom.impl.TherapistBOImpl;
import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dto.TherapistDTO;
import com.serenity.hospital.ormcoursework.view.tdm.TherapistTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminTherapistManagementPageController implements Initializable {

    @FXML
    private ComboBox<String> ComBoxTherapyProgram;

    @FXML
    private AnchorPane adminTherapistManagementPage;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnViewTherapistSchedules;

    @FXML
    private Button btnadd;

    @FXML
    private TableColumn<TherapistTM, String> colTherapistEmail;

    @FXML
    private TableColumn<TherapistTM, String> colTherapistID;

    @FXML
    private TableColumn<TherapistTM, String> colTherapistName;

    @FXML
    private TableColumn<TherapistTM, String> colTherapistPhoneNo;

    @FXML
    private TableColumn<TherapistTM, String> colTherapyProgram;

    @FXML
    private Label lblTherapistID;

    @FXML
    private TableView<TherapistTM> tblTherapistManagement;

    @FXML
    private TextField textTherapistEmail;

    @FXML
    private TextField textTherapistName;

    @FXML
    private ImageView therapistManagementBackDashboardimg;

    @FXML
    private Label therapistManagementBackDashboardtxt;

    @FXML
    private TextField txtTherapistPhoneNo;

    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();
    private final TherapistBO therapistBO = new TherapistBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTherapistID.setCellValueFactory(new PropertyValueFactory<>("therapistID"));
        colTherapistName.setCellValueFactory(new PropertyValueFactory<>("therapistName"));
        colTherapistEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTherapistPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colTherapyProgram.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        // Load data into table
        loadTherapists();
        generateNewId();

        ComBoxTherapyProgram.getItems().addAll(
                "Cognitive Behavioral Therapy",
                "Mindfulness-Based Stress Reduction",
                "Dialectical Behavior Therapy",
                "Group Therapy Sessions",
                "Family Counseling"
        );


    }

    private void generateNewId() {
        lblTherapistID.setText(therapistBO.getNaxtTherapistID());
    }

    private void loadTherapists() {
        try {
            ArrayList<TherapistDTO> therapists = (ArrayList<TherapistDTO>) therapistBO.loadAllTherapists();
            ObservableList<TherapistTM> therapistList = FXCollections.observableArrayList();

            for (TherapistDTO therapistDTO : therapists) {
                TherapistTM therapistTM = new TherapistTM(
                        therapistDTO.getTherapistID(),
                        therapistDTO.getTherapistName(),
                        therapistDTO.getEmail(),
                        therapistDTO.getPhoneNumber(),
                        therapistDTO.getSpecialization()
                );
                therapistList.add(therapistTM);
            }
            tblTherapistManagement.setItems(therapistList);
        } catch (Exception e) {
            showAlert("Error loading therapists: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @FXML
    void ComBoxTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = lblTherapistID.getText();
        if (id.isEmpty()) {
            showAlert("Please select a therapist to delete!");
            return;
        }

        try {
            boolean isDeleted = therapistBO.deleteTherapist(id);
            if (isDeleted) {
                showAlert("Therapist deleted successfully!");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to delete therapist.");
            }
        } catch (Exception e) {
            showAlert("Error deleting therapist: " + e.getMessage());
            e.printStackTrace();
        }
        loadTherapists();
        clearFields();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = lblTherapistID.getText();
        String name = textTherapistName.getText();
        String email = textTherapistEmail.getText();
        String phoneNumber = txtTherapistPhoneNo.getText();
        String specialization = ComBoxTherapyProgram.getValue();

        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || specialization == null) {
            showAlert("Please fill all fields!");
            return;
        }

        try {
            TherapistDTO therapistDTO = new TherapistDTO(id, name, email, phoneNumber, specialization);

            boolean isUpdated = therapistBO.updateTherapist(therapistDTO);
            if (isUpdated) {
                showAlert("Therapist updated successfully!");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to update therapist.");
            }
        } catch (Exception e) {
            showAlert("Error updating therapist: " + e.getMessage());
            e.printStackTrace();
        }

        loadTherapists();
        clearFields();
    }

    @FXML
    void btnViewTherapistSchedulesOnAction(ActionEvent event) {

    }

    @FXML
    void btnaddOnAction(ActionEvent event) {
        String id = lblTherapistID.getText();
        String name = textTherapistName.getText();
        String email = textTherapistEmail.getText();
        String phoneNumber = txtTherapistPhoneNo.getText();
        String specialization = ComBoxTherapyProgram.getValue();

        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || specialization == null) {
            showAlert("Please fill all fields!");
            return;
        }

        TherapistDTO therapistDTO = new TherapistDTO(id, name, email, phoneNumber, specialization);

        try {
            boolean isSaved = therapistBO.saveTherapist(therapistDTO);
            if (isSaved) {
                showAlert("Therapist saved successfully!");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to save therapist.");
            }
        } catch (Exception e) {
            showAlert("Error saving therapist: " + e.getMessage());
            e.printStackTrace();
        }
        loadTherapists();
        clearFields();
    }

    private void clearFields() {
        textTherapistName.clear();
        textTherapistEmail.clear();
        txtTherapistPhoneNo.clear();
        ComBoxTherapyProgram.getSelectionModel().clearSelection();
        generateNewId();
    }

    @FXML
    void therapistManagementBackDashboardimgOnAction(MouseEvent event) throws IOException {
        adminTherapistManagementPage.getChildren().clear();
        adminTherapistManagementPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
    }

    @FXML
    void therapistManagementBackDashboardtxtOnAction(MouseEvent event) throws IOException {
        adminTherapistManagementPage.getChildren().clear();
        adminTherapistManagementPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
    }

    @FXML
    void tblTherapistManagementOnMouseClicked(MouseEvent event) {
        TherapistTM selectedTherapist = tblTherapistManagement.getSelectionModel().getSelectedItem();
        if (selectedTherapist != null) {
            lblTherapistID.setText(selectedTherapist.getTherapistID());
            textTherapistName.setText(selectedTherapist.getTherapistName());
            textTherapistEmail.setText(selectedTherapist.getEmail());
            txtTherapistPhoneNo.setText(selectedTherapist.getPhoneNumber());
            ComBoxTherapyProgram.setValue(selectedTherapist.getSpecialization());
        }
    }

}
