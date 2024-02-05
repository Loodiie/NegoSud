package grp.cesi.negosud_javafx.model.articleVide;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import grp.cesi.negosud_javafx.model.adresses.Adresses;

public class ArticleVide {
    int articleVide_id;
    int famille_id;

    public ArticleVide(@JsonProperty("articleVide_id") int articleVide_id,
                       @JsonProperty("famille_id") int famille_id) {
        this.articleVide_id = articleVide_id;
        this.famille_id = famille_id;
    }

    public int getArticleVide_id() {
        return articleVide_id;
    }

    public void setArticleVide_id(int articleVide_id) {
        this.articleVide_id = articleVide_id;
    }


    public int getFamille_id() {
        return famille_id;
    }

    public void setFamille_id(int famille_id) {
        this.famille_id = famille_id;
    }
    public Adresses Deserialize(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Adresses item = objectMapper.readValue(json, Adresses.class);
        return item;
    }
}
