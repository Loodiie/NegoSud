package com.cesi.client_lourd_negosud;


import com.cesi.client_lourd_negosud.dao.UsersDAO;
import com.cesi.client_lourd_negosud.models.Personnes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class DeleteUsersController {
    @FXML
    private Button buttonSearchByIdUsers;

    @FXML
    private Button buttonValidateDeleteUsers;

    @FXML
    private Button buttonCancelDeleteUsers;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSurname;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldStreetNum;

    @FXML
    private TextField fieldPrecision;

    @FXML
    private TextField fieldStreet;

    @FXML
    private TextField fieldCity;

    @FXML
    private TextField fieldPostalCode;

    @FXML
    private TextField fieldSearchUsersById;

    private final UsersDAO usersDAO = new UsersDAO();

    @FXML
    void cancelAndReturnToUsersPage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page users initiale)
        stage.close();

    }

    @FXML
    void searchByIdUsers(ActionEvent event) {

        try {
            // Récupére l'ID du users à rechercher
            int usersId = Integer.parseInt(fieldSearchUsersById.getText());

            // Appelle usersDAO pour récupérer le users par son ID
            Personnes personnes = usersDAO.getUserById(usersId);

            // Vérifie si le client existe
            if (personnes != null) {
                // Rempli les champs avec les données du client
                if (personnes.getUserPhone() != null) { //ajout de cette condition car un champ null dans javaFX peut bloquer l'affichage des autres champs
                    fieldPhone.setText(personnes.getUserPhone());
                }
                fieldName.setText(String.valueOf(personnes.getUserName()));
                fieldSurname.setText(String.valueOf(personnes.getUserSurname()));
                fieldPhone.setText(String.valueOf(personnes.getUserPhone()));
                fieldEmail.setText(String.valueOf(personnes.getUserEmail()));
                fieldStreetNum.setText(String.valueOf(personnes.getAddress().getStreetNum()));
                fieldPrecision.setText(String.valueOf(personnes.getAddress().getPrecision()));
                fieldStreet.setText(String.valueOf(personnes.getAddress().getStreet()));
                fieldCity.setText(String.valueOf(personnes.getAddress().getCity()));
                fieldPostalCode.setText(String.valueOf(personnes.getAddress().getPostalCode()));


            } else {
                // Le client n'existe pas
                System.out.println("Le client avec l'ID " + usersId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de client valide.");
        }

    }


    @FXML
    void deleteAndReturnToUsersPage(ActionEvent event) {

        try {
            // Récupére l'ID du client à rechercher
            int usersId = Integer.parseInt(fieldSearchUsersById.getText());

            // Appelle UsersDAO pour récupérer le client par son ID
            Personnes personnes = usersDAO.getUserById(usersId);

            // Vérifie si le client existe
            if (personnes != null) {
                // Demande confirmation à l'utilisateur pour la suppression
                boolean confirmDelete = showDeleteConfirmationDialog();
                if (confirmDelete) {
                    // Supprime le client
                    usersDAO.deleteUsers(usersId);

                    // Ferme la fenêtre actuelle (retourner sur la page client initiale)
                    Node buttonDeleteUsers = (Node) event.getSource();
                    Stage stage = (Stage) buttonDeleteUsers.getScene().getWindow();
                    stage.close();
                }
            } else {
                // Le client n'existe pas
                System.out.println("Le client avec l'ID " + usersId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gérer l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de client valide.");
        }

    }

    //Modale de confirmation de suppression du client
    private boolean showDeleteConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le client");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce client ?");

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
