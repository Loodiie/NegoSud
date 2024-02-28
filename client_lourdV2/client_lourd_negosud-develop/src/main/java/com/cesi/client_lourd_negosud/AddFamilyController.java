package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.FamilyDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class AddFamilyController {

    @FXML
    private Button buttonCancelAddFamily;

    @FXML
    private Button buttonValidateAddFamily;

    @FXML
    private TextField fieldSearchFamilyById;

    @FXML
    private TextField fieldFamilyName;

    @FXML
    private TextField fieldFamilyDescription;

    private final FamilyDAO familyDAO = new FamilyDAO();

    @FXML
    void addAndReturnToFamilyPage(ActionEvent event) {
        try {
            // Créer une nouvelle famille avec les données des champs
            NewFamily newFamily = new NewFamily();
            newFamily.setFamilyName(fieldFamilyName.getText());
            newFamily.setFamilyDescription(fieldFamilyDescription.getText());

            // Afficher une boîte de dialogue de confirmation
            boolean confirmAdd = showConfirmationDialog("Confirmation", "Êtes-vous sûr de vouloir ajouter cette famille ?");

            // Si l'utilisateur confirme l'ajout
            if (confirmAdd) {
                // Appeler FamilyDAO pour créer une nouvelle famille
                familyDAO.createFamily(newFamily); //il faut que ça retourne un boolean pour pouvoir mettre un if et le message dessous dans le else

                // Afficher un message d'ajout réussi ou prendre une autre action si nécessaire
                System.out.println("Nouvelle famille créée avec succès."); //ne jamais corrompt la source de vérité

                // Fermer la scène actuelle (pour revenir sur la page Family initiale)
                closeCurrentStage(event);
            }
            // Sinon, l'utilisateur a annulé l'ajout
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs ici
        }
    }

    //Méthode pour la modale de confirmation d'ajout de la famille
    private boolean showConfirmationDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    // Méthode pour fermer la scène actuelle
    private void closeCurrentStage(ActionEvent event) {
        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Family initiale)
        stage.close();
    }

    @FXML
    void cancelAndReturnToFamilyPage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Family initiale)
        stage.close();

    }

}

