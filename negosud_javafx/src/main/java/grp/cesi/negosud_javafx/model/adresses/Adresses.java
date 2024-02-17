package grp.cesi.negosud_javafx.model.adresses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Collection;

public class Adresses {
    int adresse_id;
    String ville;
    String code_postal;
    String pays;
    String numero;
    String rue;
    String etage;
    String batiment;
    String complement;

    public Adresses(){}

    public Adresses(@JsonProperty("adresse_id") int adresse_id,
                    @JsonProperty("ville") String ville,
                    @JsonProperty("code_postal") String code_postal,
                    @JsonProperty("pays") String pays,
                    @JsonProperty("numero") String numero,
                    @JsonProperty("rue") String rue,
                    @JsonProperty("etage") String etage,
                    @JsonProperty("batiment") String batiment,
                    @JsonProperty("complement") String complement) {
        this.adresse_id = adresse_id;
        this.ville = ville;
        this.code_postal = code_postal;
        this.pays = pays;
        this.numero = numero;
        this.rue = rue;
        this.etage = etage;
        this.batiment = batiment;
        this.complement = complement;
    }


    @JsonCreator

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }

    public Collection<Adresses> DeserializeAll(String json) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Adresses> collectionItems = objectMapper.readValue(json, new TypeReference<Collection<Adresses>>(){});
        return collectionItems;
    }

}
