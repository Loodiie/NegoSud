package com.cesi.client_lourd_negosud;


import com.cesi.client_lourd_negosud.dao.UsersDAO;
import com.cesi.client_lourd_negosud.models.Address;
import com.cesi.client_lourd_negosud.models.Personnes;
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

public class UsersController {
    @FXML
    private Button buttonSearchUsersById;

    @FXML
    private TextField fieldSearchUsersById;

    @FXML
    private Button buttonGoToAddUsers;

    @FXML
    private Button buttonGoToUpdateUsers;

    @FXML
    private Button buttonDeleteUsers;

    @FXML
    private TableView<Personnes> usersTable;

    @FXML
    private TableColumn<Personnes, Integer> idColumn;

    @FXML
    private TableColumn<Personnes, String> userNameColumn;

    @FXML
    private TableColumn<Personnes, String> userSurnameColumn;

    @FXML
    private TableColumn<Personnes, String> userPhoneColumn;

    @FXML
    private TableColumn<Personnes, String> userEmailColumn;

    @FXML
    private TableColumn<Personnes, String> passwordColumn;

    @FXML
    private TableColumn<Personnes, Boolean> adminColumn;

    @FXML
    private TableColumn<Personnes, String> addressColumn;

    private final UsersDAO usersDAO = new UsersDAO();

    @FXML
    public void initialize() {
        // Charge les données depuis l'API
        List<Personnes> personnesList = usersDAO.getAllUsers();

        // Lie les données aux cellules du tableau
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idUserProperty().asObject());
        userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        userSurnameColumn.setCellValueFactory(cellData -> cellData.getValue().userSurnameProperty());
        userPhoneColumn.setCellValueFactory(cellData -> cellData.getValue().userPhoneProperty());
        userEmailColumn.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        adminColumn.setCellValueFactory(cellData -> cellData.getValue().adminProperty().asObject());
        addressColumn.setCellValueFactory(cellData -> {
            Personnes personnes = cellData.getValue();
            if (personnes != null) {
                Address address = personnes.getAddress();
                if (address != null) {
                    return new SimpleStringProperty(String.valueOf(address.getId()));
                }
            }
            return new SimpleStringProperty(""); // Retourne une chaîne vide si l'article est null
        });

        // Ajoute les données à la table
        usersTable.getItems().addAll(personnesList);
    }


    private static Stage deleteUsersStage;
    @FXML
    void DeleteUsers(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre de suppression de client en même temps)
        if (deleteUsersStage == null || !deleteUsersStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteUsers.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                deleteUsersStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                deleteUsersStage.setScene(scene);

                // Affiche le nouveau stage
                deleteUsersStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static Stage addUsersStage;

    @FXML
    void GoToAddUsers(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'ajout de client en même temps)
        if (addUsersStage == null || !addUsersStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addUsers.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                addUsersStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                addUsersStage.setScene(scene);

                // Affiche le nouveau stage
                addUsersStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static Stage updateUsersStage;

    @FXML
    void GoToUpdateUsers(ActionEvent event) {
        // Vérifie si la scène est déjà ouverte (pour qu'il ne soit pas possible d'ouvrir une autre fenêtre d'update de client en même temps)
        if (updateUsersStage == null || !updateUsersStage.isShowing()) {
            try {
                // Charge le fichier FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateUsers.fxml"));
                Parent root = loader.load();

                // Créé une nouvelle scène
                Scene scene = new Scene(root);

                // Créé un nouveau stage pour ne pas fermer la page actuelle mais s'ajouter en plus
                updateUsersStage = new Stage();

                // Met la nouvelle scène dans le nouveau stage
                updateUsersStage.setScene(scene);

                // Affiche le nouveau stage
                updateUsersStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void filterUsersById(ActionEvent event) {

        try {
            int id = Integer.parseInt(fieldSearchUsersById.getText());

            Personnes personnes = UsersDAO.getUserById(id);

            // Supprime les données existantes dans le tableau
            usersTable.getItems().clear();

            // Ajoute la famille recherchée dans le tableau
            if (personnes != null) {
                usersTable.getItems().add(personnes);
            }
        } catch (NumberFormatException e) {
            // Exception dans le cas où l'utilisateur entre une valeur de mauvais type
            e.printStackTrace();
        }

    }
}
