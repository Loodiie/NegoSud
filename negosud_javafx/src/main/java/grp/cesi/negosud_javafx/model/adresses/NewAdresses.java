package grp.cesi.negosud_javafx.model.adresses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewAdresses {
    String ville;
    String code_postal;
    String pays;
    String numero;
    String rue;
    String etage;
    String batiment;
    String complement;

    public NewAdresses(String ville, String code_postal, String pays, String numero, String rue, String etage, String batiment, String complement) {
        this.ville = ville;
        this.code_postal = code_postal;
        this.pays = pays;
        this.numero = numero;
        this.rue = rue;
        this.etage = etage;
        this.batiment = batiment;
        this.complement = complement;
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

    public String Serialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(this);
        return string;
    }
}
