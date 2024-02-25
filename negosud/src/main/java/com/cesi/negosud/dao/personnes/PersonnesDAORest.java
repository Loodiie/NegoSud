package com.cesi.negosud.dao.personnes;

import com.cesi.negosud.controller.personnes.model.Personnes;
import com.cesi.negosud.controller.personnes.model.NewPersonnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonnesDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public PersonnesDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public Personnes create(NewPersonnes personnes){
        //INSERT DANS BDD
        return new Personnes();
    }

    public boolean delete(int personne_id){
        //DELETE DASN BDD
        return true;
    }

    public Personnes update(int personne_id, NewPersonnes personnes){
        //UPDATE ONE personne DANS BDD
        return new Personnes();
    }

    public Personnes read(int personne_id){
        //READ ONE personne DANS BDD
        return new Personnes();
    }

    public List<Personnes> read(){
        //READ ALL Personnes DANS BSS
        ResponseEntity<Personnes[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Personnes[].class);
        Personnes[] body = response.getBody();

        return Arrays.asList(body);
    }

}
