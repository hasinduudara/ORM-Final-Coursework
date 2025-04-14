package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.custom.PatientBO;
import com.serenity.hospital.ormcoursework.bo.custom.impl.PatientBOImpl;
import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dto.PatientDTO;
import com.serenity.hospital.ormcoursework.tm.PatientTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatientManagementController {

    @FXML
    private Button btnGoToPatientProfiles;

    @FXML
    private Button btnPatientAdd;

    @FXML
    private Button btnPatientClear;

    @FXML
    private Button btnPatientDelete;

    @FXML
    private Button btnPatientUpdate;

    @FXML
    private TableColumn<PatientTM, String> colPatientAddress;

    @FXML
    private TableColumn<PatientTM, String> colPatientAge;

    @FXML
    private TableColumn<PatientTM, String> colPatientGender;

    @FXML
    private TableColumn<PatientTM, String> colPatientID;

    @FXML
    private TableColumn<PatientTM, String> colPatientName;

    @FXML
    private TableColumn<PatientTM, String> colPatientPhoneNo;

    @FXML
    private TableColumn<PatientTM, String> colPatientTherapyProgram;

    @FXML
    private ComboBox<String> comBoxPatientManagementGender;

    @FXML
    private ComboBox<String> comBoxPatientManagementTherapyProgram;

    @FXML
    private ImageView patientManagementDashboardimg;

    @FXML
    private Label patientManagementDashboardtxt;

    @FXML
    private AnchorPane patientManagementPage;

    @FXML
    private TableView<PatientTM> tblPatientManagement;

    @FXML
    private TextField txtPatientManagementAddress;

    @FXML
    private TextField txtPatientManagementAge;

    @FXML
    private TextField txtPatientManagementName;

    @FXML
    private TextField lblPatientManagementPatientID;

    @FXML
    private TextField txtPatientManagementPhoneNo;

    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();
    private final PatientBO patientBO = new PatientBOImpl();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPatientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        colPatientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colPatientAge.setCellValueFactory(new PropertyValueFactory<>("patientAge"));
        colPatientGender.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        colPatientPhoneNo.setCellValueFactory(new PropertyValueFactory<>("patientPhoneNo"));
        colPatientAddress.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        colPatientTherapyProgram.setCellValueFactory(new PropertyValueFactory<>("therapyProgram"));
    }

    @FXML
    void btnGoToPatientProfilesOnAction(ActionEvent event) {

    }

    @FXML
    void btnPatientAddOnAction(ActionEvent event) {
        String patientID = lblPatientManagementPatientID.getText();
        String patientName = txtPatientManagementName.getText();
        String patientAge = txtPatientManagementAge.getText();
        String patientGender = comBoxPatientManagementGender.getValue();
        String patientPhoneNo = txtPatientManagementPhoneNo.getText();
        String patientAddress = txtPatientManagementAddress.getText();

        if (patientID.isEmpty() || patientName.isEmpty() || patientAge.isEmpty() || patientGender.isEmpty() || patientPhoneNo.isEmpty() || patientAddress.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        PatientDTO patientDTO = new PatientDTO(patientID, patientName, patientAge, patientGender, patientPhoneNo, patientAddress);

        try {
            boolean isAdded = patientBO.savePatient(patientDTO);
            if (isAdded) {
                showAlert("Patient added successfully.");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to add patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("An error occurred while adding the patient.");
        }
        loadTherapists();
        clearFields();
    }

    private void generateNewId() {
        lblPatientManagementPatientID.setText(patientBO.getNextPatientID());
    }

    private void clearFields() {
        lblPatientManagementPatientID.clear();
        txtPatientManagementName.clear();
        txtPatientManagementAge.clear();
        comBoxPatientManagementGender.getSelectionModel().clearSelection();
        txtPatientManagementPhoneNo.clear();
        txtPatientManagementAddress.clear();
    }

    private void loadTherapists() {
        try {
            ArrayList<PatientDTO> patientDTOS = (ArrayList<PatientDTO>) patientBO.loadAllPatients();
            ObservableList<PatientTM> patientsList = FXCollections.observableArrayList();

            for (PatientDTO patientDTO : patientDTOS) {
                patientsList.add(new PatientTM(
                        patientDTO.getPatientID(),
                        patientDTO.getPatientName(),
                        patientDTO.getAge(),
                        patientDTO.getGender(),
                        patientDTO.getPhoneNumber(),
                        patientDTO.getAddress(),
                        patientDTO.getTherapyProgram()
                ));
                patientsList.add(new PatientTM());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnPatientClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnPatientDeleteOnAction(ActionEvent event) {
        String id = lblPatientManagementPatientID.getText();
        if (id.isEmpty()) {
            showAlert("Please select a patient to delete!");
            return;
        }

        try {
            boolean isDeleted = patientBO.deletePatient(id);
            if (isDeleted) {
                showAlert("Patient deleted successfully!");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to delete patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("An error occurred while deleting the patient.");
        }
    }

    @FXML
    void btnPatientUpdateOnAction(ActionEvent event) {
        String patientID = lblPatientManagementPatientID.getText();
        String patientName = txtPatientManagementName.getText();
        String patientAge = txtPatientManagementAge.getText();
        String patientGender = comBoxPatientManagementGender.getValue();
        String patientPhoneNo = txtPatientManagementPhoneNo.getText();
        String patientAddress = txtPatientManagementAddress.getText();

        if (patientID.isEmpty() || patientName.isEmpty() || patientAge.isEmpty() || patientGender.isEmpty() || patientPhoneNo.isEmpty() || patientAddress.isEmpty()) {
            showAlert("Please fill in all fields.");
            return;
        }

        PatientDTO patientDTO = new PatientDTO(patientID, patientName, patientAge, patientGender, patientPhoneNo, patientAddress);

        try {
            boolean isUpdated = patientBO.updatePatient(patientDTO);
            if (isUpdated) {
                showAlert("Patient updated successfully.");
                loadTherapists();
                generateNewId();
            } else {
                showAlert("Failed to update patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("An error occurred while updating the patient.");
        }
    }

    @FXML
    void comBoxPatientManagementGenderOnAction(ActionEvent event) {

    }

    @FXML
    void comBoxPatientManagementTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void patientManagementDashboardimgOnAction(MouseEvent event) {

    }

    @FXML
    void patientManagementDashboardtxtOnAction(MouseEvent event) {

    }

    @FXML
    void tblPatientManagementOnMouseClicked(MouseEvent event) {

    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

}
