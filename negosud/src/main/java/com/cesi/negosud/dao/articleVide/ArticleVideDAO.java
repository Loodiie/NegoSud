package com.cesi.negosud.dao.articleVide;

import com.cesi.negosud.controller.articleVide.model.ArticleVide;
import com.cesi.negosud.controller.articleVide.model.NewArticleVide;
import com.cesi.negosud.dao.articleVide.model.ArticleVideDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleVideDAO {

    private final JdbcTemplate jdbcTemplate;

    private static String ARTICLEVIDEID_FIELD = "articleVide_id";
    private static  String FAMILLE_FIELD = "fk_famille";

    @Autowired
    public ArticleVideDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<ArticleVideDTO> rowMapper = (rs, rowNum) -> {
        final ArticleVideDTO articleVide = new ArticleVideDTO();
        articleVide.setArticleVide_id(rs.getInt(ARTICLEVIDEID_FIELD));
        articleVide.setFamille_id(rs.getInt(FAMILLE_FIELD));
        return articleVide;
    };

    public ArticleVide create(NewArticleVide articleVide){
        ArticleVide articleVide1 = null;
        final String query = "INSERT INTO articleVide(fk_famille) VALUES(?)";
        int result = this.jdbcTemplate.update(query, articleVide.getFamille_id());
        if(result ==1){
            List<ArticleVide> listArticleVide = read();
            articleVide1 = new ArticleVide();
            articleVide1.setArticleVide_id(listArticleVide.get(listArticleVide.size() - 1).getArticleVide_id());
            articleVide1.setFamille_id(articleVide.getFamille_id());
        }
        return articleVide1;
    }

    public boolean delete(int articleVide_id){
        ArticleVide articleVide = null;
        final String query = ("DELETE from ArticleVide where articleVide_id=?");
        int result = this.jdbcTemplate.update(query, articleVide_id);
        if(result ==1){
            return true;
        }else {
            return false;
        }
    }

    public ArticleVide update(int articleVide_id, NewArticleVide articleVide){
        ArticleVide articleVide1 = null;
        final String query = "UPDATE articleVide set fk_famille=? where articleVide_id=?";
        int result = this.jdbcTemplate.update(query, articleVide.getFamille_id(), articleVide_id);
        if(result == 1){
            articleVide1 = new ArticleVide();
            articleVide1.setArticleVide_id(articleVide_id);
            articleVide1.setFamille_id(articleVide.getFamille_id());
        }
        return articleVide1;
    }

    public ArticleVide read(int articleVide_id){
        List<ArticleVideDTO> dtos = this.jdbcTemplate.query("select * from articleVide where articleVide_id="+articleVide_id, this.rowMapper);
        ArticleVide articleVide = null;
        if(dtos != null && dtos.size() == 1){
            articleVide = new ArticleVide();
            articleVide.setArticleVide_id(dtos.get(0).getArticleVide_id());
            articleVide.setFamille_id(dtos.get(0).getFamille_id());
        }
        return articleVide;
    }

    public List<ArticleVide> read(){
        List<ArticleVide> listArticleVide = null;
        List<ArticleVideDTO> dtos = this.jdbcTemplate.query("select * from articleVide", this.rowMapper);
        if( dtos!= null && dtos.size() > 0){
            listArticleVide = new ArrayList<ArticleVide>();
            for(ArticleVideDTO dto : dtos){
                ArticleVide resp = new ArticleVide();
                resp.setArticleVide_id(dto.getArticleVide_id());
                resp.setFamille_id(dto.getFamille_id());
                listArticleVide.add(resp);
            }
        }
        return listArticleVide;
    }

}
