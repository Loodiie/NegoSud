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

public class DeleteFamilyController {

    @FXML
    private Button buttonSearchFamilyById;

    @FXML
    private Button buttonValidateDeleteFamily;

    @FXML
    private Button buttonCancelDeleteFamily;
    @FXML
    private TextField fieldSearchFamilyById;

    @FXML
    private TextField fieldFamilyName;

    @FXML
    private TextField fieldFamilyDescription;

    private final FamilyDAO familyDAO = new FamilyDAO();

    @FXML
    void cancelAndReturnToFamilyPage(ActionEvent event) {

        // Récupére le bouton actuel pour obtenir la scène
        Node buttonCancelDeleteFamily = (Node) event.getSource();
        Stage stage = (Stage) buttonCancelDeleteFamily.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Family initiale)
        stage.close();

    }

    @FXML
    void searchByIdFamily(ActionEvent event) {

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
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de famille valide.");
        }

    }

    @FXML
    void deleteAndReturnToFamilyPage(ActionEvent event) {

        try {
            // Récupére l'ID de la famille à rechercher
            int familyId = Integer.parseInt(fieldSearchFamilyById.getText());

            // Appelle FamilyDAO pour récupérer la famille par son ID
            Familles familles = familyDAO.getFamilyById(familyId);

            // Vérifie si la famille existe
            if (familles != null) {
                // Demande confirmation à l'utilisateur pour la suppression
                boolean confirmDelete = showDeleteConfirmationDialog();
                if (confirmDelete) {
                    // Supprime la famille
                    familyDAO.deleteFamily(familyId);

                    // Ferme la fenêtre actuelle (retourner sur la page Family initiale)
                    Node buttonDeleteFamily = (Node) event.getSource();
                    Stage stage = (Stage) buttonDeleteFamily.getScene().getWindow();
                    stage.close();
                }
            } else {
                // La famille n'existe pas
                System.out.println("La famille avec l'ID " + familyId + " n'a pas été trouvée.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de famille valide.");
        }

    }

    //Modale de confirmation de suppression de la famille
    private boolean showDeleteConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer la famille");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer cette famille ?");

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
