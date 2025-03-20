package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReceptionistSignUpPageViewController {

    @FXML
    private AnchorPane ReceptionistSignUpPage;

    @FXML
    private ImageView adminSignUpPassword;

    @FXML
    private Button btnReceptionistGoSingInPage;

    @FXML
    private Button btnReceptionistSignUpCreateAcc;

    @FXML
    private TextField txtReceptionistSignUpEmail;

    @FXML
    private TextField txtReceptionistSignUpName;

    @FXML
    private PasswordField txtReceptionistSignUpPassword;

    @FXML
    private TextField txtReceptionistSignUpUserName;

    @FXML
    void btnReceptionistGoSingInPageOnAction(ActionEvent event) throws IOException {
        ReceptionistSignUpPage.getChildren().clear();
        ReceptionistSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistLogPageView.fxml")));
    }

    @FXML
    void btnReceptionistSignUpCreateAccOnAction(ActionEvent event) {

    }

}
