package com.cesi.client_lourd_negosud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.*;


public class Articles {

    private final SimpleIntegerProperty article_id;
    private final SimpleFloatProperty tva;
    private final SimpleFloatProperty reduction;
    private final SimpleIntegerProperty offert;
    private final ObjectProperty<Familles> famille;
    private final ObjectProperty<Cartons> carton;
    private final ObjectProperty<CommandesMagasin> commandesM;
    private final ObjectProperty<CommandesClients> commandesC;


    public Articles(@JsonProperty("article_id") int article_id,
                    @JsonProperty("tva") Float tva,
                    @JsonProperty("reduction")Float reduction,
                    @JsonProperty("offert") int offert,
                    @JsonProperty("famille") Familles famille,
                    @JsonProperty("carton") Cartons cartons,
                    @JsonProperty("commandesM") CommandesMagasin commandesM,
                    @JsonProperty("commandesC") CommandesClients commandesC) {
        this.article_id = new SimpleIntegerProperty(article_id);
        this.tva = new SimpleFloatProperty(tva);
        this.reduction = new SimpleFloatProperty(reduction);
        this.offert = new SimpleIntegerProperty(offert);
        this.famille = new SimpleObjectProperty<Familles>(famille);
        this.carton = new SimpleObjectProperty<Cartons>(cartons);
        this.commandesM = new SimpleObjectProperty<CommandesMagasin>(commandesM);
        this.commandesC = new SimpleObjectProperty<CommandesClients>(commandesC);
    }

    public int getArticle_id() {
        return article_id.get();
    }

    public SimpleIntegerProperty article_idProperty() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id.set(article_id);
    }

    public float getTva() {
        return tva.get();
    }

    public SimpleFloatProperty tvaProperty() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva.set(tva);
    }

    public float getReduction() {
        return reduction.get();
    }

    public SimpleFloatProperty reductionProperty() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction.set(reduction);
    }

    public int getOffert() {
        return offert.get();
    }

    public SimpleIntegerProperty offertProperty() {
        return offert;
    }

    public void setOffert(int offert) {
        this.offert.set(offert);
    }

    public Familles getFamille() {
        return famille.get();
    }

    public ObjectProperty<Familles> familleProperty() {
        return famille;
    }

    public void setFamille(Familles famille) {
        this.famille.set(famille);
    }

    public Cartons getCarton() {
        return carton.get();
    }

    public ObjectProperty<Cartons> cartonProperty() {
        return carton;
    }

    public void setCarton(Cartons cartons) {
        this.carton.set(cartons);
    }

    public CommandesMagasin getCommandesM() {
        return commandesM.get();
    }

    public ObjectProperty<CommandesMagasin> commandesMProperty() {
        return commandesM;
    }

    public void setCommandesM(CommandesMagasin commandesM) {
        this.commandesM.set(commandesM);
    }

    public CommandesClients getCommandesC() {
        return commandesC.get();
    }

    public ObjectProperty<CommandesClients> commandesCProperty() {
        return commandesC;
    }

    public void setCommandesC(CommandesClients commandesC) {
        this.commandesC.set(commandesC);
    }
}
