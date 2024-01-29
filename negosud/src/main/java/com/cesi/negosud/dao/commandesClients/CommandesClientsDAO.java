package com.cesi.negosud.dao.commandesClients;

import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import com.cesi.negosud.controller.commandesClients.model.NewCommandesClients;
import com.cesi.negosud.dao.commandesClients.model.CommandesClientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommandesClientsDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "commandeClient_id";
    private static final String DATE_FIELD = "date";
    private static final String CLIENTID_FIELD = "fk_client";

    @Autowired
    public CommandesClientsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<CommandesClientsDTO> rowMapper = (rs, rowNum) -> {
        final CommandesClientsDTO commandesClients = new CommandesClientsDTO();
        commandesClients.setCommandeClient_id(rs.getInt(ID_FIELD));
        commandesClients.setDate(rs.getTimestamp (DATE_FIELD));
        commandesClients.setClient_id(rs.getInt(CLIENTID_FIELD));
        return commandesClients;
    };

    public CommandesClients create(NewCommandesClients commandesClients) {
        //INSERT DANS BDD
        CommandesClients commandesClients1= null;
        final String query = "INSERT INTO commandesclients(date, fk_client) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, commandesClients.getDate(), commandesClients.getClient_id());
        if(result ==1){
            List<CommandesClients> listCC = read();
            commandesClients1= new CommandesClients();
            commandesClients1.setCommandeClient_id(listCC.get(listCC.size() - 1).getCommandeClient_id());
            commandesClients1.setDate(commandesClients.getDate());
            commandesClients1.setClient_id(commandesClients.getClient_id());
        }
        return commandesClients1;
    }

    public boolean delete(int commandeClient_id){
        //DELETE DANS BDD
        final String query = ("DELETE from commandesclients where commandeClient_id=?");
        int result = this.jdbcTemplate.update(query, commandeClient_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public CommandesClients update(int commandeClient_id, NewCommandesClients commandesClients){
        //UPDATE DANS BDD
        CommandesClients commandesClients1= null;
        final String query = "UPDATE commandesclients set date=?, fk_client=? where commandeClient_id=?";
        int result = this.jdbcTemplate.update(query, commandesClients.getDate(), commandesClients.getClient_id(), commandeClient_id);
        if(result ==1){
            commandesClients1= new CommandesClients();
            commandesClients1.setCommandeClient_id(commandeClient_id);
            commandesClients1.setDate(commandesClients.getDate());
            commandesClients1.setClient_id(commandesClients.getClient_id());
        }
        return commandesClients1;
    }

    public CommandesClients read(int commandeClient_id) {
        // READ ONE PERSON DANS BDD
        List<CommandesClientsDTO> dtos = this.jdbcTemplate.query("select * from commandesclients where commandeClient_id ="+commandeClient_id, this.rowMapper);
        CommandesClients commandesClients = null;
        if(dtos != null && dtos.size() == 1){
            commandesClients = new CommandesClients();
            commandesClients.setCommandeClient_id(dtos.get(0).getCommandeClient_id());
            commandesClients.setDate(dtos.get(0).getDate());
            commandesClients.setClient_id(dtos.get(0).getClient_id());
        }
        return commandesClients;
    }

    public List<CommandesClients> read() {
        // READ ALL PERSON DANS BDD
        List<CommandesClients> listCommandesClients = null;
        List<CommandesClientsDTO> dtos = this.jdbcTemplate.query("select * from commandesclients", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listCommandesClients = new ArrayList<CommandesClients> ();
            for (CommandesClientsDTO dto : dtos) {
                CommandesClients resp = new CommandesClients();
                resp.setCommandeClient_id(dto.getCommandeClient_id());
                resp.setDate(dto.getDate());
                resp.setClient_id(dto.getClient_id());
                listCommandesClients.add(resp);
            }
        }
        return listCommandesClients;
    }

}
