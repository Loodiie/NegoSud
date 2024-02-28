package grp.cesi.negosud_javafx.model.familles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

import java.util.Collection;

public class Familles {
    int famille_id;
    String libelle;
    int type_vin;
    String description;
    int annee;
    float degre;
    float prix_unit;
    int seuil;
    boolean actif;
    int fournisseur_id;

    public Familles(){};

    public Familles(@JsonProperty("famille_id") int famille_id,
                    @JsonProperty("libelle") String libelle,
                    @JsonProperty("type_vin") int type_vin,
                    @JsonProperty("description") String description,
                    @JsonProperty("annee") int annee,
                    @JsonProperty("degre") float degre,
                    @JsonProperty("prix_unit") float prix_unit,
                    @JsonProperty("seuil") int seuil,
                    @JsonProperty("actif") boolean actif,
                    @JsonProperty("fournisseur_id") int fournisseur_id) {
        this.famille_id = famille_id;
        this.libelle = libelle;
        this.type_vin = type_vin;
        this.description = description;
        this.annee = annee;
        this.degre = degre;
        this.prix_unit = prix_unit;
        this.seuil = seuil;
        this.actif = actif;
        this.fournisseur_id = fournisseur_id;
    }

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

    public int getType_vin() {
        return type_vin;
    }
    public void setType_vin(int type_vin) {
        this.type_vin = type_vin;
    }
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

    public boolean isActif() {
        return actif;
    }
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
    public Familles Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Familles item = objectMapper.readValue(json, Familles.class);
        return item;
    }
    public Collection<Familles> DeserializeAll(String json) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Familles> collectionItems = objectMapper.readValue(json, new TypeReference<Collection<Familles>>(){});
        return collectionItems;
    }
}