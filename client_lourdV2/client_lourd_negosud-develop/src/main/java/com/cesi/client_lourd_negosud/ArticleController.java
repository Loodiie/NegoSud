package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.ArticleDAO;
import com.cesi.client_lourd_negosud.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ArticleController {

    @FXML
    private Button buttonSearchArticleById;
    @FXML
    private TextField fieldSearchArticleById;

    @FXML
    private Button buttonGoToAddArticle;

    @FXML
    private Button buttonGoToUpdateArticle;

    @FXML
    private Button buttonDeleteArticle;

    @FXML
    private TableView<Articles> articleTable;

    @FXML
    private TableColumn<Articles, Integer> idArticleColumn;
    @FXML
    private TableColumn<Articles, String> articleNameColumn;
    @FXML
    private TableColumn<Articles, String> articleDescriptionColumn;
    @FXML
    private TableColumn<Articles, String> grapeVarietyColumn;
    @FXML
    private TableColumn<Articles, String> appellationArticleColumn;
    @FXML
    private TableColumn<Articles, String> yearProductionColumn;
    @FXML
    private TableColumn<Articles, Float> alcoholRateColumn;
    @FXML
    private TableColumn<Articles, Float> articlePriceColumn;
    @FXML
    private TableColumn<Articles, Integer> minThresholdColumn;
    @FXML
    private TableColumn<Articles, String> boxColumn;
    @FXML
    private TableColumn<Articles, String> familyColumn;
    @FXML
    private TableColumn<Articles, String> supplierColumn;

    private final ArticleDAO articleDAO = new ArticleDAO();

    @FXML
    public void initialize() {
        // On charge les données depuis l'API dans une liste
        List<Articles> articlesList = articleDAO.getAllArticles();

        // On lie les données aux champs du tableau (nom des colonnes)
        idArticleColumn.setCellValueFactory(cellData -> cellData.getValue().idArticleProperty().asObject());
        articleNameColumn.setCellValueFactory(cellData -> cellData.getValue().articleNameProperty());
        articleDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().articleDescriptionProperty());
        grapeVarietyColumn.setCellValueFactory(cellData -> cellData.getValue().grapeVarietyProperty());
        appellationArticleColumn.setCellValueFactory(cellData -> cellData.getValue().appellationArticleProperty());
        yearProductionColumn.setCellValueFactory(cellData -> cellData.getValue().yearProductionProperty());
        alcoholRateColumn.setCellValueFactory(cellData -> cellData.getValue().alcoholRateProperty().asObject());
        articlePriceColumn.setCellValueFactory(cellData -> cellData.getValue().articlePriceProperty().asObject());
        minThresholdColumn.setCellValueFactory(cellData -> cellData.getValue().minThresholdProperty().asObject());
        boxColumn.setCellValueFactory(cellData -> {
            Articles articles = cellData.getValue();
            if (articles != null) {
                Cartons cartons = articles.getCarton();
                if (cartons != null) {
                    return new SimpleStringProperty(String.valueOf(cartons.getIdBox()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une string vide si la Box est null
        });
        familyColumn.setCellValueFactory(cellData -> {
            Articles articles = cellData.getValue();
            if (articles != null) {
                Familles familles = articles.getFamily();
                if (familles != null) {
                    return new SimpleStringProperty(String.valueOf(familles.getFamilyName()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une string vide si la Family est null
        });
        supplierColumn.setCellValueFactory(cellData -> {
            Articles articles = cellData.getValue();
            if (articles != null) {
                Fournisseur fournisseur = articles.getSupplier();
                if (fournisseur != null) {
                    return new SimpleStringProperty(String.valueOf(fournisseur.getSupplierName()));
                }
            }
            return new SimpleStringProperty(""); // Retourner une chaîne vide si le Supplier est null
        });

        // Ajoute les données au tableau
        articleTable.getItems().addAll(articlesList);
    }

    private static Stage deleteArticleStage;
    @FXML
    void DeleteArticle(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression d'article en même temps)
        if (deleteArticleStage == null || !deleteArticleStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteArticle.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteArticleStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteArticleStage.setScene(scene);

                // Affiche le nouveau stage
                deleteArticleStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Stage addArticleStage;

    @FXML
    void GoToAddArticle(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout d'article en même temps)
        if (addArticleStage == null || !addArticleStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addArticle.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addArticleStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                addArticleStage.setScene(scene);

                // Affiche le nouveau stage
                addArticleStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Stage updateArticleStage;

    @FXML
    void GoToUpdateArticle(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update d'article en même temps)
        if (updateArticleStage == null || !updateArticleStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateArticle.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateArticleStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                updateArticleStage.setScene(scene);

                // Affiche le nouveau stage
                updateArticleStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterArticleById(ActionEvent event) {

        try {
            int id = Integer.parseInt(fieldSearchArticleById.getText());

            Articles articles = ArticleDAO.getArticleById(id);

            // Supprime les données existantes dans le tableau
            articleTable.getItems().clear();

            // Ajoute l'article recherché dans le tableau
            if (articles != null) {
                articleTable.getItems().add(articles);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }

    }

}
