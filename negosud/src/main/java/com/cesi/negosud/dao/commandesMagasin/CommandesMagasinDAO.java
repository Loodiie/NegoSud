package com.cesi.negosud.dao.commandesMagasin;

import com.cesi.negosud.controller.commandesMagasin.model.CommandesMagasin;
import com.cesi.negosud.controller.commandesMagasin.model.CommandesMagasin;
import com.cesi.negosud.controller.commandesMagasin.model.NewCommandesMagasin;
import com.cesi.negosud.dao.commandesMagasin.model.CommandesMagasinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommandesMagasinDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "commandeMag_id";
    private static final String DATE_FIELD = "date";
    private static final String FOURNISSEURID_FIELD = "fournisseur_id";

    @Autowired
    public CommandesMagasinDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<CommandesMagasinDTO> rowMapper = (rs, rowNum) -> {
        final CommandesMagasinDTO commandesMagasin = new CommandesMagasinDTO();
        commandesMagasin.setCommandeMag_id(rs.getInt(ID_FIELD));
        commandesMagasin.setDate(rs.getTimestamp(DATE_FIELD));
        commandesMagasin.setFournisseur_id(rs.getInt(FOURNISSEURID_FIELD));
        return commandesMagasin;
    };

    public CommandesMagasin create(NewCommandesMagasin commandesMagasin) {
        //INSERT DANS BDD
        CommandesMagasin commandesMagasin1= null;
        final String query = "INSERT INTO commandesMagasin(date, fournisseur_id) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, commandesMagasin.getDate(), commandesMagasin.getFournisseur_id());
        if(result ==1){
            //faire un select avant
            commandesMagasin1= new CommandesMagasin();
            commandesMagasin1.setDate(commandesMagasin.getDate());
            commandesMagasin1.setFournisseur_id(commandesMagasin.getFournisseur_id());
        }
        return commandesMagasin1;
    }

    public boolean delete(int commandeMag_id){
        //DELETE DANS BDD
        final String query = ("DELETE from commandesMagasin where id=?");
        int result = this.jdbcTemplate.update(query, commandeMag_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public CommandesMagasin update(int commandeMag_id, NewCommandesMagasin commandesMagasin){
        //UPDATE DANS BDD
        CommandesMagasin commandesMagasin1= null;
        final String query = "UPADATE commandesMagasin set date=?, fournisseur_id=? where id=?";
        int result = this.jdbcTemplate.update(query, commandesMagasin.getDate(), commandesMagasin.getFournisseur_id());
        if(result ==1){
            commandesMagasin1= new CommandesMagasin();
            commandesMagasin1.setCommandeMag_id(commandeMag_id);
            commandesMagasin1.setDate(commandesMagasin.getDate());
            commandesMagasin1.setFournisseur_id(commandesMagasin.getFournisseur_id());
        }
        return commandesMagasin1;
    }

    public CommandesMagasin read(int commandeMag_id) {
        // READ ONE PERSON DANS BDD
        List<CommandesMagasinDTO> dtos = this.jdbcTemplate.query("select * from commandesMagasin where commandeMag_id ="+commandeMag_id, this.rowMapper);
        CommandesMagasin commandesMagasin = null;
        if(dtos != null && dtos.size() == 1){
            commandesMagasin = new CommandesMagasin();
            commandesMagasin.setCommandeMag_id(dtos.get(0).getCommandeMag_id());
            commandesMagasin.setDate(dtos.get(0).getDate());
            commandesMagasin.setFournisseur_id(dtos.get(0).getFournisseur_id());
        }
        return commandesMagasin;
    }

    public List<CommandesMagasin> read() {
        // READ ALL PERSON DANS BDD
        List<CommandesMagasin> listCommandesMagasin = null;
        List<CommandesMagasinDTO> dtos = this.jdbcTemplate.query("select * from commandesMagasin", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listCommandesMagasin = new ArrayList<CommandesMagasin> ();
            for (CommandesMagasinDTO dto : dtos) {
                CommandesMagasin resp = new CommandesMagasin();
                resp.setCommandeMag_id(dto.getCommandeMag_id());
                resp.setDate(dto.getDate());
                resp.setFournisseur_id(dto.getFournisseur_id());
                listCommandesMagasin.add(resp);
            }
        }
        return listCommandesMagasin;
    }

}
