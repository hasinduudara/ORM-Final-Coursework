package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReceptionistForgetPasswordPageViewController {

    @FXML
    private AnchorPane ReceptionistForgetPasswordPage;

    @FXML
    private Button btnReceptionistChangePassword;

    @FXML
    private Button btnReceptionistCheckEmail;

    @FXML
    private Button btnReceptionistGetCode;

    @FXML
    private Label lblReceptionistYourEmail;

    @FXML
    private PasswordField psReceptionistComPassword;

    @FXML
    private PasswordField psReceptionistNewPassword;

    @FXML
    private TextField txtReceptionistEnterOtpCode;

    @FXML
    private TextField txtReceptionistSearchUserName;

    @FXML
    void btnReceptionistChangePasswordOnAction(ActionEvent event) throws IOException {
        ReceptionistForgetPasswordPage.getChildren().clear();
        ReceptionistForgetPasswordPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistLogPageView.fxml")));
    }

    @FXML
    void btnReceptionistCheckEmailOnAction(ActionEvent event) {

    }

    @FXML
    void btnReceptionistGetCodeOnAction(ActionEvent event) {

    }

    @FXML
    void psReceptionistComPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void psReceptionistNewPasswordOnAction(ActionEvent event) {

    }

}
