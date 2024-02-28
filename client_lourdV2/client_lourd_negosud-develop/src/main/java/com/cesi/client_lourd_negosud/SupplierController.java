package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.SupplierDAO;
import com.cesi.client_lourd_negosud.models.Address;
import com.cesi.client_lourd_negosud.models.Fournisseur;
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

public class SupplierController {

    @FXML
    private Button buttonSearchSupplierById;

    @FXML
    private TextField fieldSearchSupplierById;

    @FXML
    private Button buttonGoToAddSupplier;

    @FXML
    private Button buttonGoToUpdateSupplier;

    @FXML
    private Button buttonDeleteSupplier;

    @FXML
    private TableView<Fournisseur> supplierTable;

    @FXML
    private TableColumn<Fournisseur, Integer> idColumn;

    @FXML
    private TableColumn<Fournisseur, String> nameColumn;

    @FXML
    private TableColumn<Fournisseur, String> phoneColumn;

    @FXML
    private TableColumn<Fournisseur, String> mailColumn;

    @FXML
    private TableColumn<Fournisseur, String> addressColumn;

    private final SupplierDAO supplierDAO = new SupplierDAO();
    @FXML
    public void initialize() {
        // Charge les données depuis l'API
        List<Fournisseur> fournisseurList = supplierDAO.getAllSupplier();

        // Lie les données aux cellules du tableau
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idSupplierProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().supplierNameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().supplierPhoneProperty());
        mailColumn.setCellValueFactory(cellData -> cellData.getValue().supplierMailProperty());
        addressColumn.setCellValueFactory(cellData -> {
            Fournisseur fournisseur = cellData.getValue();
            if (fournisseur != null) {
                Address address = fournisseur.getAddress();
                if (address != null) {
                    return new SimpleStringProperty(String.valueOf(address.getId()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une chaîne vide si l'article est null
        });

        // Ajoute les données à la table
        supplierTable.getItems().addAll(fournisseurList);
    }

    private static Stage deleteSupplierStage;
    @FXML
    void DeleteSupplier(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression de domaine en même temps)
        if (deleteSupplierStage == null || !deleteSupplierStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteSupplier.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteSupplierStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteSupplierStage.setScene(scene);

                // Affiche le nouveau stage
                deleteSupplierStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static Stage addSupplierStage;

    @FXML
    void GoToAddSupplier(ActionEvent event) {
        // Vérifier si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout de domaines/supplier en même temps)
        if (addSupplierStage == null || !addSupplierStage.isShowing()) {
            try {
                // Charger le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addSupplier.fxml"));
                Parent root = loader.load();

                // Créer une nouvelle scène
                Scene scene = new Scene(root);

                // Créer un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addSupplierStage = new Stage();

                // Mettre la nouvelle scène dans le nouveau stage
                addSupplierStage.setScene(scene);

                // Affiche le nouveau stage
                addSupplierStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static Stage updateSupplierStage;

    @FXML
    void GoToUpdateSupplier(ActionEvent event) {
        // Vérifier si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update de domaine/supplier en même temps)
        if (updateSupplierStage == null || !updateSupplierStage.isShowing()) {
            try {
                // Charger le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateSupplier.fxml"));
                Parent root = loader.load();

                // Créer une nouvelle scène
                Scene scene = new Scene(root);

                // Créer un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateSupplierStage = new Stage();

                // Mettre la nouvelle scène dans le nouveau stage
                updateSupplierStage.setScene(scene);

                // Affiche le nouveau stage
                updateSupplierStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterSupplierById(ActionEvent event) {
        try {
            int id = Integer.parseInt(fieldSearchSupplierById.getText());

            Fournisseur fournisseur = SupplierDAO.getSupplierById(id);

            // Supprime les données existantes dans le tableau
            supplierTable.getItems().clear();

            // Ajoute la famille recherchée dans le tableau
            if (fournisseur != null) {
                supplierTable.getItems().add(fournisseur);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }
    }

}
