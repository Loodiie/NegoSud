package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnexionController {

    @FXML
    private Button buttonGoToMainPage;

    private void centerSceneOnPrimaryScreen(Stage stage) {
        // Obtenir les dimensions de l'écran principal
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Centrer la scène sur l'écran
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;

        // Définir la position de la scène
        stage.setX(centerX);
        stage.setY(centerY);
    }
    @FXML
    void goToMainPage(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stock.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonGoToMainPage.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
