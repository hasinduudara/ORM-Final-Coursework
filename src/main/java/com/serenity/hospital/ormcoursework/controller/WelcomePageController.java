package com.serenity.hospital.ormcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnReceptionist;

    @FXML
    private AnchorPane welcomePage;

    @FXML
    void btnAdminOnAction(ActionEvent event) throws IOException {
        welcomePage.getChildren().clear();
        welcomePage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminLogPageView.fxml")));
    }

    @FXML
    void btnReceptionistOnAction(ActionEvent event) throws IOException {
        welcomePage.getChildren().clear();
        welcomePage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistLogPageView.fxml")));
    }

}
