package com.cesi.negosud.controller.paiements.model;

public class NewPaiements {
    long date_prelevement;
    String type_paiement;
    boolean acquitte;
    long echeance;

    public long getDate_prelevement() {
        return date_prelevement;
    }

    public void setDate_prelevement(long date_prelevement) {
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

    public long getEcheance() {
        return echeance;
    }

    public void setEcheance(long echeance) {
        this.echeance = echeance;
    }
}
