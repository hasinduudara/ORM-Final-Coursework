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

public class AdminSignUpPageViewController {

    @FXML
    private AnchorPane adminSignUpPage;

    @FXML
    private ImageView adminSignUpPassword;

    @FXML
    private Button btnAdminGoSingInPage;

    @FXML
    private Button btnAdminSignUpCreateAcc;

    @FXML
    private TextField txtAdminSignUpEmail;

    @FXML
    private TextField txtAdminSignUpName;

    @FXML
    private PasswordField txtAdminSignUpPassword;

    @FXML
    private TextField txtAdminSignUpUserName;

    @FXML
    void btnAdminGoSingInPageOnAction(ActionEvent event) throws IOException {
        adminSignUpPage.getChildren().clear();
        adminSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminLogPageView.fxml")));
    }

    @FXML
    void btnAdminSignUpCreateAccOnAction(ActionEvent event) {

    }

}
