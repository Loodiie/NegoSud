package com.cesi.negosud.controller.articles;

import com.cesi.negosud.business.articles.ArticlesBusiness;
import com.cesi.negosud.controller.articles.model.Articles;
import com.cesi.negosud.controller.articles.model.NewArticles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ArticlesController {

    private final String versionBDD = "/api/v1";
    private final String versionRest = "/api/v1/rest";

    private final ArticlesBusiness articlesBusiness;

    @Autowired
    public ArticlesController(ArticlesBusiness articlesBusiness){this.articlesBusiness = articlesBusiness;}

    @PostMapping(versionBDD + "/articles")
    public Articles createArticlesBDD(@RequestBody NewArticles articles){
        return articlesBusiness.createArticlesBusiness(articles, false);
    }

    /*@PostMapping(versionRest + "/articles")
    public Articles createArticlesRest(@RequestBody NewArticles articles){
        return articlesBusiness.createArticlesBusiness(articles, true);
    }*/

    @DeleteMapping(versionBDD + "/articles/{article_id}")
    public boolean deleteArticlesBDD(@PathVariable int article_id){
        return articlesBusiness.deleteArticlesBusiness(article_id, false);
    }

    /*@DeleteMapping(versionRest + "/articles/{article_id}")
    public boolean deleteArticlesRest(@PathVariable int article_id){
        return articlesBusiness.deleteArticlesBusiness(article_id, true);
    }*/

    @PutMapping(versionBDD + "/articles/{article_id}")
    public Articles updateArticlesBDD(@PathVariable int article_id, @RequestBody NewArticles articles){
        return articlesBusiness.updateArticlesBusiness(article_id, articles, false);
    }

    /*@PutMapping(versionRest + "articles/{article_id}")
    public Articles updateArticlesREst(@PathVariable int article_id, @RequestBody NewArticles articles){
        return articlesBusiness.updateArticlesBusiness(article_id, articles, true);
    }*/

    @GetMapping(versionBDD + "/articles/{article_id}")
    public Articles getArticlesBDD(@PathVariable int article_id){
        return articlesBusiness.getArticlesBusiness(article_id, false);
    }

    /*@GetMapping(versionRest + "/articles/{article_id}")
    public Articles getArticlesRest(@PathVariable int article_id){
        return articlesBusiness.getArticlesBusiness(article_id, true);
    }*/

    @GetMapping(versionBDD + "/articles")
    public List<Articles> getAllArticlesBDD(){return articlesBusiness.getAllArticlesBusiness(false);}

    /*@GetMapping(versionRest + "/articles")
    public List<Articles> getAllArticlesRest(){return articlesBusiness.getAllArticlesBusiness(true);}*/
}
