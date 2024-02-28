package com.cesi.client_lourd_negosud.models;

import com.cesi.client_lourd_negosud.utils.Etat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.Timestamp;

public class CommandesClients {
    private final SimpleIntegerProperty commandeClient_id;
    private final ObjectProperty<Timestamp> date;
    private final ObjectProperty<Etat> etat;
    private final ObjectProperty<Personnes> client_id;

    public CommandesClients(@JsonProperty("commandeClient_id") Integer commandeClient_id,
                     @JsonProperty("date") Timestamp date,
                     @JsonProperty("etat") Etat etat,
                     @JsonProperty("client_id") Personnes client_id) {
        this.commandeClient_id = new SimpleIntegerProperty(commandeClient_id);
        this.date = new SimpleObjectProperty<>(date);
        this.etat = new SimpleObjectProperty<>(etat);
        this.client_id = new SimpleObjectProperty<>(client_id);
    }

    public int getCommandeClient_id() {
        return commandeClient_id.get();
    }

    public SimpleIntegerProperty commandeClient_idProperty() {
        return commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id.set(commandeClient_id);
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

    public Etat getEtat() {
        return etat.get();
    }

    public ObjectProperty<Etat> etatProperty() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat.set(etat);
    }

    public Personnes getClient_id() {
        return client_id.get();
    }

    public ObjectProperty<Personnes> client_idProperty() {
        return client_id;
    }

    public void setClient_id(Personnes client_id) {
        this.client_id.set(client_id);
    }
}
