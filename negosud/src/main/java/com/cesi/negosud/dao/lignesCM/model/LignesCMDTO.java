package com.cesi.negosud.dao.lignesCM.model;

public class LignesCMDTO {

    int ligneComMag_id;
    int fk_article;
    int fk_CM;
    public int getLigneComMag_id() {
        return ligneComMag_id;
    }
    public void setLigneComMag_id(int ligneComMag_id) {
        this.ligneComMag_id = ligneComMag_id;
    }

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
