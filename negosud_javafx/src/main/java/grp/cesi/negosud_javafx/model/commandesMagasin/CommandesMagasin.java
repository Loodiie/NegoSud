package grp.cesi.negosud_javafx.model.commandesMagasin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

import java.sql.Timestamp;

public class CommandesMagasin {
    int commandeMag_id;
    Timestamp date;
    int fournisseur_id;

    public CommandesMagasin(@JsonProperty("commandeMag_id") int commandeMag_id,
                            @JsonProperty("date") Timestamp date,
                            @JsonProperty("fournisseur_id") int fournisseur_id) {
        this.commandeMag_id = commandeMag_id;
        this.date = date;
        this.fournisseur_id = fournisseur_id;
    }

    public int getCommandeMag_id() {
        return commandeMag_id;
    }

    public void setCommandeMag_id(int commandeMag_id) {
        this.commandeMag_id = commandeMag_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }
}
