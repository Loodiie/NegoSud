package com.cesi.negosud.controller.commandesMagasin.model;

import java.sql.Timestamp;

public class CommandesMagasin {
    int commandeMag_id;
    Timestamp date;
    int fournisseur_id;

    public int getCommandeMag_id() {
        return commandeMag_id;
    }

    public void setCommandeMag_id(int commandeMag_id) {
        this.commandeMag_id = commandeMag_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}
