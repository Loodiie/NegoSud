package com.cesi.negosud.business.articles;

import com.cesi.negosud.controller.articles.model.Articles;
import com.cesi.negosud.controller.articles.model.NewArticles;
import com.cesi.negosud.dao.articles.ArticlesDAO;
import com.cesi.negosud.dao.articles.ArticlesDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesBusiness {

    private final ArticlesDAO articlesDAO;
    private final ArticlesDAORest articlesDAORest;

    @Autowired
    public ArticlesBusiness(ArticlesDAO articlesDAO, ArticlesDAORest articlesDAORest){
        this.articlesDAO = articlesDAO;
        this.articlesDAORest = articlesDAORest;
    }

    public Articles createArticlesBusiness(NewArticles articles, boolean rest){
        if (rest){
            return articlesDAORest.create(articles);
        }else {
            return articlesDAO.create(articles);
        }
    }

    public boolean deleteArticlesBusiness(int article_id, boolean rest){
        if (rest){
            return articlesDAORest.delete(article_id);
        }else {
            return articlesDAO.delete(article_id);
        }
    }

    public Articles updateArticlesBusiness(int article_id, NewArticles articles, boolean rest){
        if (rest){
            return articlesDAORest.update(article_id, articles);
        }else {
            return articlesDAO.update(article_id, articles);
        }
    }

    public Articles getArticlesBusiness(int article_id, boolean rest){
        if (rest){
            return articlesDAORest.read(article_id);
        }else {
            return articlesDAO.read(article_id);
        }
    }

    public List<Articles> getAllArticlesBusiness(boolean rest){
        if (rest){
            return articlesDAORest.read();
        }else {
            return articlesDAO.read();
        }
    }


}
