package com.cesi.negosud.controller.livraisonsClients.model;

import java.sql.Timestamp;

public class NewLivraisonsClients {
	Timestamp date;
    int commandeClient_id;

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCommandeClient_id() {
		return this.commandeClient_id;
	}

	public void setCommandeClient_id(int commandeClient_id) {
		this.commandeClient_id = commandeClient_id;
	}



}
