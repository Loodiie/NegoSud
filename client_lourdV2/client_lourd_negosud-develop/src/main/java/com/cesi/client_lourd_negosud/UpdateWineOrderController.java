package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.WineOrderDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateWineOrderController {

    @FXML
    private DatePicker fieldDate;

    @FXML
    private TextField fieldOrderStatus;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldCartStatus;

    @FXML
    private TextField fieldSupplier;

    @FXML
    private TextField fieldIdUser;

    @FXML
    private Button buttonCancelAddWineOrder;

    @FXML
    private Button buttonValidateAddWineOrder;

    @FXML
    private TextField fieldIdAddress;

    @FXML
    private TextField fieldSearchWineOrderById;

    @FXML
    private Button buttonSearchWineOrderById;

    private final WineOrderDAO wineOrderDAO = new WineOrderDAO();


    @FXML
    void addAndReturnToWineOrderPage(ActionEvent event) {

    }

    @FXML
    void searchByIdWineOrder(ActionEvent event) {

        try{
            // Récupére l'ID de la commande à rechercher
            int wineOrderId = Integer.parseInt(fieldSearchWineOrderById.getText());

            // Appelle WineOrderDAO pour récupérer la commande par son ID
            WineOrder wineOrder = wineOrderDAO.getWineOrderById(wineOrderId);

            // Vérifie si la commande existe
            if (wineOrder != null) {
                // Rempli les champs avec les données de la commande
                if (wineOrder.getDate() != null) { //ajout de cette condition car un champ null dans javaFX peut bloquer l'affichage des autres champs
                    fieldDate.setValue(wineOrder.getDate().toLocalDateTime().toLocalDate());
                }
                fieldOrderStatus.setText(wineOrder.getOrderStatus());
                fieldType.setText(wineOrder.getType());
                fieldCartStatus.setText(wineOrder.getCartStatus());
                if (wineOrder.getSupplier() != null) {
                    fieldSupplier.setText(wineOrder.getSupplier().getSupplierName());
                }
                if (wineOrder.getUsers() != null) {
                    fieldIdUser.setText(String.valueOf(wineOrder.getUsers().getIdUser()));
                }
                if (wineOrder.getAddress() != null) {
                    fieldIdAddress.setText(String.valueOf(wineOrder.getAddress().getId()));
                }
            } else {
                // La commande n'existe pas
                System.out.println("La commande avec l'ID " + wineOrderId + " n'a pas été trouvée.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de commande valide.");
        }

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
