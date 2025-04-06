package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminTherapistManagementPageController {

    @FXML
    private ComboBox<?> ComBoxTherapyProgram;

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
    private TableColumn<?, ?> colTherapistEmail;

    @FXML
    private TableColumn<?, ?> colTherapistID;

    @FXML
    private TableColumn<?, ?> colTherapistName;

    @FXML
    private TableColumn<?, ?> colTherapistPhoneNo;

    @FXML
    private TableColumn<?, ?> colTherapyProgram;

    @FXML
    private Label lblTherapistID;

    @FXML
    private TableView<?> tblTherapistManagement;

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

    @FXML
    void ComBoxTherapyProgramOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewTherapistSchedulesOnAction(ActionEvent event) {

    }

    @FXML
    void btnaddOnAction(ActionEvent event) {

    }

    @FXML
    void therapistManagementBackDashboardimgOnAction(MouseEvent event) throws IOException {
        adminTherapistManagementPage.getChildren().clear();
        adminTherapistManagementPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
    }

    @FXML
    void therapistManagementBackDashboardtxtOnAction(MouseEvent event) {

    }

}
