package com.cesi.negosud.dao.factures;

import com.cesi.negosud.controller.factures.model.Factures;
import com.cesi.negosud.controller.factures.model.NewFactures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class FacturesDAORest {

    private final RestTemplate restTemplate;


    @Autowired
    public FacturesDAORest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Factures create(NewFactures factures) {
        //INSERT DANS BDD
        return new Factures();
    }

    public boolean delete(int facture_id){
        //DELETE DANS BDD
        return true;
    }

    public Factures update(int facture_id, NewFactures factures){
        //UPDATE DANS BDD
        return new Factures();
    }

    public Factures read(int facture_id) {
        // READ ONE PERSON DANS BDD
        return new Factures();
    }

    public List<Factures> read() {
        // READ ALL PERSON DANS BDD
        ResponseEntity<Factures[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Factures[].class);
        Factures[] body = response.getBody();

        return Arrays.asList(body);
    }
}
