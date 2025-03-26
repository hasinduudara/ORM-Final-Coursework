package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.AdminBo;
import com.serenity.hospital.ormcoursework.bo.AdminBoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    private final AdminBo adminBo = new AdminBoImpl();

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";

    @FXML
    void btnAdminGoSingInPageOnAction(ActionEvent event) throws IOException {
        adminSignUpPage.getChildren().clear();
        adminSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminLogPageView.fxml")));
    }

    @FXML
    void btnAdminSignUpCreateAccOnAction(ActionEvent event) throws IOException {
        String name = txtAdminSignUpName.getText().trim();
        String email = txtAdminSignUpEmail.getText().trim();
        String userName = txtAdminSignUpUserName.getText().trim();
        String password = txtAdminSignUpPassword.getText().trim();

        if (name.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            showAlert("Error", "All fields are required!", Alert.AlertType.ERROR);
            return;
        }

        if (!isValidEmail(txtAdminSignUpEmail.getText())) {
            showAlert("Error", "Please enter a valid email address!", Alert.AlertType.ERROR);
            return;
        }

        if (adminBo.registerAdmin(name, email, userName, password)) {
            adminSignUpPage.getChildren().clear();
            adminSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminLogPageView.fxml")));
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void goToLogin(MouseEvent event) {
        loadUI("/view/AdminDashboardPageView.fxml");
    }

    private void loadUI(String resources) {
        adminSignUpPage.getChildren().clear();
        try {
            adminSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource(resources)));
        } catch (IOException e) {
            showAlert("Error", "Failed to load page!", Alert.AlertType.ERROR);
        }
    }

}
