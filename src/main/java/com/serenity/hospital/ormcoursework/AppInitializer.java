package com.serenity.hospital.ormcoursework;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WelcomePageView.fxml"));
        primaryStage.setTitle("Serenity Hub");
        Parent root = loader.load();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/icon-helth.png")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDatabase() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        new AppInitializer().initializeDatabase();
        launch(args);
    }
}