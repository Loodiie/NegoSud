package grp.cesi.negosud_javafx.model.typeVin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

public class TypeVin {
    int typeVin_id;
    String libelle;

    public TypeVin(@JsonProperty("typeVin_id") int typeVin_id,
                   @JsonProperty("libelle") String libelle) {
        this.typeVin_id = typeVin_id;
        this.libelle = libelle;
    }

    public int getTypeVin_id() {
        return typeVin_id;
    }

    public void setTypeVin_id(int typeVin_id) {
        this.typeVin_id = typeVin_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeVin Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeVin item = objectMapper.readValue(json, TypeVin.class);
        return item;
    }
}
