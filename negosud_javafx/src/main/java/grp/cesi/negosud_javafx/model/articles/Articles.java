package grp.cesi.negosud_javafx.model.articles;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.Serializable;

public class Articles implements Serializable {

    int article_id;
    float tva;
    float reduction;
    int offert;
    int famille_id;
    int carton_id;
    int commandesM_id;
    int commandesC_id;

    public Articles(){
        super();
    }
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

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
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
