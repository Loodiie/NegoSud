package com.cesi.negosud.dao.factures.model;

import java.sql.Timestamp;

public class FacturesDTO {
    int facture_id;
	Timestamp date;
    float marge;
    int commandeClient_id;

	public int getFacture_id() {
		return this.facture_id;
	}

	public void setFacture_id(int facture_id) {
		this.facture_id = facture_id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
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

}


