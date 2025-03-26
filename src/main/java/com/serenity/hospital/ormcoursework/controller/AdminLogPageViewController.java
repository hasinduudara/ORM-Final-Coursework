package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
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

    private final AuthService authService = new AuthService(); // Injecting AuthService

    private boolean isPasswordVisible = false;

    @FXML
    void btnAdminGoAccCreatePageOnAction(ActionEvent event) throws IOException {
        adminLogPage.getChildren().clear();
        adminLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminSignUpPageView.fxml")));
    }

    @FXML
    void btnAdminLogForgetPassOnAction(ActionEvent event) throws IOException {
        adminLogPage.getChildren().clear();
        adminLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminForgetPasswordPageView.fxml")));
    }

    @FXML
    void btnAdminSignInOnAction(ActionEvent event) throws IOException {
        String username = txtAdminLogUserName.getText().trim();
        String password = psAdminLogPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println(username + "" + password);
            showAlert("Error", "Username and Password cannot be empty!", Alert.AlertType.ERROR);
            return;
        }

        boolean isAdmin = authService.authenticateAdmin(username, password);
        if (isAdmin) {
            adminLogPage.getChildren().clear();
            adminLogPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardPageView.fxml")));
        } else {
            showAlert("Error", "Invalid Username or Password!", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

}
