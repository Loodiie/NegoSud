package com.cesi.negosud.dao.lignesCC;

import com.cesi.negosud.controller.fournisseurs.model.Fournisseurs;
import com.cesi.negosud.controller.lignesCC.model.LignesCC;
import com.cesi.negosud.controller.lignesCC.model.NewLignesCC;
import com.cesi.negosud.dao.fournisseurs.model.FournisseursDTO;
import com.cesi.negosud.dao.lignesCC.model.LignesCCDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LignesCCDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String FKARTICLE_FIELD = "fk_article";
    private static final String FKCC_FIELD = "fk_CC";

    @Autowired
    public LignesCCDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<LignesCCDTO> rowMapper = (rs, rowNum) -> {
        final LignesCCDTO lignesCC = new LignesCCDTO ();
        lignesCC.setFk_article(rs.getInt(FKARTICLE_FIELD));
        lignesCC.setFk_CC(rs.getInt(FKCC_FIELD));
        return lignesCC;
    };

    public LignesCC create(NewLignesCC lignesCC){
        LignesCC lignesCC1 = null;
        final String query = "INSERT INTO lignescommandeclient(fk_article, fk_CC) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, lignesCC.getFk_article(), lignesCC.getFk_CC());
        if(result == 1){
            lignesCC1 = new LignesCC();
            lignesCC1.setFk_article(lignesCC.getFk_article());
            lignesCC1.setFk_CC(lignesCC.getFk_CC());
        }
        return lignesCC1;
    }

    public boolean delete(int article_id, int commandeCLient_id){
        final String query = ("DELETE from lignescommandeclient where fk_article=? and fk_CC=?");
        int result = this.jdbcTemplate.update(query, article_id, commandeCLient_id);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    public LignesCC update(int article_id, int commandeClient_id, NewLignesCC lignesCC){
        LignesCC lignesCC1 = null;
        final String query = "UPDATE lignescommandeclient set fk_article=?, fk_CC=? where fk_article=? and fk_CC=?";
        int result = this.jdbcTemplate.update(query, lignesCC.getFk_article(), lignesCC.getFk_CC(), article_id, commandeClient_id);
        if(result == 1){
            lignesCC1 = new LignesCC();
            lignesCC1.setFk_article(lignesCC.getFk_article());
            lignesCC1.setFk_article(lignesCC.getFk_CC());
        }
        return lignesCC1;
    }

    public LignesCC read(int article_id, int commandeClient_id) {
        // READ ONE PERSON DANS BDD
        List<LignesCCDTO> dtos = this.jdbcTemplate.query("select * frome lignescommandeclient where fk_article and fk_CC=" + article_id + commandeClient_id, this.rowMapper);
        LignesCC lignesCC = null;
        if(dtos != null && dtos.size() == 1){
            lignesCC = new LignesCC();
            lignesCC.setFk_article(dtos.get(0).getFk_article());
            lignesCC.setFk_CC(dtos.get(0).getFk_CC());
        }
        return lignesCC;
    }

    public List<LignesCC> read(){
        List<LignesCC> listLignesCC = null;
        List<LignesCCDTO> dtos = this.jdbcTemplate.query("select * from lignescommandeclient", this.rowMapper);
        if(dtos != null && dtos.size() > 0){
            listLignesCC = new ArrayList<LignesCC>();
            for(LignesCCDTO dto : dtos){
                LignesCC resp = new LignesCC();
                resp.setFk_article(dto.getFk_article());
                resp.setFk_CC(dto.getFk_CC());
                listLignesCC.add(resp);
            }
        }
        return listLignesCC;
    }

}
