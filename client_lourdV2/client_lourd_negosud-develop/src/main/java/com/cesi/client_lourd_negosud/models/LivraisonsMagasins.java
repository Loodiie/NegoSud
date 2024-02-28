package com.cesi.client_lourd_negosud.models;

import java.sql.Timestamp;

public class LivraisonsMagasins {
    int livraisonMagasin_id;
    Timestamp date;
    int commandeMagasin_id;

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
}
