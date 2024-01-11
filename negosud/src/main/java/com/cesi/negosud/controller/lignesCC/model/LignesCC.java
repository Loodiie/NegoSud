package com.cesi.negosud.controller.lignesCC.model;

public class LignesCC {
    int id_LigneCC;
    int fk_article;
    int fk_CC;
    public int getId_LigneCC() {
        return id_LigneCC;
    }

    public void setId_LigneCC(int id_LigneCC) {
        this.id_LigneCC = id_LigneCC;
    }

    public int getFk_article() {
        return fk_article;
    }

    public void setFk_article(int fk_article) {
        this.fk_article = fk_article;
    }

    public int getFk_CC() {
        return fk_CC;
    }

    public void setFk_CC(int fk_CC) {
        this.fk_CC = fk_CC;
    }
}
