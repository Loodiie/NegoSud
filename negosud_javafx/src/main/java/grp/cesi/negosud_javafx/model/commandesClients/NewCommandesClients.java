package grp.cesi.negosud_javafx.model.commandesClients;


import grp.cesi.negosud_javafx.model.etat.Etat;

import java.sql.Timestamp;

public class NewCommandesClients {
    Timestamp date;
    Etat etat;
    int client_id;

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
}
