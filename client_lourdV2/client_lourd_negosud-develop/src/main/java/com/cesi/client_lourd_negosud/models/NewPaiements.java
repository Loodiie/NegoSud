package com.cesi.client_lourd_negosud.models;

import java.sql.Timestamp;

public class NewPaiements {
    Timestamp date_prelevement;
    String type_paiement;
    boolean acquitte;
    Timestamp echeance;
    int id_facture;

    public int getId_facture() {
        return id_facture;
    }
    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public Timestamp getDate_prelevement() {
        return date_prelevement;
    }

    public void setDate_prelevement(Timestamp date_prelevement) {
        this.date_prelevement = date_prelevement;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public boolean isAcquitte() {
        return acquitte;
    }

    public void setAcquitte(boolean acquitte) {
        this.acquitte = acquitte;
    }

    public Timestamp getEcheance() {
        return echeance;
    }

    public void setEcheance(Timestamp echeance) {
        this.echeance = echeance;
    }
}
