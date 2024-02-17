package grp.cesi.negosud_javafx.model.paiements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

import java.sql.Timestamp;

public class Paiements {
    int paiement_id;
    Timestamp date_prelevement;
    String type_paiement;
    boolean acquitte;
    Timestamp echeance;
    int id_facture;

    public Paiements(@JsonProperty("paiement_id") int paiement_id,
                        @JsonProperty("date_prelevement") Timestamp date_prelevement,
                        @JsonProperty("type_paiement") String type_paiement,
                        @JsonProperty("acquitte") boolean acquitte,
                        @JsonProperty("echeance") Timestamp echeance,
                        @JsonProperty("id_facture") int id_facture) {
        this.date_prelevement = date_prelevement;
        this.type_paiement = type_paiement;
        this.acquitte = acquitte;
        this.echeance = echeance;
        this.id_facture = id_facture;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public Timestamp getDate_prelevement() {
        return date_prelevement;
    }

    public void setDate_prelevement(Timestamp date_prelevement) {
        this.date_prelevement = date_prelevement;
    }
    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public boolean isAcquitte() {
        return acquitte;
    }

    public void setAcquitte(boolean acquitte) {
        this.acquitte = acquitte;
    }

    public Timestamp getEcheance() {
        return echeance;
    }

    public void setEcheance(Timestamp echeance) {
        this.echeance = echeance;
    }

    public int getPaiement_id() {
        return paiement_id;
    }
    public void setPaiement_id(int paiements_id) {
        this.paiement_id = paiements_id;
    }

    public Paiements Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Paiements item = objectMapper.readValue(json, Paiements.class);
        return item;
    }
}
