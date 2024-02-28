package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddSupplierController {

    @FXML
    private Button buttonCancelAddSupplier;

    @FXML
    private Button buttonValidateAddSupplier;

    @FXML
    void addAndReturnToSupplierPage(ActionEvent event) {

    }

    @FXML
    void cancelAndReturnToSupplierPage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Supplier initiale)
        stage.close();

    }

}
