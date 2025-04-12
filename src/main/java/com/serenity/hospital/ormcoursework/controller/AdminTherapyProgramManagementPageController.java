package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.custom.TherapistBO;
import com.serenity.hospital.ormcoursework.bo.custom.TherapyProgramBO;
import com.serenity.hospital.ormcoursework.bo.custom.impl.TherapistBOImpl;
import com.serenity.hospital.ormcoursework.bo.custom.impl.TherapyProgramBoImpl;
import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dto.TherapyProgramDTO;
import com.serenity.hospital.ormcoursework.tm.TherapyProgramTM;
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
import java.util.List;
import java.util.ResourceBundle;

public class AdminTherapyProgramManagementPageController implements Initializable {

    @FXML
    private ComboBox<String> ComBoxTherapistName;

    @FXML
    private AnchorPane adminTherapyProgramManagementPage;

    @FXML
    private Button btnCreateTherapyProgram;

    @FXML
    private Button btnModifyTherapyProgram;

    @FXML
    private Button btnRemoveTherapyProgram;

    @FXML
    private TableColumn<TherapyProgramTM, Double> colTherapyProgramCost;

    @FXML
    private TableColumn<TherapyProgramTM, String> colTherapyProgramDescription;

    @FXML
    private TableColumn<TherapyProgramTM, Integer> colTherapyProgramDuration;

    @FXML
    private TableColumn<TherapyProgramTM, String> colTherapyProgramID;

    @FXML
    private TableColumn<TherapyProgramTM, String> colTherapyProgramName;

    @FXML
    private TableColumn<TherapyProgramTM, String> colTherapyProgramTherapistName;

    @FXML
    private Label lblTherapyProgramID;

    @FXML
    private TableView<TherapyProgramTM> tblTherapyProgram;

    @FXML
    private TextField textTherapyProgramDuration;

    @FXML
    private TextField textTherapyProgramName;

    @FXML
    private ImageView therapyProgramBackDashboardimg;

    @FXML
    private Button btnClearFeilds;

    @FXML
    private Label therapyProgramBackDashboardtxt;

    @FXML
    private TextField txtTherapyProgramCost;

    @FXML
    private TextArea txtTherapyProgramDescription;

    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();
    private final TherapyProgramBO therapyProgramBO = new TherapyProgramBoImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTherapyProgramID.setCellValueFactory(new PropertyValueFactory<>("therapyProgramID"));
        colTherapyProgramName.setCellValueFactory(new PropertyValueFactory<>("therapyProgramName"));
        colTherapyProgramDescription.setCellValueFactory(new PropertyValueFactory<>("therapyProgramDescription"));
        colTherapyProgramDuration.setCellValueFactory(new PropertyValueFactory<>("therapyProgramDuration"));
        colTherapyProgramCost.setCellValueFactory(new PropertyValueFactory<>("therapyProgramCost"));
        colTherapyProgramTherapistName.setCellValueFactory(new PropertyValueFactory<>("therapistName"));

        // Load data into the table
        loadTherapyProgramData();
        generateNewId();

