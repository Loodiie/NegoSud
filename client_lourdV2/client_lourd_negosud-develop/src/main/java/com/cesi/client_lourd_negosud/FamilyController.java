package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.FamilyDAO;
import com.cesi.client_lourd_negosud.models.Familles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class FamilyController {


    @FXML
    private TableView<Familles> familyTable;
    @FXML
    private TableColumn<Familles, Integer> id_family;
    @FXML
    private TableColumn<Familles, String> family_name;
    @FXML
    private TableColumn<Familles, String> family_description;

    private final FamilyDAO familyDAO = new FamilyDAO();

    @FXML
    private void initialize() {
        // Initialise les colonnes
        id_family.setCellValueFactory(cellData -> cellData.getValue().idFamilyProperty().asObject());
        family_name.setCellValueFactory(cellData -> cellData.getValue().familyNameProperty());
        family_description.setCellValueFactory(cellData -> cellData.getValue().familyDescriptionProperty());

        // Charge les données dans la table
        loadDataIntoTable();
    }

    private void loadDataIntoTable() {
        // Récupère la liste des familles depuis l'API
        List<Familles> famillesList = familyDAO.getAllFamily();

        // Crée une ObservableList à partir de la liste pour la liaison avec la table
        ObservableList<Familles> observableFamillesList = FXCollections.observableArrayList(famillesList);

        // Lie les données de la liste à la table
        familyTable.setItems(observableFamillesList);
    }


    @FXML
    private Button buttonSearchFamilyById;

    @FXML
    private Button buttonGoToAddFamily;

    @FXML
    private Button buttonGoToUpdateFamily;

    @FXML
    private Button buttonDeleteFamily;

    @FXML
    private TextField fieldSearchFamilyById;

    private static Stage deleteFamilyStage;
    @FXML
    void DeleteFamily(ActionEvent event) {

        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression de famille de vin en même temps)
        if (deleteFamilyStage == null || !deleteFamilyStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteFamily.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteFamilyStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteFamilyStage.setScene(scene);

                // Affiche le nouveau stage
                deleteFamilyStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static Stage addFamilyStage;

    @FXML
    void GoToAddFamily(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout de famille de vin en même temps)
        if (addFamilyStage == null || !addFamilyStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addFamily.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addFamilyStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                addFamilyStage.setScene(scene);

                // Affiche le nouveau stage
                addFamilyStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Stage updateFamilyStage;

    @FXML
    void GoToUpdateFamily(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update d'une famille de vin en même temps)
        if (updateFamilyStage == null || !updateFamilyStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateFamily.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateFamilyStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                updateFamilyStage.setScene(scene);

                // Affiche le nouveau stage
                updateFamilyStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterFamilyById(ActionEvent event) {

        try {
            int id = Integer.parseInt(fieldSearchFamilyById.getText());
            Familles familles = familyDAO.getFamilyById(id);

            // Supprime les données existantes dans le tableau
            familyTable.getItems().clear();

            // Ajoute la famille recherchée dans le tableau
            if (familles != null) {
                familyTable.getItems().add(familles);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }

    }



}
