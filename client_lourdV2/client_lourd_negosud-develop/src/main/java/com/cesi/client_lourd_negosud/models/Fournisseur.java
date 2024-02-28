package com.cesi.client_lourd_negosud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


public class Fournisseur {

    private final SimpleIntegerProperty fournisseur_id;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty mail;
    private final ObjectProperty<Adresses> address;

    public Fournisseur(@JsonProperty("fournisseur_id") Integer fournisseur_id,
                       @JsonProperty("nom") String nom,
                       @JsonProperty("telephone") String telephone,
                       @JsonProperty("mail") String mail,
                       @JsonProperty("address") Adresses address) {
        this.fournisseur_id = new SimpleIntegerProperty(fournisseur_id);
        this.nom = new SimpleStringProperty(nom);
        this.telephone = new SimpleStringProperty(telephone);
        this.mail = new SimpleStringProperty(mail);
        this.address = new SimpleObjectProperty<>(address);
    }

    public int getFournisseur_id() {
        return fournisseur_id.get();
    }

    public SimpleIntegerProperty fournisseur_idProperty() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id.set(fournisseur_id);
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

    public Adresses getAddress() {
        return address.get();
    }

    public ObjectProperty<Adresses> addressProperty() {
        return address;
    }

    public void setAddress(Adresses address) {
        this.address.set(address);
    }
}
