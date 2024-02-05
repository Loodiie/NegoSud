package grp.cesi.negosud_javafx.model.articles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

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


    public Articles(@JsonProperty("article_id") int article_id,
                    @JsonProperty("tva") float tva,
                    @JsonProperty("reduction") float reduction,
                    @JsonProperty("offert") int offert,
                    @JsonProperty("famille_id") int famille_id,
                    @JsonProperty("carton_id") int carton_id,
                    @JsonProperty("commandesM_id") int commandesM_id,
                    @JsonProperty("commandesC_id") int commandesC_id) {
        this.article_id = article_id;
        this.tva = tva;
        this.reduction = reduction;
        this.offert = offert;
        this.famille_id = famille_id;
        this.carton_id = carton_id;
        this.commandesM_id = commandesM_id;
        this.commandesC_id = commandesC_id;
    }

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

    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }
}
