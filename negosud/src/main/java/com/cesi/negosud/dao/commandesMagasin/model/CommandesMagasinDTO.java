package com.cesi.negosud.dao.commandesMagasin.model;

public class CommandesMagasinDTO {
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

    public int getfournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}