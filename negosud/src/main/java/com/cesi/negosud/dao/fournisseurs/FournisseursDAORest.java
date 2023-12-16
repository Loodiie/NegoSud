package com.cesi.negosud.dao.fournisseurs;

import com.cesi.negosud.controller.fournisseurs.model.Fournisseurs;
import com.cesi.negosud.controller.fournisseurs.model.NewFournisseurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class FournisseursDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public FournisseursDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public Fournisseurs create(NewFournisseurs fournisseurs){
        return new Fournisseurs();
    }

    public boolean delete(int fournisseur_id){
        return true;
    }

    public Fournisseurs update(int fournisseur_id, NewFournisseurs fournisseurs){
        return new Fournisseurs();
    }

    public Fournisseurs read(int fournisseur_id){
        return new Fournisseurs();
    }

    public List<Fournisseurs> read(){
        ResponseEntity<Fournisseurs[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Fournisseurs[].class);
        Fournisseurs[] body = response.getBody();

        return Arrays.asList(body);
    }
}
