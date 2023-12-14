package com.cesi.negosud.dao.fournisseurs.model;

public class FournisseursDTO {
    int fournisseurs_id;
    String nom;
    String telephone;
    String mail;
    int adresse_id;

    public int getFournisseurs_id() {
        return fournisseurs_id;
    }

    public void setFournisseurs_id(int fournisseurs_id) {
        this.fournisseurs_id = fournisseurs_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }
}
