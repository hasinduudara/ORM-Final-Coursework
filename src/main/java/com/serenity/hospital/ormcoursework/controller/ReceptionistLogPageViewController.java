package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReceptionistLogPageViewController {

    @FXML
    private Button btnReceptionistGoAccCreatePage;

    @FXML
    private Button btnReceptionistLogForgetPass;

    @FXML
    private Button btnReceptionistSignIn;

    @FXML
    private PasswordField psReceptionistLogPassword;

    @FXML
    private AnchorPane receptionistLogPage;

    @FXML
    private TextField txtReceptionistLogUserName;

    @FXML
    void btnReceptionistGoAccCreatePageOnAction(ActionEvent event) throws IOException {
        receptionistLogPage.getChildren().clear();
        receptionistLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistSignUpPageView.fxml")));
    }

    @FXML
    void btnReceptionistLogForgetPassOnAction(ActionEvent event) throws IOException {
        receptionistLogPage.getChildren().clear();
        receptionistLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistForgetPasswordPageView.fxml")));
    }

    @FXML
    void btnReceptionistSignInOnAction(ActionEvent event) throws IOException {
        receptionistLogPage.getChildren().clear();
        receptionistLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistDashboardPage.fxml")));
    }

}
