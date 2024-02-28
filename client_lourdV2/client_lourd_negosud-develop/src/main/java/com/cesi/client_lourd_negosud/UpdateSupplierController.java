package com.cesi.client_lourd_negosud;

import com.cesi.client_lourd_negosud.dao.SupplierDAO;
import com.cesi.client_lourd_negosud.models.Fournisseur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSupplierController {

    @FXML
    private Button buttonCancelUpdateSupplier;

    @FXML
    private Button buttonValidateUpdateSupplier;

    @FXML
    private Button buttonSearchSupplierById;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldMail;

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
    private TextField fieldSearchSupplierById;

    private final SupplierDAO supplierDAO = new SupplierDAO();

    @FXML
    void cancelAndReturnToSupplierPage(ActionEvent event) {

        // Récupérer le bouton actuel pour obtenir la scène
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Ferme la scène actuelle (pour revenir sur la page Supplier initiale)
        stage.close();

    }

    @FXML
    void searchByIdSupplier(ActionEvent event) {
        try {
            // Récupére l'ID du domaine à rechercher
            int supplierId = Integer.parseInt(fieldSearchSupplierById.getText());

            // Appelle SupplierDAO pour récupérer le domaine par son ID
            Fournisseur fournisseur = supplierDAO.getSupplierById(supplierId);

            // Vérifie si le domaine existe
            if (fournisseur != null) {
                // Rempli les champs avec les données du domaine
                if (fournisseur.getSupplierPhone() != null) { //ajout de cette condition car un champ null dans javaFX peut bloquer l'affichage des autres champs
                    fieldPhone.setText(fournisseur.getSupplierPhone());
                }
                fieldName.setText(String.valueOf(fournisseur.getSupplierName()));
                fieldMail.setText(String.valueOf(fournisseur.getSupplierMail()));
                fieldStreetNum.setText(String.valueOf(fournisseur.getAddress().getStreetNum()));
                fieldPrecision.setText(String.valueOf(fournisseur.getAddress().getPrecision()));
                fieldStreet.setText(String.valueOf(fournisseur.getAddress().getStreet()));
                fieldCity.setText(String.valueOf(fournisseur.getAddress().getCity()));
                fieldPostalCode.setText(String.valueOf(fournisseur.getAddress().getPostalCode()));

            } else {
                // Le domaine n'existe pas
                System.out.println("Le domaine avec l'ID " + supplierId + " n'a pas été trouvé.");
            }
        } catch (NumberFormatException e) {
            // Gére l'exception si l'utilisateur n'a pas entré un ID valide
            System.out.println("Veuillez entrer un ID de domaine valide.");
        }

    }

    @FXML
    void updateAndReturnToSupplierPage(ActionEvent event) {

    }

}
