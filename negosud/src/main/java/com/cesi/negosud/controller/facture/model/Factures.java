package com.cesi.negosud.controller.factures.model;

public class Factures {
    int facture_id;
    DATE date;
    float marge;
    int commandeClient_id;
    int commandeMag_id;

	public int getFacture_id() {
		return this.facture_id;
	}

	public void setFacture_id(int facture_id) {
		this.facture_id = facture_id;
	}

	public DATE getDate() {
		return this.date;
	}

	public void setDate(DATE date) {
		this.date = date;
	}

	public float getMarge() {
		return this.marge;
	}

	public void setMarge(float marge) {
		this.marge = marge;
	}

	public int getCommandeClient_id() {
		return this.commandeClient_id;
	}

	public void setCommandeClient_id(int commandeClient_id) {
		this.commandeClient_id = commandeClient_id;
	}

	public int getCommandeMag_id() {
		return this.commandeMag_id;
	}

	public void setCommandeMag_id(int commandeMag_id) {
		this.commandeMag_id = commandeMag_id;
	}
}
