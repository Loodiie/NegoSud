package com.cesi.negosud.controller.familles.model;

import com.cesi.negosud.utils.TypeVin;

public class NewFamilles {
    String libelle;
    TypeVin type_vin;
    String description;
    int annee;
    float degre;
    float prix_unit;
    int seuil;
    int fournisseur_id;
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public float getDegre() {
        return degre;
    }

    public void setDegre(float degre) {
        this.degre = degre;
    }

    public TypeVin getType_vin() {
        return type_vin;
    }
    public void setType_vin(TypeVin type_vin) {
        this.type_vin = type_vin;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

}
