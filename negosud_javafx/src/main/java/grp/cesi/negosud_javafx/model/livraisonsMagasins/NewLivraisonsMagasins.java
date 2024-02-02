package grp.cesi.negosud_javafx.model.livraisonsMagasins;

import java.sql.Timestamp;

public class NewLivraisonsMagasins {
	Timestamp date;
    int commandeMagasin_id;

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

}
