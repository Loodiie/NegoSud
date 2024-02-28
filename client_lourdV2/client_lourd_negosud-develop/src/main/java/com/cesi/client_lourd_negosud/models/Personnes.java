package com.cesi.client_lourd_negosud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.*;

public class Personnes {

    private final SimpleIntegerProperty personne_id;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty prenom;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty mail;
    private final SimpleStringProperty mdp;
    private final SimpleBooleanProperty employees;
    private final ObjectProperty<Adresses> adresse;


    public Personnes(@JsonProperty("personne_id") Integer personne_id,
                     @JsonProperty("nom") String nom,
                     @JsonProperty("prenom") String prenom,
                     @JsonProperty("telephone") String telephone,
                     @JsonProperty("mail") String mail,
                     @JsonProperty("mdp") String mdp,
                     @JsonProperty("employees") Boolean employees,
                     @JsonProperty("adresse") Adresses adresse) {

        this.personne_id = new SimpleIntegerProperty(personne_id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.telephone = new SimpleStringProperty(telephone);
        this.mail = new SimpleStringProperty(mail);
        this.mdp = new SimpleStringProperty(mdp);
        this.employees = new SimpleBooleanProperty(employees);
        this.adresse = new SimpleObjectProperty<>(adresse);
    }

    public int getPersonne_id() {
        return personne_id.get();
    }

    public SimpleIntegerProperty personne_idProperty() {
        return personne_id;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id.set(personne_id);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getMdp() {
        return mdp.get();
    }

    public SimpleStringProperty mdpProperty() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp.set(mdp);
    }

    public boolean isEmployees() {
        return employees.get();
    }

    public SimpleBooleanProperty employeesProperty() {
        return employees;
    }

    public void setEmployees(boolean employees) {
        this.employees.set(employees);
    }

    public Adresses getAdresse() {
        return adresse.get();
    }

    public ObjectProperty<Adresses> adresseProperty() {
        return adresse;
    }

    public void setAdresse(Adresses adresse) {
        this.adresse.set(adresse);
    }
}




