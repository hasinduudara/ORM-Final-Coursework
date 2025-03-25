package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.AppInitializer;
import com.serenity.hospital.ormcoursework.dao.impl.AdminDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomePageController extends AppInitializer {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnReceptionist;

    @FXML
    private AnchorPane welcomePage;

    public void initialize(URL location, ResourceBundle resources) {
        AdminDAOImpl adminDAO = new AdminDAOImpl();
        String nextId = adminDAO.getNextId();

    }

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
