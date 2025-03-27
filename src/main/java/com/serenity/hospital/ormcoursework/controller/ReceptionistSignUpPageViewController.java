package com.serenity.hospital.ormcoursework.controller;

import com.serenity.hospital.ormcoursework.bo.custom.ReceptionistBo;
import com.serenity.hospital.ormcoursework.bo.custom.impl.ReceptionistBoImpl;
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

    private final ReceptionistBo receptionistBo = new ReceptionistBoImpl();

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";

    @FXML
    void btnReceptionistGoSingInPageOnAction(ActionEvent event) throws IOException {
        ReceptionistSignUpPage.getChildren().clear();
        ReceptionistSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ReceptionistLogPageView.fxml")));
    }

    @FXML
    void btnReceptionistSignUpCreateAccOnAction(ActionEvent event) {
        String name = txtReceptionistSignUpName.getText().trim();
        String email = txtReceptionistSignUpEmail.getText().trim();
        String userName = txtReceptionistSignUpUserName.getText().trim();
        String password = txtReceptionistSignUpPassword.getText().trim();

        if (name.isEmpty() || email.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
            return;
        }

        if (!isValidEmail(txtReceptionistSignUpEmail.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invalid email address").show();
            return;
        }

        if (receptionistBo.registerReceptionist(name, email, userName, password)) {
            loadUI("/view/ReceptionistLogPageView.fxml");
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    private void loadUI(String path) {
        try {
            ReceptionistSignUpPage.getChildren().clear();
            ReceptionistSignUpPage.getChildren().add(FXMLLoader.load(getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
