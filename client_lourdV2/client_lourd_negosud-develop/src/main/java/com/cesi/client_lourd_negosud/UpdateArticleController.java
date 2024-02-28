package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.ArticleDAO;
import com.cesi.client_lourd_negosud.models.Articles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UpdateArticleController {

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldDescription;

    @FXML
    private TextField fieldGrapeVariety;

    @FXML
    private TextField fieldAppellation;

    @FXML
    private TextField fieldYear;

    @FXML
    private TextField fieldRateAlcohol;

    @FXML
    private TextField fieldUnitPrice;

    @FXML
    private TextField fieldThreshold;

    @FXML
    private Button buttonCancelupdateArticle;

    @FXML
    private Button buttonValidateupdateArticle;

    @FXML
    private TextField fieldSearchArticleById;

    @FXML
    private Button buttonSeachArticleById;

    @FXML
    private TextField fieldSupplier;

    @FXML
    private TextField fieldFamily;

    private final ArticleDAO articleDAO = new ArticleDAO();

    @FXML
    void searchByIdArticle(ActionEvent event) {

        try {
            // Récupére l'ID de l'article à rechercher
            int articleId = Integer.parseInt(fieldSearchArticleById.getText());

            // Appelle ArticleDAO pour récupérer le stock par son ID
            Articles articles = articleDAO.getArticleById(articleId);

            // Vérifie si l'article existe
            if (articles != null) {
                // Rempli les champs avec les données de l'article
                fieldName.setText(String.valueOf(articles.getArticleName()));
                fieldDescription.setText(String.valueOf(articles.getArticleDescription()));
                fieldGrapeVariety.setText(String.valueOf(articles.getGrapeVariety()));
                fieldAppellation.setText(String.valueOf(articles.getAppellationArticle()));
                fieldYear.setText(String.valueOf(articles.getYearProduction()));
                fieldRateAlcohol.setText(String.valueOf(articles.getAlcoholRate()));
                fieldUnitPrice.setText(String.valueOf(articles.getArticlePrice()));
                fieldThreshold.setText(String.valueOf(articles.getMinThreshold()));
                fieldSupplier.setText(articles.getSupplier().getSupplierName());
                fieldFamily.setText(articles.getFamily().getFamilyName());

            } else {
                // L'article n'existe pas
                System.out.println("L'article avec l'ID " + articleId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un nombre valide
            System.out.println("Veuillez entrer un ID d'article valide.");
        }

    }

    @FXML
    void updateAndReturnToArticlePage(ActionEvent event) {

    }


    @FXML
    void cancelAndReturnToArticlePage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Article initiale)
        stage.close();

    }




}
