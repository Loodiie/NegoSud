package com.cesi.negosud.dao.bonDeCommande.model;

public class BonDeCommandeDTO {
    int bonDeCommande_id;
    int quantite;
    String etat;
    int commandeClient_id;
    int article_id;

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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getCommandeClient_id() {
        return commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id = commandeClient_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }
}
