package com.cesi.negosud.controller.lignesCM.model;

public class NewLignesCM {
    int fk_article;
    int fk_CM;

    public int getFk_article() {
        return fk_article;
    }

    public void setFk_article(int fk_article) {
        this.fk_article = fk_article;
    }

    public int getFk_CM() {
        return fk_CM;
    }

    public void setFk_CM(int fk_CM) {
        this.fk_CM = fk_CM;
    }
}
