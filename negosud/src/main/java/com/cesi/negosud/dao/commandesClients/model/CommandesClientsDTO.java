package com.cesi.negosud.dao.commandesClients.model;

public class CommandesClientsDTO {
    int commandeClient_id;
    DATE date;
    int adresse_id;

    public int getCommandeClient_id() {
        return client_id;
    }

    public void setCommandeClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getDate() {
        return nom;
    }

    public void setDate(String nom) {
        this.nom = nom;
    }

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }
}
