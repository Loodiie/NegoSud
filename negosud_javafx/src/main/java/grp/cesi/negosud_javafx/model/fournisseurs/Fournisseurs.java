package grp.cesi.negosud_javafx.model.fournisseurs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

public class Fournisseurs {
    int fournisseur_id;
    String nom;
    String telephone;
    String mail;
    int adresse_id;

    public Fournisseurs(@JsonProperty("fournisseur_id") int fournisseur_id,
                        @JsonProperty("nom") String nom,
                        @JsonProperty("telephone") String telephone,
                        @JsonProperty("mail") String mail,
                        @JsonProperty("adresse_id") int adresse_id) {
        this.fournisseur_id = fournisseur_id;
        this.nom = nom;
        this.telephone = telephone;
        this.mail = mail;
        this.adresse_id = adresse_id;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
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
    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }
}
