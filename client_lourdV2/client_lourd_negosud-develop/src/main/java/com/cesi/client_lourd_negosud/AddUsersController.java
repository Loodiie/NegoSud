package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class AddUsersController {

    @FXML
    private Button buttonCancelAddUser;

    @FXML
    private Button buttonValidateAddUser;

    @FXML
    private RadioButton buttonUserAdmin;

    @FXML
    void IsUserAdmin(ActionEvent event) {

    }

    @FXML
    void addAndReturnToUserPage(ActionEvent event) {

    }

    @FXML
    void cancelAndReturnToUserPage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page User initiale)
        stage.close();

    }


}
