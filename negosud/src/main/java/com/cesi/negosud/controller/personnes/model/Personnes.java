package com.cesi.negosud.controller.personnes.model;

public class Personnes {
    int personne_id;
    String nom;
    String prenom;
    String telephone;
    String mail;
    String mdp;
    boolean employees;
    int adresse_id;


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isEmployees() {
        return employees;
    }

    public void setEmployees(boolean employees) {
        this.employees = employees;
    }

    public int getPersonne_id() {
        return personne_id;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id = personne_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
