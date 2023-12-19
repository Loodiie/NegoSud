package com.cesi.negosud.dao.commandesMagasin;

import com.cesi.negosud.controller.commandesMagasin.model.CommandesMagasin;
import com.cesi.negosud.controller.commandesMagasin.model.NewCommandesMagasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.commandesMagasin.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CommandesMagasinDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public CommandesMagasinDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public CommandesMagasin create(NewCommandesMagasin commandesMagasin){
        return new CommandesMagasin();
    }

    public boolean delete(int commandeMag_id){
        return true;
    }

    public CommandesMagasin update(int commandeMag_id, NewCommandesMagasin commandesMagasin){
        return new CommandesMagasin();
    }

    public CommandesMagasin read(int commandeMag_id){
        return new CommandesMagasin();
    }

    public List<CommandesMagasin> read(){
        ResponseEntity<CommandesMagasin[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, CommandesMagasin[].class);
        CommandesMagasin[] body = response.getBody();

        return Arrays.asList(body);
    }
}
