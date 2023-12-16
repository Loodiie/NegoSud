package com.cesi.negosud.dao.articles;

import com.cesi.negosud.controller.articles.model.Articles;
import com.cesi.negosud.controller.articles.model.NewArticles;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ArticlesDAORest {
    private final RestTemplate restTemplate;

    public ArticlesDAORest(RestTemplate restTemplate){this.restTemplate = restTemplate;}

    public Articles create(NewArticles articles){
        return new Articles();
    }

    public boolean delete(int article_id){
        return true;
    }

    public Articles update(int article_id, NewArticles articles){
        return new Articles();
    }

    public Articles read(int article_id){
        return new Articles();
    }

    public List<Articles> read(){
        ResponseEntity<Articles[]> response;
        String url ="https://8080-cesi2022-spring3-zsh5qtnx8qn.ws-eu106.gitpod.io/api/vi/persons";  //A CHANGER

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        response = restTemplate.exchange(url, HttpMethod.GET, entity, Articles[].class);
        Articles[] body = response.getBody();

        return Arrays.asList(body);
    }
}
