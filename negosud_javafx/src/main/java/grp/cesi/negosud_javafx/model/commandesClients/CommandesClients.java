package grp.cesi.negosud_javafx.model.commandesClients;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import grp.cesi.negosud_javafx.model.etat.Etat;

import java.sql.Timestamp;

public class CommandesClients {
    int commandeClient_id;
    Timestamp date;
    Etat etat;
    int client_id;

    public CommandesClients(@JsonProperty("commandeClient_id") int commandeClient_id,
                            @JsonProperty("date") Timestamp date,
                            @JsonProperty("etat") Etat etat,
                            @JsonProperty("client_id") int client_id) {
        this.commandeClient_id = commandeClient_id;
        this.date = date;
        this.etat = etat;
        this.client_id = client_id;
    }

    public int getCommandeClient_id() {
        return commandeClient_id;
    }

    public void setCommandeClient_id(int commandeClient_id) {
        this.commandeClient_id = commandeClient_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public CommandesClients Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CommandesClients item = objectMapper.readValue(json, CommandesClients.class);
        return item;
    }
}
