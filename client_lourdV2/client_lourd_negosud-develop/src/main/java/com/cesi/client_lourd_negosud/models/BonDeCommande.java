package com.cesi.client_lourd_negosud.models;

import com.cesi.client_lourd_negosud.utils.Etat;

public class BonDeCommande {
    int bonDeCommande_id;
    int quantite;
    Etat etat;
    CommandesClients commandeClient;
    ArticleVide articleVide;

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

    public CommandesClients getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandesClients commandeClient) {
        this.commandeClient = commandeClient;
    }

    public ArticleVide getArticleVide() {
        return articleVide;
    }

    public void setArticleVide(ArticleVide articleVide) {
        this.articleVide = articleVide;
    }
}

