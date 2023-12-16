package com.cesi.negosud.dao.articles;

import com.cesi.negosud.controller.articles.model.Articles;
import com.cesi.negosud.controller.articles.model.NewArticles;
import com.cesi.negosud.dao.articles.model.ArticlesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticlesDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "article_id";
    private static final String DESIGNATION_FIELD = "designation";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String PRIX_UNIT_FIELD = "prix_unit";
    private static final String SEUIL_FIELD = "seuil";
    private static final String TVA_FIELD = "tva";
    private static final String REDUCTION_FIELD = "reduction";
    private static final String OFFERT_FIELD = "offert";
    private static final String FAMILLE_FIELD = "famille_id";
    private static final String FOURNISSEUR_FIELD = "fournisseur_id";

    @Autowired
    public ArticlesDAO(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<ArticlesDTO> rowMapper = (rs, rowNum) -> {
        final ArticlesDTO articles = new ArticlesDTO();
        articles.setArticle_id(rs.getInt(ID_FIELD));
        articles.setDesignation(rs.getString(DESIGNATION_FIELD));
        articles.setDescription(rs.getString(DESCRIPTION_FIELD));
        articles.setPrix_unit(rs.getFloat(PRIX_UNIT_FIELD));
        articles.setSeuil(rs.getInt(SEUIL_FIELD));
        articles.setTva(rs.getFloat(TVA_FIELD));
        articles.setReduction(rs.getFloat(REDUCTION_FIELD));
        articles.setOffert(rs.getInt(OFFERT_FIELD));
        articles.setFamille_id(rs.getInt(FAMILLE_FIELD));
        articles.setFournisseur_id(rs.getInt(FOURNISSEUR_FIELD));

        return articles;
    };

    public Articles create(NewArticles articles) {
        Articles articles1= null;
        final String query = "INSERT INTO articles(designation, description, prix_unit, seuil, tva, reduction, offert, famille_id, fournisseur_id) VALUES(?,?,?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, articles.getDesignation(), articles.getDescription(), articles.getPrix_unit(), articles.getSeuil(), articles.getTva(), articles.getReduction(), articles.getOffert(), articles.getFamille_id(), articles.getFournisseur_id());
        if (result ==1){
            articles1 = new Articles();
            articles1.setDesignation(articles.getDesignation());
            articles1.setDescription(articles.getDescription());
            articles1.setPrix_unit(articles.getPrix_unit());
            articles1.setSeuil(articles.getSeuil());
            articles1.setTva(articles.getTva());
            articles1.setReduction(articles.getReduction());
            articles1.setOffert(articles.getOffert());
            articles1.setFamille_id(articles.getFamille_id());
            articles1.setFournisseur_id(articles.getFournisseur_id());
        }
        return articles1;
    }

    public boolean delete (int article_id){
        final String query = ("DELETE from articles wher id=?");
        int result = this.jdbcTemplate.update(query, article_id);
        if(result == 1){
            return true;
        } else {
            return false;
        }
    }

    public Articles update(int article_id, NewArticles articles){
        Articles articles1= null;
        final String query = "UPDATE articles set designation=?, description=?, prix_unit=?, seuil=?, tva=?, reduction=?, offert=?, famille_id=?, fournisseur_id=? where id=?";
        int result = this.jdbcTemplate.update(query, articles.getDesignation(), articles.getDescription(), articles.getPrix_unit(), articles.getSeuil(), articles.getTva(), articles.getReduction(), articles.getOffert(), articles.getFamille_id(), articles.getFournisseur_id());
        if(result ==1){
            articles1 = new Articles();
            articles1.setArticle_id(article_id);
            articles1.setDesignation(articles.getDesignation());
            articles1.setDescription(articles.getDescription());
            articles1.setPrix_unit(articles.getPrix_unit());
            articles1.setSeuil(articles.getSeuil());
            articles1.setTva(articles.getTva());
            articles1.setReduction(articles.getReduction());
            articles1.setOffert(articles.getOffert());
            articles1.setFamille_id(articles.getFamille_id());
            articles1.setFournisseur_id(articles.getFournisseur_id());
        }

        return articles1;
    }

    public Articles read(int article_id){
        List<ArticlesDTO> dtos = this.jdbcTemplate.query("select from articles where article_id="+article_id, this.rowMapper);
        Articles articles = null;
        if(dtos != null && dtos.size() == 1){
            articles = new Articles();
            articles.setArticle_id(dtos.get(0).getArticle_id());
            articles.setDesignation(dtos.get(0).getDesignation());
            articles.setDescription(dtos.get(0).getDescription());
            articles.setPrix_unit(dtos.get(0).getPrix_unit());
            articles.setSeuil(dtos.get(0).getSeuil());
            articles.setTva(dtos.get(0).getTva());
            articles.setReduction(dtos.get(0).getReduction());
            articles.setOffert(dtos.get(0).getOffert());
            articles.setFamille_id(dtos.get(0).getFamille_id());
            articles.setFournisseur_id(dtos.get(0).getFournisseur_id());
        }
        return  articles;
    }

    public List<Articles> read() {
        List<Articles> listArticles = null;
        List<ArticlesDTO> dtos = this.jdbcTemplate.query("select * from articles", this.rowMapper);
        if(dtos != null && dtos.size() > 0) {
            listArticles = new ArrayList<Articles> ();
            for (ArticlesDTO dto : dtos) {
                Articles resp = new Articles();
                resp.setArticle_id(dto.getArticle_id());
                resp.setDesignation(dto.getDesignation());
                resp.setDescription(dto.getDescription());
                resp.setPrix_unit(dto.getPrix_unit());
                resp.setSeuil(dto.getSeuil());
                resp.setTva(dto.getTva());
                resp.setReduction(dto.getReduction());
                resp.setOffert(dto.getOffert());
                resp.setFamille_id(dto.getFamille_id());
                resp.setFournisseur_id(dto.getFournisseur_id());
            }
        }
        return listArticles;
    }
}
