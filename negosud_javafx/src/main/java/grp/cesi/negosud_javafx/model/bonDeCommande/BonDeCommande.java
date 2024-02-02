package grp.cesi.negosud_javafx.model.bonDeCommande;


import grp.cesi.negosud_javafx.model.etat.Etat;

public class BonDeCommande {
    int bonDeCommande_id;
    int quantite;
    Etat etat;
    int commandeClient_id;
    int articleVide_id;

    public int getBonDeCommande_id() {
        return bonDeCommande_id;
    }

    public void setBonDeCommande_id(int bonDeCommande_id) {
        this.bonDeCommande_id = bonDeCommande_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat Etat) {
        this.etat = etat;
    }

    public int getCommandeClient_id() {
        return commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id = commandeClient_id;
    }

    public int getArticleVide_id() {
        return articleVide_id;
    }

    public void setArticleVide_id(int article_id) {
        this.articleVide_id = article_id;
    }

}
