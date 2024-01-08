package com.cesi.negosud.dao.commandesClients.model;

import java.sql.Timestamp;

public class CommandesClientsDTO {
    int commandeClient_id;
    Timestamp date;
    int client_id;

    public int getCommandeClient_id() {
        return client_id;
    }

    public void setCommandeClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
