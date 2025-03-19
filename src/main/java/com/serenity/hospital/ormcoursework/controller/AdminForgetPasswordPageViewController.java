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

public class AdminForgetPasswordPageViewController {

    @FXML
    private AnchorPane adminFogrtPasswordPage;

    @FXML
    private Button btnAdminChangePassword;

    @FXML
    private Button btnAdminCheckEmail;

    @FXML
    private Button btnAdminGetCode;

    @FXML
    private Label lblAdminYourEmail;

    @FXML
    private PasswordField psAdminComPassword;

    @FXML
    private PasswordField psAdminNewPassword;

    @FXML
    private TextField txtAdminEnterOtpCode;

    @FXML
    private TextField txtAdminSearchUserName;

    @FXML
    void btnAdminChangePasswordOnAction(ActionEvent event) throws IOException {
        adminFogrtPasswordPage.getChildren().clear();
        adminFogrtPasswordPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminLogPageView.fxml")));
    }

    @FXML
    void btnAdminCheckEmailOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdminGetCodeOnAction(ActionEvent event) {

    }

    @FXML
    void psAdminComPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void psAdminNewPasswordOnAction(ActionEvent event) {

    }

}
