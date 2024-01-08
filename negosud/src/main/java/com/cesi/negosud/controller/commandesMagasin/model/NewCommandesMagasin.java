package com.cesi.negosud.controller.commandesMagasin.model;

import java.sql.Timestamp;

public class NewCommandesMagasin {
    Timestamp date;
    int fournisseur_id;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp nom) {
        this.date = date;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}
