package com.cesi.client_lourd_negosud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddArticleController {

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldDescription;

    @FXML
    private TextField fieldGapeVariety;

    @FXML
    private TextField fieldAppellation;

    @FXML
    private TextField fieldYear;

    @FXML
    private TextField fieldAlcoholRate;

    @FXML
    private TextField fieldUnitPrice;

    @FXML
    private TextField fieldThreshold;

    @FXML
    private Button buttonCancelAddArticle;

    @FXML
    private Button buttonValidateAddArticle;

    @FXML
    private TextField fieldSupplier;

    @FXML
    private TextField fieldFamily;

    @FXML
    void addAndReturnToArticlePage(ActionEvent event) {

    }

    @FXML
    void cancelAndReturnToArticlePage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Article initiale)
        stage.close();

    }

}
