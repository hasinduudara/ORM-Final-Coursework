package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private TableColumn<?, ?> colPatientAddress;

    @FXML
    private TableColumn<?, ?> colPatientAge;

    @FXML
    private TableColumn<?, ?> colPatientGender;

    @FXML
    private TableColumn<?, ?> colPatientID;

    @FXML
    private TableColumn<?, ?> colPatientName;

    @FXML
    private TableColumn<?, ?> colPatientPhoneNo;

    @FXML
    private TableColumn<?, ?> colPatientTherapyProgram;

    @FXML
    private ComboBox<?> comBoxPatientManagementGender;

    @FXML
    private ComboBox<?> comBoxPatientManagementTherapyProgram;

    @FXML
    private ImageView patientManagementDashboardimg;

    @FXML
    private Label patientManagementDashboardtxt;

    @FXML
    private AnchorPane patientManagementPage;

    @FXML
    private TableView<?> tblPatientManagement;

    @FXML
    private TextField txtPatientManagementAddress;

    @FXML
    private TextField txtPatientManagementAge;

    @FXML
    private TextField txtPatientManagementName;

    @FXML
    private TextField txtPatientManagementPatientID;

    @FXML
    private TextField txtPatientManagementPhoneNo;

    @FXML
    void btnGoToPatientProfilesOnAction(ActionEvent event) {

    }

    @FXML
    void btnPatientAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnPatientClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnPatientDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnPatientUpdateOnAction(ActionEvent event) {

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

}
