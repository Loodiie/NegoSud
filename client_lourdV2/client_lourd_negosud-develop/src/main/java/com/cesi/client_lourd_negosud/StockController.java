package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.StockDAO;
import com.cesi.client_lourd_negosud.models.Articles;
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


public class StockController {


    @FXML
    private Button buttonSearchStockById;

    @FXML
    private TextField fieldSearchStockById;

    @FXML
    private Button buttonGoToAddStock;

    @FXML
    private Button buttonGoToUpdateStock;

    @FXML
    private Button buttonDeleteStock;

    /*@FXML
    private TableView<Stock> stockTable;

    @FXML
    private TableColumn<Stock, Integer> idColumn;

    @FXML
    private TableColumn<Stock, String> dateInColumn;

    @FXML
    private TableColumn<Stock, String> dateOutColumn;

    @FXML
    private TableColumn<Stock, Integer> quantityInColumn;

    @FXML
    private TableColumn<Stock, Integer> quantityOutColumn;

    @FXML
    private TableColumn<Stock, String> articleColumn;

    private final StockDAO stockDAO = new StockDAO();

     */

    @FXML
    public void initialize() {
        // Charge les données depuis l'API
        /*List<Stock> stockList = stockDAO.getAllStocks();

        // Lie les données aux cellules du tableau
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        dateInColumn.setCellValueFactory(cellData -> cellData.getValue().dateInProperty().asString());
        dateOutColumn.setCellValueFactory(cellData -> cellData.getValue().dateOutProperty().asString());
        quantityInColumn.setCellValueFactory(cellData -> cellData.getValue().quantityInProperty().asObject());
        quantityOutColumn.setCellValueFactory(cellData -> cellData.getValue().quantityOutProperty().asObject());
        articleColumn.setCellValueFactory(cellData -> {
            Stock stock = cellData.getValue();
            if (stock != null) {
                Articles articles = stock.getArticle();
                if (articles != null) {
                    return new SimpleStringProperty(articles.getArticleName());
                }
            }
            return new SimpleStringProperty(""); // Retourne une chaîne vide si l'article est null
        });

        // Ajoute les données à la table
        stockTable.getItems().addAll(stockList);*/
    }


    private static Stage deleteStockStage;
    @FXML
    void DeleteStock(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression de stock en même temps)
        if (deleteStockStage == null || !deleteStockStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteStock.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteStockStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteStockStage.setScene(scene);

                // Affiche le nouveau stage
                deleteStockStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static Stage addStockStage;

    @FXML
    void GoToAddStock(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout de stock en même temps)
        if (addStockStage == null || !addStockStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addStock.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addStockStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                addStockStage.setScene(scene);

                // Affiche le nouveau stage
                addStockStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static Stage updateStockStage;

    @FXML
    void GoToUpdateStock(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update de stock en même temps)
        if (updateStockStage == null || !updateStockStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateStock.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateStockStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                updateStockStage.setScene(scene);

                // Affiche le nouveau stage
                updateStockStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterStockById(ActionEvent event) {

        try {
            int id = Integer.parseInt(fieldSearchStockById.getText());

            Stock stock = StockDAO.getStockById(id);

            // Supprime les données existantes dans le tableau
            stockTable.getItems().clear();

            // Ajoute la famille recherchée dans le tableau
            if (stock != null) {
                stockTable.getItems().add(stock);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }

    }

}
