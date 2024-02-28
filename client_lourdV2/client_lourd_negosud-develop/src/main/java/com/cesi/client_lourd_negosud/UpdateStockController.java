package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.StockDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UpdateStockController {

    @FXML
    private Button buttonCancelUpdateStock;

    @FXML
    private Button buttonValidateUpdateStock;

    @FXML
    private Button buttonSearchByIdStock;

    @FXML
    private DatePicker fieldDateIn;

    @FXML
    private DatePicker fieldDateOut;

    @FXML
    private TextField fieldQuantityIn;

    @FXML
    private TextField fieldQuantityOut;

    @FXML
    private TextField fieldArticle;

    @FXML
    private TextField fieldSearchStockById;

    private final StockDAO stockDAO = new StockDAO();

    @FXML
    void cancelAndReturnToStockPage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Stock initiale)
        stage.close();

    }

    @FXML
    void searchByIdStock(ActionEvent event) {

        try {
            // Récupére l'ID du stock à rechercher
            int stockId = Integer.parseInt(fieldSearchStockById.getText());

            // Appelle StockDAO pour récupérer le stock par son ID
            Stock stock = stockDAO.getStockById(stockId);

            // Vérifie si le stock existe
            if (stock != null) {
                // Rempli les champs avec les données du stock
                if (stock.getDateIn() != null) { //ajout de cette condition car un champ null dans javaFX peut bloquer l'affichage des autres champs
                    fieldDateIn.setValue(stock.getDateIn().toLocalDateTime().toLocalDate());
                }
                if (stock.getDateOut() != null) {
                    fieldDateOut.setValue(stock.getDateOut().toLocalDateTime().toLocalDate());
                }
                fieldQuantityIn.setText(String.valueOf(stock.getQuantityIn()));
                fieldQuantityOut.setText(String.valueOf(stock.getQuantityOut()));
                fieldArticle.setText(stock.getArticle().getArticleName());
            } else {
                // Le stock n'existe pas
                System.out.println("Le stock avec l'ID " + stockId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de stock valide.");
        }

    }

    @FXML
    void updateAndReturnToStockPage(ActionEvent event) {

    }


}
