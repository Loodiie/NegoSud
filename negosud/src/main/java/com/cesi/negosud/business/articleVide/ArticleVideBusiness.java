package com.cesi.negosud.business.articleVide;

import com.cesi.negosud.controller.articleVide.model.ArticleVide;
import com.cesi.negosud.controller.articleVide.model.NewArticleVide;
import com.cesi.negosud.dao.articleVide.ArticleVideDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleVideBusiness {

    private final ArticleVideDAO articleVideDAO;

    @Autowired
    public ArticleVideBusiness(ArticleVideDAO articleVideDAO){this.articleVideDAO = articleVideDAO;}

    public ArticleVide createArticleVideBusiness(NewArticleVide articleVide){return articleVideDAO.create(articleVide);}

    public boolean deleteArticleVideBusiness(int articleVide_id){return articleVideDAO.delete(articleVide_id);}

    public ArticleVide updateArticleVideBusiness(int articleVide_id, NewArticleVide articleVide){
        return articleVideDAO.update(articleVide_id, articleVide);
    }

    public ArticleVide getArticleVideBusiness(int articleVide_id){return articleVideDAO.read(articleVide_id);}

    public List<ArticleVide> getAllArticleVideBusiness(){return articleVideDAO.read();}
}
