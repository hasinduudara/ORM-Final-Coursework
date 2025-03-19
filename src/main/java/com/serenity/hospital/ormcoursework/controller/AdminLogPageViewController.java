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

public class AdminLogPageViewController {

    @FXML
    private ImageView AdminLogPage;

    @FXML
    private AnchorPane adminLogPage;

    @FXML
    private Button btnAdminGoAccCreatePage;

    @FXML
    private Button btnAdminLogForgetPass;

    @FXML
    private Button btnAdminSignIn;

    @FXML
    private PasswordField psAdminLogPassword;

    @FXML
    private TextField txtAdminLogUserName;

    @FXML
    void btnAdminGoAccCreatePageOnAction(ActionEvent event) throws IOException {
        adminLogPage.getChildren().clear();
        adminLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminSignUpPageView.fxml")));
    }

    @FXML
    void btnAdminLogForgetPassOnAction(ActionEvent event) {

    }

    @FXML
    void btnAdminSignInOnAction(ActionEvent event) {

    }

}
