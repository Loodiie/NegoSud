package com.cesi.negosud.controller.commandesMagasin.model;

public class CommandesMagasin {
    int commandeMag_id;
    DATE date;
    int fournisseur_id;

    public int getCommandeMag_id() {
        return commandeMag_id;
    }

    public void setCommandeMag_id(int commandeMag_id) {
        this.commandeMag_id = commandeMag_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}
