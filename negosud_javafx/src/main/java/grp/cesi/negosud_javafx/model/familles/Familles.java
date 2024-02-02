package grp.cesi.negosud_javafx.model.familles;

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
}
