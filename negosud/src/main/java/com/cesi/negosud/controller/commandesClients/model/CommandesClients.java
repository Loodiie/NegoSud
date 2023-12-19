package com.cesi.negosud.controller.commandesClients.model;

public class CommandesClients {
    int commandeClient_id;
    DATE date;
    int client_id;

    public int getCommandeClient_id() {
        return commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id = commandeClient_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
