package com.cesi.client_lourd_negosud.models;

import java.sql.Timestamp;

public class LivraisonsClients {
    int livraisonClient_id;
    Timestamp date;
    int commandeClient_id;

    public int getLivraisonClient_id() {
        return this.livraisonClient_id;
    }

    public void setLivraisonClient_id(int livraisonClient_id) {
        this.livraisonClient_id = livraisonClient_id;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getCommandeClient_id() {
        return this.commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id = commandeClient_id;
    }
}
