package grp.cesi.negosud_javafx.model.articles;

public class ArticleComplete {
    int article_id;
    float tva;
    float reduction;
    int offert;
    int famille_id;
    String famille_libelle;
    String type_vin;
    int annee;
    float degre;
    float prix_unit;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
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

    public String getFamille_libelle() {
        return famille_libelle;
    }

    public void setFamille_libelle(String famille_libelle) {
        this.famille_libelle = famille_libelle;
    }

    public String getType_vin() {
        return type_vin;
    }

    public void setType_vin(String type_vin) {
        this.type_vin = type_vin;
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

    public float getPrix_unit() {
        return prix_unit;
    }

    public void setPrix_unit(float prix_unit) {
        this.prix_unit = prix_unit;
    }
}
