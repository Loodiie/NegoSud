package com.cesi.negosud.dao.familles;

import com.cesi.negosud.controller.familles.model.Familles;
import com.cesi.negosud.controller.familles.model.NewFamilles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class FamillesDAORest {

    private final RestTemplate restTemplate;


    @Autowired
    public FamillesDAORest(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Familles create(NewFamilles familles) {
        //INSERT DANS BDD
        return new Familles();
    }

    public boolean delete(int famille_id){
        //DELETE DANS BDD
        return true;
    }

    public Familles update(int famille_id, NewFamilles familles){
        //UPDATE DANS BDD
        return new Familles();
    }

    public Familles read(int famille_id) {
        // READ ONE PERSON DANS BDD
        return new Familles();
    }

    public List<Familles> read() {
        // READ ALL PERSON DANS BDD
        ResponseEntity<Familles[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Familles[].class);
        Familles[] body = response.getBody();

        return Arrays.asList(body);
    }
}
