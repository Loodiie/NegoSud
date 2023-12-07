package com.cesi.negosud.dao.clients;

import com.cesi.negosud.controller.clients.model.Clients;
import com.cesi.negosud.controller.clients.model.NewClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class ClientsDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public ClientsDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public Clients create(NewClients clients){
        //INSERT DANS BDD
        return new Clients();
    }

    public boolean delete(int client_id){
        //DELETE DASN BDD
        return true;
    }

    public Clients update(int client_id, NewClients clients){
        //READ ONE CLIENT DANS BDD
        return new Clients();
    }

    public Clients read(int client_id){
        //READ ONE CLIENT DANS BDD
        return new Clients();
    }

    public List<Clients> read(){
        //READ ALL CLIENTS DANS BSS
        ResponseEntity<Clients[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Clients[].class);
        Clients[] body = response.getBody();

        return Arrays.asList(body);
    }
}
