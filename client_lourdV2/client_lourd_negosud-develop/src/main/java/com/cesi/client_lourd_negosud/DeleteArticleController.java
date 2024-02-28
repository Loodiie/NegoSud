package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.ArticleDAO;
import com.cesi.client_lourd_negosud.models.Articles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class DeleteArticleController {

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
    private TextField fieldSupplier;

    @FXML
    private TextField fieldFamily;

    @FXML
    private Button buttonValidateDeleteArticle;

    @FXML
    private Button buttonCancelDeleteArticle;

    @FXML
    private TextField fieldSearchArticleById;

    @FXML
    private Button buttonSearchArticleById;

    private final ArticleDAO articleDAO = new ArticleDAO();


    @FXML
    void searchByIdArticle(ActionEvent event) {

        try {
            // Récupére l'ID de l'article à rechercher
            int articleId = Integer.parseInt(fieldSearchArticleById.getText());

            // Appelle ArticleDAO pour récupérer l'article par son ID
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
            // TODO Gérer l'exception si l'utilisateur n'a pas entré un nombre valide
            System.out.println("Veuillez entrer un ID d'article valide.");
        }

    }

    @FXML
    void cancelAndReturnToArticlePage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Article initiale)
        stage.close();

    }

    @FXML
    void deleteAndReturnToArticlePage(ActionEvent event) {

        try {
            // Récupére l'ID de l'article à rechercher
            int articleId = Integer.parseInt(fieldSearchArticleById.getText());

            // Appelle ArticleDAO pour récupérer l'article par son ID
            Articles articles = articleDAO.getArticleById(articleId);

            // Vérifie si l'article existe
            if (articles != null) {
                // Demande confirmation à l'utilisateur pour la suppression
                boolean confirmDelete = showDeleteConfirmationDialog();
                if (confirmDelete) {
                    // Supprime l'article
                    articleDAO.deleteArticle(articleId);

                    // Ferme la fenêtre actuelle (retourner sur la page Article initiale)
                    Node buttonDeleteStock = (Node) event.getSource();
                    Stage stage = (Stage) buttonDeleteStock.getScene().getWindow();
                    stage.close();
                }
            } else {
                // L'article n'existe pas
                System.out.println("L'article avec l'ID " + articleId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un nombre valide
            System.out.println("Veuillez entrer un ID d'article valide.");
        }

    }

    //Modale de confirmation de suppression de l'article
    private boolean showDeleteConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer l'article");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer cet article ?");

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
