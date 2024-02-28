package com.cesi.client_lourd_negosud.models;

import com.cesi.client_lourd_negosud.utils.Etat;

public class NewBonDeCommande {
    int quantite;
    Etat etat;
    int commandeClient_id;
    int articleVide_id;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
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
