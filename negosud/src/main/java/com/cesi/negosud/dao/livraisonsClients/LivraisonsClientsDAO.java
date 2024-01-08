package com.cesi.negosud.dao.livraisonsClients;

import com.cesi.negosud.controller.livraisonsClients.model.LivraisonsClients;
import com.cesi.negosud.controller.livraisonsClients.model.LivraisonsClients;
import com.cesi.negosud.controller.livraisonsClients.model.NewLivraisonsClients;
import com.cesi.negosud.dao.livraisonsClients.model.LivraisonsClientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivraisonsClientsDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "livraisonClient_id";
    private static final String DATE_FIELD = "date";
    private static final String COMMANDECLIENTID_FIELD = "commandeClient_id";

    @Autowired
    public LivraisonsClientsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<LivraisonsClientsDTO> rowMapper = (rs, rowNum) -> {
        final LivraisonsClientsDTO livraisonsClients = new LivraisonsClientsDTO();
        livraisonsClients.setLivraisonClient_id(rs.getInt(ID_FIELD));
        livraisonsClients.setDate(rs.getTimestamp(DATE_FIELD));
        livraisonsClients.setCommandeClient_id(rs.getInt(COMMANDECLIENTID_FIELD));
        return livraisonsClients;
    };

    public LivraisonsClients create(NewLivraisonsClients livraisonsClients) {
        //INSERT DANS BDD
        LivraisonsClients livraisonsClients1= null;
        final String query = "INSERT INTO livraisonsClients(date, commandeClient_id) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, livraisonsClients.getDate(), livraisonsClients.getCommandeClient_id());
        if(result ==1){
            //faire un select avant
            livraisonsClients1= new LivraisonsClients();
            livraisonsClients1.setDate(livraisonsClients.getDate());
            livraisonsClients1.setCommandeClient_id(livraisonsClients.getCommandeClient_id());
        }
        return livraisonsClients1;
    }

    public boolean delete(int livraisonClient_id){
        //DELETE DANS BDD
        final String query = ("DELETE from livraisonsClients where id=?");
        int result = this.jdbcTemplate.update(query, livraisonClient_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public LivraisonsClients update(int livraisonClient_id, NewLivraisonsClients livraisonsClients){
        //UPDATE DANS BDD
        LivraisonsClients livraisonsClients1= null;
        final String query = "UPADATE livraisonsClients set date=?, commandeClient_id=? where id=?";
        int result = this.jdbcTemplate.update(query, livraisonsClients.getDate(), livraisonsClients.getCommandeClient_id());
        if(result ==1){
            livraisonsClients1= new LivraisonsClients();
            livraisonsClients1.setLivraisonClient_id(livraisonClient_id);
            livraisonsClients1.setDate(livraisonsClients.getDate());
            livraisonsClients1.setCommandeClient_id(livraisonsClients.getCommandeClient_id());
        }
        return livraisonsClients1;
    }

    public LivraisonsClients read(int livraisonClient_id) {
        // READ ONE PERSON DANS BDD
        List<LivraisonsClientsDTO> dtos = this.jdbcTemplate.query("select * from livraisonsClients where livraisonClient_id ="+livraisonClient_id, this.rowMapper);
        LivraisonsClients livraisonsClients = null;
        if(dtos != null && dtos.size() == 1){
            livraisonsClients = new LivraisonsClients();
            livraisonsClients.setLivraisonClient_id(dtos.get(0).getLivraisonClient_id());
            livraisonsClients.setDate(dtos.get(0).getDate());
            livraisonsClients.setCommandeClient_id(dtos.get(0).getCommandeClient_id());
        }
        return livraisonsClients;
    }

    public List<LivraisonsClients> read() {
        // READ ALL PERSON DANS BDD
        List<LivraisonsClients> listLivraisonsClients = null;
        List<LivraisonsClientsDTO> dtos = this.jdbcTemplate.query("select * from livraisonsClients", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listLivraisonsClients = new ArrayList<LivraisonsClients> ();
            for (LivraisonsClientsDTO dto : dtos) {
                LivraisonsClients resp = new LivraisonsClients();
                resp.setLivraisonClient_id(dto.getLivraisonClient_id());
                resp.setDate(dto.getDate());
                resp.setCommandeClient_id(dto.getCommandeClient_id());
                listLivraisonsClients.add(resp);
            }
        }
        return listLivraisonsClients;
    }

}
