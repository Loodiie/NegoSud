package com.cesi.client_lourd_negosud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 680);
        stage.setTitle("NegoSud");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}