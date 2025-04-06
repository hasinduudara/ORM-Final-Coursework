package com.serenity.hospital.ormcoursework.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminDashboardPageViewController {

    @FXML
    private AnchorPane AdminDashboard;

    @FXML
    private ImageView adminDashboardLogOut;

    @FXML
    private ImageView adminDashboardSetting;

    @FXML
    private ImageView adminPatientManagement;

    @FXML
    private ImageView adminPayment;

    @FXML
    private ImageView adminReporting;

    @FXML
    private ImageView adminTherapistManagement;

    @FXML
    private ImageView adminTherapistProgramManagement;

    @FXML
    private ImageView adminTherapySession;

    @FXML
    private Text cardDesc1;

    @FXML
    private Text cardDesc11;

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
    private Pane panes1;

    @FXML
    private Pane panes11;

    @FXML
    private Pane panes111;

    @FXML
    private Pane panes1111;

    @FXML
    private Pane panes11111;

    @FXML
    private Pane panes111111;

    @FXML
    void adminDashboardLogOutOnMouseClicked(MouseEvent event) throws IOException {
        AdminDashboard.getChildren().clear();
        AdminDashboard.getChildren().add(FXMLLoader.load(getClass().getResource("/view/WelcomePageView.fxml")));
    }

    @FXML
    void adminDashboardSettingOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void adminPatientManagementOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void adminPaymentOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void adminReportingOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void adminTherapistManagementOnMouseClicked(MouseEvent event) throws IOException {
        AdminDashboard.getChildren().clear();
        AdminDashboard.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminTherapistManagementPage.fxml")));
    }

    @FXML
    void adminTherapistProgramManagementOnMouseClicked(MouseEvent event) throws IOException {
        AdminDashboard.getChildren().clear();
        AdminDashboard.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminTherapyProgramManagementPage.fxml")));
    }

    @FXML
    void adminTherapySessionOnMouseClicked(MouseEvent event) {

    }

}
