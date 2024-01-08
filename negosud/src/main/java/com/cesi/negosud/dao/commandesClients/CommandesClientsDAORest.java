package com.cesi.negosud.dao.commandesClients;

import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import com.cesi.negosud.controller.commandesClients.model.NewCommandesClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CommandesClientsDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public CommandesClientsDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public CommandesClients create(NewCommandesClients commandesClients){
        return new CommandesClients();
    }

    public boolean delete(int commandeClient_id){
        return true;
    }

    public CommandesClients update(int commandeClient_id, NewCommandesClients commandesClients){
        return new CommandesClients();
    }

    public CommandesClients read(int commandeClient_id){
        return new CommandesClients();
    }

    public List<CommandesClients> read(){
        ResponseEntity<CommandesClients[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, CommandesClients[].class);
        CommandesClients[] body = response.getBody();

        return Arrays.asList(body);
    }
}
