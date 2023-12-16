package com.cesi.negosud.dao.articles.model;

public class ArticlesDTO {

    int article_id;
    String designation;
    String description;
    float prix_unit;
    int seuil;
    float tva;
    float reduction;
    int offert;
    int famille_id;
    int fournisseur_id;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(float prix_unit) {
        this.prix_unit = prix_unit;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
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

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
}
