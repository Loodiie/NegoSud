package com.cesi.negosud.dao.livraisonsClients;

import com.cesi.negosud.controller.livraisonsClients.model.LivraisonsClients;
import com.cesi.negosud.controller.livraisonsClients.model.NewLivraisonsClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class LivraisonsClientsDAORest {

    private final RestTemplate restTemplate;

    @Autowired
    public LivraisonsClientsDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public LivraisonsClients create(NewLivraisonsClients livraisonsClients){
        return new LivraisonsClients();
    }

    public boolean delete(int livraisonsClient_id){
        return true;
    }

    public LivraisonsClients update(int livraisonsClient_id, NewLivraisonsClients livraisonsClients){
        return new LivraisonsClients();
    }

    public LivraisonsClients read(int livraisonsClient_id){
        return new LivraisonsClients();
    }

    public List<LivraisonsClients> read(){
        ResponseEntity<LivraisonsClients[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, LivraisonsClients[].class);
        LivraisonsClients[] body = response.getBody();

        return Arrays.asList(body);
    }
}