        // add combo box therepist names for therapist management
        TherapistBO therapistBO = new TherapistBOImpl();
        try {
            List<String> therapistNames = therapistBO.getAllTherapistNames();
            ComBoxTherapistName.getItems().addAll(therapistNames);
        } catch (Exception e) {
            showAlert("Error loading therapist names: " + e.getMessage());
        }

    }

    private void generateNewId() {
        lblTherapyProgramID.setText(therapyProgramBO.getNextTherapyProgramID());
    }

    private void loadTherapyProgramData() {
        try {
            ArrayList<TherapyProgramDTO> therapyPrograms = (ArrayList<TherapyProgramDTO>) therapyProgramBO.loadAllTherapyPrograms();
            ObservableList<TherapyProgramTM> therapyProgramList = FXCollections.observableArrayList();

            for (TherapyProgramDTO therapyProgramDTO : therapyPrograms) {
                therapyProgramList.add(new TherapyProgramTM(
                        therapyProgramDTO.getProgramID(),
                        therapyProgramDTO.getProgramName(),
                        therapyProgramDTO.getDescription(),
                        therapyProgramDTO.getDuration(),
                        therapyProgramDTO.getCost(),
                        therapyProgramDTO.getTherapistName()
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    void btnCreateTherapyProgramOnAction(ActionEvent event) {
        String therapyProgramName = textTherapyProgramName.getText();
        String therapyProgramDescription = txtTherapyProgramDescription.getText();
        int therapyProgramDuration = Integer.parseInt(textTherapyProgramDuration.getText());
        double therapyProgramCost = Double.parseDouble(txtTherapyProgramCost.getText());
        String therapistName = ComBoxTherapistName.getValue().toString();

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                lblTherapyProgramID.getText(),
                therapyProgramName,
                therapyProgramDescription,
                therapyProgramDuration,
                therapyProgramCost,
                therapistName
        );

        try {
            boolean isCreated = therapyProgramBO.addTherapyProgram(therapyProgramDTO);
            if (isCreated) {
                showAlert("Therapy Program Created Successfully");
                loadTherapyProgramData();
            } else {
                showAlert("Failed to Create Therapy Program");
            }
        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
            e.printStackTrace();
        }
        loadTherapyProgramData();
        clearFields();
    }

    @FXML
    void btnModifyTherapyProgramOnAction(ActionEvent event) {
        String therapyProgramID = lblTherapyProgramID.getText();
        String therapyProgramName = textTherapyProgramName.getText();
        String therapyProgramDescription = txtTherapyProgramDescription.getText();
        int therapyProgramDuration = Integer.parseInt(textTherapyProgramDuration.getText());
        double therapyProgramCost = Double.parseDouble(txtTherapyProgramCost.getText());
        String therapistName = ComBoxTherapistName.getValue().toString();

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO(
                therapyProgramID,
                therapyProgramName,
                therapyProgramDescription,
                therapyProgramDuration,
                therapyProgramCost,
                therapistName
        );

        try {
            boolean isUpdated = therapyProgramBO.updateTherapyProgram(therapyProgramDTO);
            if (isUpdated) {
                showAlert("Therapy Program Updated Successfully");
                loadTherapyProgramData();
            } else {
                showAlert("Failed to Update Therapy Program");
            }
        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
            e.printStackTrace();
        }
        loadTherapyProgramData();
        clearFields();
    }

    @FXML
    void btnRemoveTherapyProgramOnAction(ActionEvent event) {
        String therapyProgramID = lblTherapyProgramID.getText();

        try {
            boolean isDeleted = therapyProgramBO.deleteTherapyProgram(Integer.parseInt(therapyProgramID));
            if (isDeleted) {
                showAlert("Therapy Program Deleted Successfully");
                loadTherapyProgramData();
            } else {
                showAlert("Failed to Delete Therapy Program");
            }
        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
            e.printStackTrace();
        }
        loadTherapyProgramData();
        clearFields();
    }

    @FXML
    void therapistManagementBackDashboardimgOnAction(MouseEvent event) throws IOException {
        adminTherapyProgramManagementPage.getChildren().clear();
        adminTherapyProgramManagementPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
    }

    @FXML
    void therapistManagementBackDashboardtxtOnAction(MouseEvent event) throws IOException {
        adminTherapyProgramManagementPage.getChildren().clear();
        adminTherapyProgramManagementPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
    }

    @FXML
    void tblTherapyProgramManagementOnMouseClick(MouseEvent event) {
        TherapyProgramTM selectedTherapyProgram = tblTherapyProgram.getSelectionModel().getSelectedItem();
        if (selectedTherapyProgram != null) {
            lblTherapyProgramID.setText(selectedTherapyProgram.getProgramID());
            textTherapyProgramName.setText(selectedTherapyProgram.getProgramName());
            txtTherapyProgramDescription.setText(selectedTherapyProgram.getDescription());
            textTherapyProgramDuration.setText(String.valueOf(selectedTherapyProgram.getDuration()));
            txtTherapyProgramCost.setText(String.valueOf(selectedTherapyProgram.getCost()));
            ComBoxTherapistName.setValue(selectedTherapyProgram.getTherapistName());
        }
    }

    @FXML
    void btnClearFeildsOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        textTherapyProgramName.clear();
        txtTherapyProgramDescription.clear();
        textTherapyProgramDuration.clear();
        txtTherapyProgramCost.clear();
        ComBoxTherapistName.getSelectionModel().clearSelection();
        lblTherapyProgramID.setText("");
    }

}
