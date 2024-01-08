package com.cesi.negosud.dao.livraisonsClients.model;

import java.sql.Timestamp;

public class LivraisonsClientsDTO {
    int livraisonClient_id;
	Timestamp date;
    int commandeClient_id;

	public int getLivraisonClient_id() {
		return this.livraisonClient_id;
	}

	public void setLivraisonClient_id(int livraisonClient_id) {
		this.livraisonClient_id = livraisonClient_id;
	}

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
