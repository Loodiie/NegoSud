package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.WineOrderDAO;
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

public class WineOrderController {

    @FXML
    private Button buttonSearchWineOrderById;

    @FXML
    private TextField fieldSearchWineOrderById;

    @FXML
    private Button buttonGoToAddWineOrder;

    @FXML
    private Button buttonGoToUpdateWineOrder;

    @FXML
    private Button buttonDeleteWineOrder;

    @FXML
    private TableView<WineOrder> wineOrderTable;

    @FXML
    private TableColumn<WineOrder, Integer> idColumn;

    @FXML
    private TableColumn<WineOrder, String> dateColumn;

    @FXML
    private TableColumn<WineOrder, String> orderStatusColumn;

    @FXML
    private TableColumn<WineOrder, String> typeColumn;

    @FXML
    private TableColumn<WineOrder, String> cartStatusColumn;

    @FXML
    private TableColumn<WineOrder, String> addressColumn;

    @FXML
    private TableColumn<WineOrder, String> supplierColumn;

    @FXML
    private TableColumn<WineOrder, String> usersColumn;

    private final WineOrderDAO wineOrderDAO = new WineOrderDAO();

    @FXML
    public void initialize() {
        // Charge les données depuis l'API
        List<WineOrder> wineOrderList = wineOrderDAO.getAllWineOrders();

        // Lie les données aux cellules du tableau
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty().asString());
        orderStatusColumn.setCellValueFactory(cellData -> cellData.getValue().orderStatusProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        cartStatusColumn.setCellValueFactory(cellData -> cellData.getValue().cartStatusProperty());
        addressColumn.setCellValueFactory(cellData -> {
            WineOrder wineOrder = cellData.getValue();
            if (wineOrder != null) {
                Address address = wineOrder.getAddress();
                if (address != null) {
                    return new SimpleStringProperty(String.valueOf(address.getId()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une string vide si l'Adresse est null
        });
        supplierColumn.setCellValueFactory(cellData -> {
            WineOrder wineOrder = cellData.getValue();
            if (wineOrder != null) {
                Fournisseur fournisseur = wineOrder.getSupplier();
                if (fournisseur != null) {
                    return new SimpleStringProperty(String.valueOf(fournisseur.getIdSupplier()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une string vide si le Supplier est null
        });
        usersColumn.setCellValueFactory(cellData -> {
            WineOrder wineOrder = cellData.getValue();
            if (wineOrder != null) {
                Personnes personnes = wineOrder.getUsers();
                if (personnes != null) {
                    return new SimpleStringProperty(String.valueOf(personnes.getPersonne_id()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une string vide si le User est null
        });

        // Ajoute les données à la table
        wineOrderTable.getItems().addAll(wineOrderList);
    }

    private static Stage deleteWineOrderStage;

    @FXML
    void DeleteWineOrder(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression d'une commande en même temps)
        if (deleteWineOrderStage == null || !deleteWineOrderStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteWineOrder.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteWineOrderStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteWineOrderStage.setScene(scene);

                // Affiche le nouveau stage
                deleteWineOrderStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Stage addWineOrderStage;

    @FXML
    void GoToAddWineOrder(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout d'une commande en même temps)
        if (addWineOrderStage == null || !addWineOrderStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addWineOrder.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addWineOrderStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                addWineOrderStage.setScene(scene);

                // Affiche le nouveau stage
                addWineOrderStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Stage updateWineOrderStage;

    @FXML
    void GoToUpdateWineOrder(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update d'une commande en même temps)
        if (updateWineOrderStage == null || !updateWineOrderStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateWineOrder.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateWineOrderStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                updateWineOrderStage.setScene(scene);

                // Affiche le nouveau stage
                updateWineOrderStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterWineOrderById(ActionEvent event) {
        try {
            int id = Integer.parseInt(fieldSearchWineOrderById.getText());

            WineOrder wineOrder = wineOrderDAO.getWineOrderById(id);

            // Supprime les données existantes dans le tableau
            wineOrderTable.getItems().clear();

            // Ajoute la commande recherchée dans le tableau
            if (wineOrder != null) {
                wineOrderTable.getItems().add(wineOrder);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }
    }

}
