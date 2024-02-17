package grp.cesi.negosud_javafx.model.factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

import java.sql.Timestamp;

public class Factures {
	int facture_id;
	Timestamp date;
	float marge;
	int commandeClient_id;

	public Factures(@JsonProperty("facture_id") int facture_id,
					@JsonProperty("date") Timestamp date,
					@JsonProperty("marge") float marge,
					@JsonProperty("commandeClient_id") int commandeClient_id) {
		this.facture_id = facture_id;
		this.date = date;
		this.marge = marge;
		this.commandeClient_id = commandeClient_id;
	}

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

	public Factures Deserialize(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Factures item = objectMapper.readValue(json, Factures.class);
		return item;
	}
}
