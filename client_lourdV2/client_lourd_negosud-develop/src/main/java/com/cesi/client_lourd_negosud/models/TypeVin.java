package com.cesi.client_lourd_negosud.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TypeVin {
    private final SimpleIntegerProperty typeVin_id;
    private final SimpleStringProperty libelle;

    public TypeVin(@JsonProperty("id_family") int typeVin_id,
                  @JsonProperty("family_name") String libelle) {
        this.typeVin_id = new SimpleIntegerProperty(typeVin_id);
        this.libelle = new SimpleStringProperty(libelle);
    }

}
