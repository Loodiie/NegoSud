package com.cesi.negosud.dao.lignesCC.model;

public class LignesCCDTO {
    int id_ligneCC;

    int fk_article;
    int fk_CC;
    public int getId_ligneCC() {
        return id_ligneCC;
    }

    public void setId_ligneCC(int id_ligneCC) {
        this.id_ligneCC = id_ligneCC;
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
