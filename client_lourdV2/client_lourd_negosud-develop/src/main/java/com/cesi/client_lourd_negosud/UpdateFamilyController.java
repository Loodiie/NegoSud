package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.FamilyDAO;
import com.cesi.client_lourd_negosud.models.Familles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class UpdateFamilyController {

    @FXML
    private Button buttonCancelUpdateFamily;

    @FXML
    private Button buttonValidateUpdateFamily;

    @FXML
    private Button buttonSearchFamilyById;

    @FXML
    private TextField fieldSearchFamilyById;

    @FXML
    private TextField fieldFamilyName;

    @FXML
    private TextField fieldFamilyDescription;

    private final FamilyDAO familyDAO = new FamilyDAO();


    @FXML
    void updateAndReturnToFamilyPage(ActionEvent event) { //pas encore fonctionnel car le PUT dans FamilyDAO n'est pas OK

        try {
            // Récupére l'ID de la famille à mettre à jour
            int familyId = Integer.parseInt(fieldSearchFamilyById.getText());

            // Appelle FamilyDAO pour récupérer la famille par son ID
            Familles existingFamilles = familyDAO.getFamilyById(familyId);

            // Vérifie si la famille existe
            if (existingFamilles != null) {
                // Affiche une modale de confirmation
                boolean confirmUpdate = showConfirmationDialog("Confirmation", "Êtes-vous sûr de vouloir modifier cette famille ?");

                // Si l'utilisateur confirme la mise à jour
                if (confirmUpdate) {
                    // Met à jour les données de la famille avec celles des champs
                    existingFamilles.setFamilyName(fieldFamilyName.getText());
                    existingFamilles.setFamilyDescription(fieldFamilyDescription.getText());

                    // Appelle FamilyDAO pour mettre à jour la famille
                    familyDAO.updateFamily(existingFamilles);

                    // Affiche un message de mise à jour réussie
                    System.out.println("Famille mise à jour avec succès.");

                    // Ferme la scène actuelle (pour revenir sur la page Family initiale)
                    closeCurrentStage(event);
                }
                // Sinon, l'utilisateur a annulé la mise à jour
            } else {
                // Ou sinon, la famille n'existe pas
                System.out.println("La famille avec l'ID " + familyId + " n'a pas été trouvée.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de famille valide.");
        }
    }

    //Méthode pour la modale de confirmation de modification de la famille
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
        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Family initiale)
        stage.close();

    }


    @FXML
    void cancelAndReturnToFamilyPage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Family initiale)
        stage.close();

    }

    @FXML
    void searchByIdFamily(ActionEvent event){

        try {
            // Récupére l'ID de la famille à rechercher
            int familyId = Integer.parseInt(fieldSearchFamilyById.getText());

            // Appelle FamilyDAO pour récupérer la famille par son ID
            Familles familles = familyDAO.getFamilyById(familyId);

            // Vérifie si la famille existe
            if (familles != null) {
                // Rempli les champs avec les données de la famille
                fieldFamilyName.setText(familles.getFamilyName());
                fieldFamilyDescription.setText(familles.getFamilyDescription());
            } else {
                // La famille n'existe pas
                System.out.println("La famille avec l'ID " + familyId + " n'a pas été trouvée.");
            }
        } catch (NumberFormatException e) {
            // Gérer l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de famille valide.");
        }


    }

}
