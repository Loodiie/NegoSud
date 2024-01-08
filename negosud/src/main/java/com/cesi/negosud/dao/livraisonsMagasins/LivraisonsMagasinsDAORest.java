package com.cesi.negosud.dao.livraisonsMagasins;

import com.cesi.negosud.controller.livraisonsMagasins.model.LivraisonsMagasins;
import com.cesi.negosud.controller.livraisonsMagasins.model.NewLivraisonsMagasins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class LivraisonsMagasinsDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public LivraisonsMagasinsDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public LivraisonsMagasins create(NewLivraisonsMagasins livraisonsMagasins){
        return new LivraisonsMagasins();
    }

    public boolean delete(int livraisonsMagasin_id){
        return true;
    }

    public LivraisonsMagasins update(int livraisonsMagasin_id, NewLivraisonsMagasins livraisonsMagasins){
        return new LivraisonsMagasins();
    }

    public LivraisonsMagasins read(int livraisonsMagasin_id){
        return new LivraisonsMagasins();
    }

    public List<LivraisonsMagasins> read(){
        ResponseEntity<LivraisonsMagasins[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, LivraisonsMagasins[].class);
        LivraisonsMagasins[] body = response.getBody();

        return Arrays.asList(body);
    }
}
