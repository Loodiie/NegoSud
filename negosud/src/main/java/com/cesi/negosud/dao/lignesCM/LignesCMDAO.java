package com.cesi.negosud.dao.lignesCM;

import com.cesi.negosud.controller.lignesCM.model.LignesCM;
import com.cesi.negosud.controller.lignesCM.model.NewLignesCM;
import com.cesi.negosud.dao.lignesCM.model.LignesCMDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LignesCMDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String FKARTICLE_FIELD = "fk_article";
    private static final String FKCM_FIELD = "fk_Cm";

    @Autowired
    public LignesCMDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<LignesCMDTO> rowMapper = (rs, rowNum) -> {
        final LignesCMDTO lignesCM = new LignesCMDTO ();
        lignesCM.setFk_article(rs.getInt(FKARTICLE_FIELD));
        lignesCM.setFk_CM(rs.getInt(FKCM_FIELD));
        return lignesCM;
    };

    public LignesCM create(NewLignesCM lignesCM){
        LignesCM lignesCM1 = null;
        final String query = "INSERT INTO lignescommandemagasin(fk_article, fk_CM) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, lignesCM.getFk_article(), lignesCM.getFk_CM());
        if(result == 1){
            lignesCM1 = new LignesCM();
            lignesCM1.setFk_article(lignesCM.getFk_article());
            lignesCM1.setFk_CM(lignesCM.getFk_CM());
        }
        return lignesCM1;
    }

    public boolean delete(int article_id, int commandeMag_id){
        final String query = ("DELETE from lignescommandemagasin where fk_article=? and fk_CC=?");
        int result = this.jdbcTemplate.update(query, article_id, commandeMag_id);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    public LignesCM update(int article_id, int commandeMag_id, NewLignesCM lignesCM){
        LignesCM lignesCM1 = null;
        final String query = "UPDATE lignescommandemagasin set fk_article=?, fk_CM=? where fk_article=? and fk_CM=?";
        int result = this.jdbcTemplate.update(query, lignesCM.getFk_article(), lignesCM.getFk_CM(), article_id, commandeMag_id);
        if(result == 1){
            lignesCM1 = new LignesCM();
            lignesCM1.setFk_article(lignesCM.getFk_article());
            lignesCM1.setFk_article(lignesCM.getFk_CM());
        }
        return lignesCM1;
    }

    public LignesCM read(int article_id, int commandeMag_id) {
        // READ ONE PERSON DANS BDD
        List<LignesCMDTO> dtos = this.jdbcTemplate.query("select * frome lignescommandemagasin where fk_article and fk_CM=" + article_id + commandeMag_id, this.rowMapper);
        LignesCM lignesCM = null;
        if(dtos != null && dtos.size() == 1){
            lignesCM = new LignesCM();
            lignesCM.setFk_article(dtos.get(0).getFk_article());
            lignesCM.setFk_CM(dtos.get(0).getFk_CM());
        }
        return lignesCM;
    }

    public List<LignesCM> read(){
        List<LignesCM> listLignesCM = null;
        List<LignesCMDTO> dtos = this.jdbcTemplate.query("select * from lignescommandemagasin", this.rowMapper);
        if(dtos != null && dtos.size() > 0){
            listLignesCM = new ArrayList<LignesCM>();
            for(LignesCMDTO dto : dtos){
                LignesCM resp = new LignesCM();
                resp.setFk_article(dto.getFk_article());
                resp.setFk_CM(dto.getFk_CM());
                listLignesCM.add(resp);
            }
        }
        return listLignesCM;
    }

}
