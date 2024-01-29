package com.cesi.negosud.controller.articleVide;

import com.cesi.negosud.business.articleVide.ArticleVideBusiness;
import com.cesi.negosud.controller.articleVide.model.ArticleVide;
import com.cesi.negosud.controller.articleVide.model.NewArticleVide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ArticleVideController {

    private final String versionBDD = "/api/v1";
    private final ArticleVideBusiness articleVideBusiness;

    @Autowired
    private ArticleVideController(ArticleVideBusiness articleVideBusiness) {
        this.articleVideBusiness = articleVideBusiness;
    }

    @PostMapping(versionBDD + "/articleVide")
    public ArticleVide  createArticleVideBDD(@RequestBody NewArticleVide articleVide){
        return articleVideBusiness.createArticleVideBusiness(articleVide);
    }

    @DeleteMapping(versionBDD +"/articleVide/{articleVide_id}")
    public boolean deleteArticleVideBDD(@PathVariable int articleVide_id){
        return articleVideBusiness.deleteArticleVideBusiness(articleVide_id);
    }

    @PutMapping(versionBDD +"/articleVide/{articleVide_id}")
    public ArticleVide updateArticleVideBDD(@PathVariable int articleVide_id, @RequestBody NewArticleVide articleVide){
        return articleVideBusiness.updateArticleVideBusiness(articleVide_id, articleVide);
    }

    @GetMapping(versionBDD +"/articleVide/{articleVide_id}")
    public ArticleVide getArticleVideBDD(@PathVariable int articleVide_id){return articleVideBusiness.getArticleVideBusiness(articleVide_id);}

    @GetMapping(versionBDD +"/articleVide")
    public List<ArticleVide> getAllArticleVide(){return  articleVideBusiness.getAllArticleVideBusiness();}

}




