package com.cesi.negosud.dao.factures;

import com.cesi.negosud.controller.factures.model.Factures;
import com.cesi.negosud.controller.factures.model.NewFactures;
import com.cesi.negosud.dao.factures.model.FacturesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FacturesDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "facture_id";
    private static final String DATE_FIELD = "date";
    private static final String MARGE_FIELD = "marge";
    private static final String COMMANDECLIENTID_FIELD = "fk_commandeC";


    @Autowired
    public FacturesDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<FacturesDTO> rowMapper = (rs, rowNum) -> {
        final FacturesDTO factures = new FacturesDTO();
        factures.setFacture_id(rs.getInt(ID_FIELD));
        factures.setDate(rs.getTimestamp(DATE_FIELD));
        factures.setMarge(Float.parseFloat (rs.getString(MARGE_FIELD)));
        factures.setCommandeClient_id(rs.getInt(COMMANDECLIENTID_FIELD));
        return factures;
    };



    public Factures create(NewFactures factures) {
        //INSERT DANS BDD
        Factures factures1= null;
        final String query = "INSERT INTO factures(date, marge, fk_commandeC) VALUES(?,?,?)";
        int result = this.jdbcTemplate.update(query, factures.getDate(), factures.getMarge(), factures.getCommandeClient_id());
        if(result ==1){
            List<Factures> listFactures = read();
            factures1= new Factures();
            factures1.setFacture_id(listFactures.get(listFactures.size() - 1).getFacture_id());
            factures1.setDate(factures.getDate());
            factures1.setMarge(factures.getMarge());
            factures1.setCommandeClient_id (factures.getCommandeClient_id());
        }
        return factures1;
    }

    public boolean delete(int facture_id){
        //DELETE DANS BDD
        final String query = ("DELETE from factures where facture_id=?");
        int result = this.jdbcTemplate.update(query, facture_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Factures update(int facture_id, NewFactures factures){
        //UPDATE DANS BDD
        Factures factures1= null;
        final String query = "UPDATE factures set date=?, marge=?, fk_commandeC=? where facture_id=?";
        int result = this.jdbcTemplate.update(query, factures.getDate(), factures.getMarge(), factures.getCommandeClient_id(), facture_id);
        if(result ==1){
            factures1= new Factures();
            factures1.setFacture_id(facture_id);
            factures1.setDate(factures.getDate());
            factures1.setMarge(factures.getMarge());
            factures1.setCommandeClient_id(factures.getCommandeClient_id());
        }
        return factures1;
    }

    public Factures read(int facture_id) {
        // READ ONE PERSON DANS BDD
        List<FacturesDTO> dtos = this.jdbcTemplate.query("select * from factures where facture_id ="+facture_id, this.rowMapper);
        Factures factures = null;
        if(dtos != null && dtos.size() == 1){
            factures = new Factures();
            factures.setFacture_id(dtos.get(0).getFacture_id());
            factures.setDate(dtos.get(0).getDate());
            factures.setMarge(dtos.get(0).getMarge());
            factures.setCommandeClient_id(dtos.get(0).getCommandeClient_id());
        }
        return factures;
    }

    public List<Factures> read() {
        // READ ALL PERSON DANS BDD
        List<Factures> listFactures = null;
        List<FacturesDTO> dtos = this.jdbcTemplate.query("select * from factures", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listFactures = new ArrayList<Factures> ();
            for (FacturesDTO dto : dtos) {
                Factures resp = new Factures();
                resp.setFacture_id(dto.getFacture_id());
                resp.setDate(dto.getDate());
                resp.setMarge(dto.getMarge());
                resp.setCommandeClient_id(dto.getCommandeClient_id());
                listFactures.add(resp);
            }
        }
        return listFactures;
    }

}

