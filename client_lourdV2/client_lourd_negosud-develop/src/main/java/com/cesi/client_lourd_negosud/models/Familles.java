package com.cesi.client_lourd_negosud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.*;

import java.lang.reflect.Type;

public class Familles {

    private final SimpleIntegerProperty famille_id;
    private final SimpleStringProperty libelle;
    private final SimpleObjectProperty<TypeVin> type_vin;
    private final SimpleStringProperty description;
    private final SimpleIntegerProperty annee;
    private final SimpleFloatProperty degre;
    private final SimpleFloatProperty prix_unit;
    private final SimpleIntegerProperty seuil;
    private final SimpleBooleanProperty actif;
    private final SimpleObjectProperty<Fournisseur> fournisseur;

    public Familles(@JsonProperty("famille_id") int famille_id,
                    @JsonProperty("libelle") String libelle,
                    @JsonProperty("type_vin") TypeVin type_vin,
                    @JsonProperty("description") String description,
                    @JsonProperty("annee") int annee,
                    @JsonProperty("degre") float degre,
                    @JsonProperty("prix_unit") float prix_unit,
                    @JsonProperty("seuil") int seuil,
                    @JsonProperty("actif") boolean actif,
                    @JsonProperty("fournisseur") Fournisseur fournisseur){
        this.famille_id = new SimpleIntegerProperty(famille_id);
        this.libelle = new SimpleStringProperty(libelle);
        this.type_vin = new SimpleObjectProperty<>(type_vin);
        this.description = new SimpleStringProperty(description);
        this.annee = new SimpleIntegerProperty(annee);
        this.degre = new SimpleFloatProperty(degre);
        this.prix_unit = new SimpleFloatProperty(prix_unit);
        this.seuil = new SimpleIntegerProperty(seuil);
        this.actif = new SimpleBooleanProperty(actif);
        this.fournisseur = new SimpleObjectProperty<>(fournisseur);
    }

}
