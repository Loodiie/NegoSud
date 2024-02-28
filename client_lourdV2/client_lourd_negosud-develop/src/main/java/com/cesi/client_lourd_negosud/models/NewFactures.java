package com.cesi.client_lourd_negosud.models;

import java.sql.Timestamp;

public class NewFactures {
	Timestamp date;
    float marge;
    int commandeClient_id;

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
