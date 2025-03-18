package com.serenity.hospital.ormcoursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/WelcomePageView.fxml"));


        stage.setTitle("The Serenity Mental Health Therapy Center");

        Scene scene = new Scene(new Group(load));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/images/mental-health-icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
