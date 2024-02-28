package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddWineOrderController {

    @FXML
    private Button buttonCancelAddWineOrder;

    @FXML
    private Button buttonValidateAddWineOrder;

    @FXML
    void addAndReturnToWineOrderPage(ActionEvent event) {

    }

    @FXML
    void cancelAndReturnToWineOrderPage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Commandes initiale)
        stage.close();

    }

}
