package com.cesi.negosud.dao.paiements;

import com.cesi.negosud.controller.paiements.model.Paiements;
import com.cesi.negosud.controller.paiements.model.NewPaiements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Repository
public class PaiementsDAORest {
    private final RestTemplate restTemplate;


    @Autowired
    public PaiementsDAORest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Paiements create(NewPaiements paiements) {
        //INSERT DANS BDD
        return new Paiements();
    }

    public boolean delete(int famille_id) {
        //DELETE DANS BDD
        return true;
    }

    public Paiements update(int famille_id, NewPaiements paiements) {
        //UPDATE DANS BDD
        return new Paiements();
    }

    public Paiements read(int famille_id) {
        // READ ONE PERSON DANS BDD
        return new Paiements();
    }

    public List<Paiements> read() {
        // READ ALL PERSON DANS BDD
        ResponseEntity<Paiements[]> response;
        String url = "https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Paiements[].class);
        Paiements[] body = response.getBody();

        return Arrays.asList(body);
    }
}
