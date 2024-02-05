package grp.cesi.negosud_javafx.model.cartons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

public class Cartons {
    int carton_id;
    String description;

    public Cartons(@JsonProperty("carton_id") int carton_id,
                   @JsonProperty("description") String description) {
        this.carton_id = carton_id;
        this.description = description;
    }

    public int getCarton_id() {
        return carton_id;
    }

    public void setCarton_id(int carton_id) {
        this.carton_id = carton_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }

}
