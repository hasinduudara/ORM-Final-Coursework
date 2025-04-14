package com.serenity.hospital.ormcoursework.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ReceptionistDashboardPageController {

    @FXML
    private Text cardDesc111;

    @FXML
    private Text cardDesc1111;

    @FXML
    private Text cardDesc11111;

    @FXML
    private Text cardDesc111111;

    @FXML
    private Text cardDesc1111111;

    @FXML
    private Text cardDesc11111111;

    @FXML
    private Pane panes111;

    @FXML
    private Pane panes1111;

    @FXML
    private Pane panes11111;

    @FXML
    private Pane panes111111;

    @FXML
    private ImageView receptionistDashboardLogOut;

    @FXML
    private AnchorPane receptionistDashboardPage;

    @FXML
    private ImageView receptionistDashboardSetting;

    @FXML
    private ImageView receptionistPatientManagement;

    @FXML
    private ImageView receptionistPayment;

    @FXML
    private ImageView receptionistReporting;

    @FXML
    private ImageView receptionistTherapySession;

    @FXML
    void receptionistDashboardLogOutOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void receptionistDashboardSettingOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void receptionistPatientManagementOnMouseClicked(MouseEvent event) throws IOException {
        receptionistDashboardPage.getChildren().clear();
        receptionistDashboardPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/PatientManagement.fxml")));
    }

    @FXML
    void receptionistPaymentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void receptionistReportingOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void receptionistTherapySessionOnMouseClicked(MouseEvent event) {

    }

}
