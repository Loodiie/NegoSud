package com.cesi.client_lourd_negosud.models;

import com.cesi.client_lourd_negosud.utils.Etat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.Timestamp;

public class CommandesMagasin {
    private final SimpleIntegerProperty commandesMag_id;
    private final ObjectProperty<Timestamp> date;
    private final ObjectProperty<Fournisseur> fournisseur_id;

    public CommandesMagasin(@JsonProperty("commandesMag_id") Integer commandesMag_id,
                            @JsonProperty("date") Timestamp date,
                            @JsonProperty("client_id") Fournisseur fournisseur_id) {
        this.commandesMag_id = new SimpleIntegerProperty(commandesMag_id);
        this.date = new SimpleObjectProperty<>(date);
        this.fournisseur_id = new SimpleObjectProperty<>(fournisseur_id);
    }

    public int getCommandesMag_id() {
        return commandesMag_id.get();
    }

    public SimpleIntegerProperty commandesMag_idProperty() {
        return commandesMag_id;
    }

    public void setCommandesMag_id(int commandesMag_id) {
        this.commandesMag_id.set(commandesMag_id);
    }

    public Timestamp getDate() {
        return date.get();
    }

    public ObjectProperty<Timestamp> dateProperty() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date.set(date);
    }

    public Fournisseur getFournisseur_id() {
        return fournisseur_id.get();
    }

    public ObjectProperty<Fournisseur> fournisseur_idProperty() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Fournisseur fournisseur_id) {
        this.fournisseur_id.set(fournisseur_id);
    }
}
