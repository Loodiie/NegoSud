package com.cesi.negosud.dao.adresses;

import com.cesi.negosud.controller.adresses.model.Adresses;
import com.cesi.negosud.controller.adresses.model.NewAdresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class AdressesDAORest {
    private final RestTemplate restTemplate;


    @Autowired
    public AdressesDAORest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Adresses create(NewAdresses adresses) {
        //INSERT DANS BDD
        return new Adresses();
    }

    public boolean delete(int adresse_id){
        //DELETE DANS BDD
        return true;
    }

    public Adresses update(int adresse_id, NewAdresses adresses){
        //UPDATE DANS BDD
        return new Adresses();
    }

    public Adresses read(int adresse_id) {
        // READ ONE ADRESSE DANS BDD
        return new Adresses();
    }

    public List<Adresses> read() {
        // READ ALL ADRESSE DANS BDD
        ResponseEntity<Adresses[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Adresses[].class);
        Adresses[] body = response.getBody();

        return Arrays.asList(body);
    }

}