package com.cesi.negosud.controller.articles.model;

public class NewArticles {
    float tva;
    float reduction;
    int offert;
    int famille_id;
    int carton_id;
    int commandesM_id;
    int commandesC_id;

    public int getCommandesM_id() {
        return commandesM_id;
    }

    public void setCommandesM_id(int commandesM_id) {
        this.commandesM_id = commandesM_id;
    }

    public int getCommandesC_id() {
        return commandesC_id;
    }

    public void setCommandesC_id(int commandesC_id) {
        this.commandesC_id = commandesC_id;
    }



    public int getCarton_id() {
        return carton_id;
    }

    public void setCarton_id(int carton_id) {
        this.carton_id = carton_id;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public int getOffert() {
        return offert;
    }

    public void setOffert(int offert) {
        this.offert = offert;
    }

    public int getFamille_id() {
        return famille_id;
    }

    public void setFamille_id(int famille_id) {
        this.famille_id = famille_id;
    }
}
