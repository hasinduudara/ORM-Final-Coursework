package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminTherapyProgramManagementPageController {

    @FXML
    private ComboBox<?> ComBoxTherapistName;

    @FXML
    private AnchorPane adminTherapyProgramManagementPage;

    @FXML
    private Button btnCreateTherapyProgram;

    @FXML
    private Button btnModifyTherapyProgram;

    @FXML
    private Button btnRemoveTherapyProgram;

    @FXML
    private TableColumn<?, ?> colTherapyProgramCost;

    @FXML
    private TableColumn<?, ?> colTherapyProgramDescription;

    @FXML
    private TableColumn<?, ?> colTherapyProgramDuration;

    @FXML
    private TableColumn<?, ?> colTherapyProgramID;

    @FXML
    private TableColumn<?, ?> colTherapyProgramName;

    @FXML
    private TableColumn<?, ?> colTherapyProgramTherapistName;

    @FXML
    private Label lblTherapyProgramID;

    @FXML
    private TableView<?> tblTherapyProgram;

    @FXML
    private TextField textTherapyProgramDuration;

    @FXML
    private TextField textTherapyProgramName;

    @FXML
    private ImageView therapyProgramBackDashboardimg;

    @FXML
    private Label therapyProgramBackDashboardtxt;

    @FXML
    private TextField txtTherapyProgramCost;

    @FXML
    private TextArea txtTherapyProgramDescription;

    @FXML
    void ComBoxTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnCreateTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnModifyTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void therapistManagementBackDashboardimgOnAction(MouseEvent event) {

    }

    @FXML
    void therapistManagementBackDashboardtxtOnAction(MouseEvent event) {

    }

}
