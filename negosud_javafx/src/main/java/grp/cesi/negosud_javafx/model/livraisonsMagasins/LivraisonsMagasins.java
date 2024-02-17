package grp.cesi.negosud_javafx.model.livraisonsMagasins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

import java.sql.Timestamp;

public class LivraisonsMagasins {
    int livraisonMagasin_id;
    Timestamp date;
    int commandeMagasin_id;

	public LivraisonsMagasins(@JsonProperty("livraisonMagasin_id") int livraisonMagasin_id,
							  @JsonProperty("date") Timestamp date,
							  @JsonProperty("commandeMagasin_id") int commandeMagasin_id) {
		this.livraisonMagasin_id = livraisonMagasin_id;
		this.date = date;
		this.commandeMagasin_id = commandeMagasin_id;
	}

	public int getLivraisonMagasin_id() {
		return this.livraisonMagasin_id;
	}

	public void setLivraisonMagasin_id(int livraisonMagasin_id) {
		this.livraisonMagasin_id = livraisonMagasin_id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCommandeMagasin_id() {
		return this.commandeMagasin_id;
	}

	public void setCommandeMagasin_id(int commandeMagasin_id) {
		this.commandeMagasin_id = commandeMagasin_id;
	}

	public LivraisonsMagasins Deserialize(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		LivraisonsMagasins item = objectMapper.readValue(json, LivraisonsMagasins.class);
		return item;
	}


}
