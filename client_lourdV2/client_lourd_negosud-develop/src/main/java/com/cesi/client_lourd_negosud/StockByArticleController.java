package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.ArticleDAO;
import com.cesi.client_lourd_negosud.models.ArticleVide;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.Map;

public class StockByArticleController {


    @FXML
    private TextField searchArticleField;

    @FXML
    private Button rechercherButton;

    @FXML
    void searchArticleByName(ActionEvent event) {

    }

    @FXML
    private TableView<ArticleVide> stockByArticleTable;

    @FXML
    private TableColumn<ArticleVide, Integer> idArticle;

    @FXML
    private TableColumn<ArticleVide, String> articleName;

    @FXML
    private TableColumn<ArticleVide, BigDecimal> stockQuantity;

    // Méthode pour charger les données dans la table
    public void initialize() {
        // Récupérer les données des stocks par article depuis votre DAO
        ArticleDAO articleDAO = new ArticleDAO();
        Map<Integer, BigDecimal> stocksByArticle = articleDAO.getStocksByArticle();

        // Créer une liste observable pour les données
        ObservableList<ArticleVide> stockInfoList = FXCollections.observableArrayList();

        // Ajouter les données récupérées à la liste observable
        for (Map.Entry<Integer, BigDecimal> entry : stocksByArticle.entrySet()) {
            int idArticle = entry.getKey();
            BigDecimal quantity = entry.getValue();
            String articleName = ""; // Récupérer le nom de l'article en fonction de l'ID si nécessaire

            // Créer un nouvel objet StockInfo
            ArticleVide stockInfo = new ArticleVide(idArticle, articleName, quantity);

            // Ajouter l'objet à la liste observable
            stockInfoList.add(stockInfo);
        }

        // Mapper les propriétés aux colonnes de la table
        idArticle.setCellValueFactory(new PropertyValueFactory<>("idArticle"));
        articleName.setCellValueFactory(new PropertyValueFactory<>("articleName"));
        stockQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Charger les données dans la table
        stockByArticleTable.setItems(stockInfoList);
    }
}
