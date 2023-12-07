package com.cesi.negosud.dao.familles.model;

public class FamillesDTO {
    int famille_id;
    String libelle;
    String date;

    public int getFamille_id() {
        return famille_id;
    }

    public void setFamille_id(int famille_id) {
        this.famille_id = famille_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}


