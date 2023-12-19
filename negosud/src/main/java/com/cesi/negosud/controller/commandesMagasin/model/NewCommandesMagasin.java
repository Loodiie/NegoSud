package com.cesi.negosud.controller.commandesMagasin.model;

public class NewCommandesMagasin {
    DATE date;
    int fournisseur_id;

    public String getDate() {
        return date;
    }

    public void setDate(String nom) {
        this.date = date;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}
