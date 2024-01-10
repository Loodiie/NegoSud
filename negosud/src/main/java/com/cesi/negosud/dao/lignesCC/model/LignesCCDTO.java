package com.cesi.negosud.dao.lignesCC.model;

public class LignesCCDTO {

    int fk_article;
    int fk_CC;
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
