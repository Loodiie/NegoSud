package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddStockController {

    @FXML
    private Button buttonCancelAddStock;

    @FXML
    private Button buttonValidateAddStock;

    @FXML
    void addAndReturnToStockPage(ActionEvent event) {

    }

    @FXML
    void cancelAndReturnToStockPage(ActionEvent event) {
        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Stock initiale)
        stage.close();
    }


}
