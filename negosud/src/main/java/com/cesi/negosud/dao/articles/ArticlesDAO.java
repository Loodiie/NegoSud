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
    private static final String TVA_FIELD = "tva";
    private static final String REDUCTION_FIELD = "reduction";
    private static final String OFFERT_FIELD = "offert";
    private static final String FAMILLE_FIELD = "fk_famille";
    private static final String CARTON_FIELD = "fk_carton";
    private static final String COMMANDESM_FIELD = "fk_commandeMag";
    private static final String COMMANDESC_FIELD = "fk_commandeClient";


    @Autowired
    public ArticlesDAO(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<ArticlesDTO> rowMapper = (rs, rowNum) -> {
        final ArticlesDTO articles = new ArticlesDTO();
        articles.setArticle_id(rs.getInt(ID_FIELD));
        articles.setTva(rs.getFloat(TVA_FIELD));
        articles.setReduction(rs.getFloat(REDUCTION_FIELD));
        articles.setOffert(rs.getInt(OFFERT_FIELD));
        articles.setFamille_id(rs.getInt(FAMILLE_FIELD));
        articles.setCarton_id(rs.getInt(CARTON_FIELD));
        articles.setCommandesM_id(rs.getInt(COMMANDESM_FIELD));
        articles.setCommandesC_id(rs.getInt(COMMANDESC_FIELD));

        return articles;
    };

    public Articles create(NewArticles articles) {
        Articles articles1= null;
        final String query = "INSERT INTO articles(tva, reduction, offert, fk_famille, fk_carton, fk_commandeMag, fk_commandeClient) VALUES(?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, articles.getTva(), articles.getReduction(), articles.getOffert(),
                articles.getFamille_id(), articles.getCommandesM_id(), articles.getCommandesC_id());
        if (result ==1){
            List<Articles> listArticles = read();
            articles1 = new Articles();
            articles1.setArticle_id(listArticles.get(listArticles.size() - 1).getArticle_id());
            articles1.setTva(articles.getTva());
            articles1.setReduction(articles.getReduction());
            articles1.setOffert(articles.getOffert());
            articles1.setFamille_id(articles.getFamille_id());
            articles1.setCarton_id(articles.getCarton_id());
            articles1.setCommandesM_id(articles.getCommandesM_id());
            articles1.setCommandesC_id(articles.getCommandesC_id());
        }
        return articles1;
    }


    public boolean delete (int article_id){
        final String query = ("DELETE from articles where article_id=?");
        int result = this.jdbcTemplate.update(query, article_id);
        if(result == 1){
            return true;
        } else {
            return false;
        }
    }

    public Articles update(int article_id, NewArticles articles){
        Articles articles1= null;
        final String query = "UPDATE articles set tva=?, reduction=?, offert=?, fk_famille=?, fk_carton=?, fk_commandeMag=?, fk_commandeClient=? where article_id=?";
        int result = this.jdbcTemplate.update(query, articles.getTva(), articles.getReduction(), articles.getOffert(),
                articles.getFamille_id(), articles.getCarton_id(), articles.getCommandesM_id(), articles.getCommandesC_id(), article_id);
        if(result ==1){
            articles1 = new Articles();
            articles1.setArticle_id(article_id);
            articles1.setTva(articles.getTva());
            articles1.setReduction(articles.getReduction());
            articles1.setOffert(articles.getOffert());
            articles1.setFamille_id(articles.getFamille_id());
            articles1.setCarton_id(articles.getCarton_id());
            articles1.setCommandesM_id(articles.getCommandesM_id());
            articles1.setCommandesC_id(articles.getCommandesC_id());
        }

        return articles1;
    }

    public Articles read(int article_id){
        List<ArticlesDTO> dtos = this.jdbcTemplate.query("select from articles where article_id="+article_id, this.rowMapper);
        Articles articles = null;
        if(dtos != null && dtos.size() == 1){
            articles = new Articles();
            articles.setArticle_id(dtos.get(0).getArticle_id());
            articles.setTva(dtos.get(0).getTva());
            articles.setReduction(dtos.get(0).getReduction());
            articles.setOffert(dtos.get(0).getOffert());
            articles.setFamille_id(dtos.get(0).getFamille_id());
            articles.setCarton_id(dtos.get(0).getCarton_id());
            articles.setCommandesM_id(dtos.get(0).getCommandesM_id());
            articles.setCommandesC_id(dtos.get(0).getCommandesC_id());
        }
        return articles;
    }

    public List<Articles> read() {
        List<Articles> listArticles = null;
        List<ArticlesDTO> dtos = this.jdbcTemplate.query("select * from articles", this.rowMapper);
        if(dtos != null && dtos.size() > 0) {
            listArticles = new ArrayList<Articles> ();
            for (ArticlesDTO dto : dtos) {
                Articles resp = new Articles();
                resp.setArticle_id(dto.getArticle_id());
                resp.setTva(dto.getTva());
                resp.setReduction(dto.getReduction());
                resp.setOffert(dto.getOffert());
                resp.setFamille_id(dto.getFamille_id());
                resp.setCarton_id(dto.getCarton_id());
                resp.setCommandesM_id(dto.getCommandesM_id());
                resp.setCommandesC_id(dto.getCommandesC_id());
                listArticles.add(resp);
            }
        }
        return listArticles;
    }
}
