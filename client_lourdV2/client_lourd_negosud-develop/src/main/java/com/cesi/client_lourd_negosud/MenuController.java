package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;


import java.io.IOException;

public class MenuController {
    @FXML
    public Button buttonConnexion;

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
    public void goToConnexion(ActionEvent event) {
        try {
            // Charger le fichier FXML

            FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));

            Parent root = loader.load();

            double sceneHeight = 680;
            double sceneWidth = 1200;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonStock.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public ImageView imageConnexion;
    @FXML
    public void goConnexion(MouseEvent mouseEvent) {
        try {
            // Charger le fichier FXML

            FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));

            Parent root = loader.load();

            double sceneHeight = 680;
            double sceneWidth = 1200;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonStock.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button buttonStock;
    @FXML
    public void goToStocks(ActionEvent event) {
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
            Stage stage = (Stage) buttonStock.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button buttonArticle;
    @FXML
    public void goToArticles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("article.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonArticle.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button buttonFamily;
    @FXML
    public void goToFamily(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("family.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonFamily.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button buttonUser;
    @FXML
    public void goToUsers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("users.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonUser.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button buttonSupplier;
    @FXML
    public void goToSuppliers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("supplier.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonSupplier.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public Button buttonWineOrder;
    @FXML
    public void goToWineOrder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("wineOrder.fxml"));
            Parent root = loader.load();


            // Obtenez la hauteur de l'écran
            double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            // Définissez la hauteur de la scène à 90% de la hauteur de l'écran
            double sceneHeight = screenHeight * 0.96;
            double sceneWidth = screenWidth * 1;
            Scene scene = new Scene(root, sceneWidth, sceneHeight);


            // Associer la scène à la fenêtre en utilisant initOwner
            Stage stage = (Stage) buttonWineOrder.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            // Centrer la nouvelle scène
            centerSceneOnPrimaryScreen(stage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


