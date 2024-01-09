package com.cesi.negosud.dao.livraisonsMagasins;

import com.cesi.negosud.controller.livraisonsMagasins.model.LivraisonsMagasins;
import com.cesi.negosud.controller.livraisonsMagasins.model.LivraisonsMagasins;
import com.cesi.negosud.controller.livraisonsMagasins.model.NewLivraisonsMagasins;
import com.cesi.negosud.dao.livraisonsMagasins.model.LivraisonsMagasinsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivraisonsMagasinsDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "livraisonMagasin_id";
    private static final String DATE_FIELD = "date";
    private static final String COMMANDEMAGASINID_FIELD = "fk_commandeM";

    @Autowired
    public LivraisonsMagasinsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<LivraisonsMagasinsDTO> rowMapper = (rs, rowNum) -> {
        final LivraisonsMagasinsDTO livraisonsMagasins = new LivraisonsMagasinsDTO();
        livraisonsMagasins.setLivraisonMagasin_id(rs.getInt(ID_FIELD));
        livraisonsMagasins.setDate(rs.getTimestamp(DATE_FIELD));
        livraisonsMagasins.setCommandeMagasin_id(rs.getInt(COMMANDEMAGASINID_FIELD));
        return livraisonsMagasins;
    };

    public LivraisonsMagasins create(NewLivraisonsMagasins livraisonsMagasins) {
        //INSERT DANS BDD
        LivraisonsMagasins livraisonsMagasins1= null;
        final String query = "INSERT INTO livraisonsmagasin(date, fk_commandeM) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, livraisonsMagasins.getDate(), livraisonsMagasins.getCommandeMagasin_id());
        if(result ==1){
            //faire un select avant
            livraisonsMagasins1= new LivraisonsMagasins();
            livraisonsMagasins1.setDate(livraisonsMagasins.getDate());
            livraisonsMagasins1.setCommandeMagasin_id(livraisonsMagasins.getCommandeMagasin_id());
        }
        return livraisonsMagasins1;
    }

    public boolean delete(int livraisonMagasin_id){
        //DELETE DANS BDD
        final String query = ("DELETE from livraisonsmagasin where livraisonMagasin_id=?");
        int result = this.jdbcTemplate.update(query, livraisonMagasin_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public LivraisonsMagasins update(int livraisonMagasin_id, NewLivraisonsMagasins livraisonsMagasins){
        //UPDATE DANS BDD
        LivraisonsMagasins livraisonsMagasins1= null;
        final String query = "UPDATE livraisonsmagasin set date=?, fk_commandeM=? where livraisonMagasin_id=?";
        int result = this.jdbcTemplate.update(query, livraisonsMagasins.getDate(), livraisonsMagasins.getCommandeMagasin_id(), livraisonMagasin_id);
        if(result ==1){
            livraisonsMagasins1= new LivraisonsMagasins();
            livraisonsMagasins1.setLivraisonMagasin_id(livraisonMagasin_id);
            livraisonsMagasins1.setDate(livraisonsMagasins.getDate());
            livraisonsMagasins1.setCommandeMagasin_id(livraisonsMagasins.getCommandeMagasin_id());
        }
        return livraisonsMagasins1;
    }

    public LivraisonsMagasins read(int livraisonMagasin_id) {
        // READ ONE PERSON DANS BDD
        List<LivraisonsMagasinsDTO> dtos = this.jdbcTemplate.query("select * from livraisonsmagasin where livraisonMagasin_id ="+livraisonMagasin_id, this.rowMapper);
        LivraisonsMagasins livraisonsMagasins = null;
        if(dtos != null && dtos.size() == 1){
            livraisonsMagasins = new LivraisonsMagasins();
            livraisonsMagasins.setLivraisonMagasin_id(dtos.get(0).getLivraisonMagasin_id());
            livraisonsMagasins.setDate(dtos.get(0).getDate());
            livraisonsMagasins.setCommandeMagasin_id(dtos.get(0).getCommandeMagasin_id());
        }
        return livraisonsMagasins;
    }

    public List<LivraisonsMagasins> read() {
        // READ ALL PERSON DANS BDD
        List<LivraisonsMagasins> listLivraisonsMagasins = null;
        List<LivraisonsMagasinsDTO> dtos = this.jdbcTemplate.query("select * from livraisonsmagasin", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listLivraisonsMagasins = new ArrayList<LivraisonsMagasins> ();
            for (LivraisonsMagasinsDTO dto : dtos) {
                LivraisonsMagasins resp = new LivraisonsMagasins();
                resp.setLivraisonMagasin_id(dto.getLivraisonMagasin_id());
                resp.setDate(dto.getDate());
                resp.setCommandeMagasin_id(dto.getCommandeMagasin_id());
                listLivraisonsMagasins.add(resp);
            }
        }
        return listLivraisonsMagasins;
    }

}
