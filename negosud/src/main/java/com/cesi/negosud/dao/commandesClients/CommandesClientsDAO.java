package com.cesi.negosud.dao.clients;

import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
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
    private static final String ADRESSEID_FIELD = "adresse_id";

    @Autowired
    public CommandesClientsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<CommandesClientsDAO> rowMapper = (rs, rowNum) -> {
        final CommandesClientsDAO commandesClients = new ClientsDTO();
        commandesClients.setCommandeClient_id(rs.getInt(ID_FIELD));
        commandesClients.setDate(rs.getString(DATE_FIELD));
        commandesClients.setAdresse_id(rs.getInt(ADRESSEID_FIELD));
        return commandesClients;
    };

    public CommandesClients create(NewCommandesClients commandesClients) {
        //INSERT DANS BDD
        CommandesClients ccommandesClients1= null;
        final String query = "INSERT INTO commandesClients(date, adresse_id) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query, clients.getDate(), clients.getAdresse_id());
        if(result ==1){
            //faire un select avant
            ccommandesClients1= new CommandesClients();
            ccommandesClients1.setNom(commandesClients.getDate());
            ccommandesClients1.setAdresse_id(clients.getAdresse_id());
        }
        return ccommandesClients1;
    }

    public boolean delete(int commandeClient_id){
        //DELETE DANS BDD
        final String query = ("DELETE from commandesClients where id=?");
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
        final String query = "UPADATE commandesClients set date=?, adresse_id=? where id=?";
        int result = this.jdbcTemplate.update(query, commandesClients.getDate(), clients.getAdresse_id());
        if(result ==1){
            commandesClients1= new CommandesClients();
            commandesClients1.setCommandeClient_id(commandeClient_id);
            commandesClients1.setNDate(clients.getDate());
            commandesClients1.setAdresse_id(clients.getAdresse_id());
        }
        return commandesClients1;
    }

    public CommandesClients read(int commandeClient_id) {
        // READ ONE PERSON DANS BDD
        List<CommandesClientsDTO> dtos = this.jdbcTemplate.query("select * from commandesClients where commandeClient_id ="+commandeClient_id, this.rowMapper);
        CommandesClients commandesClients = null;
        if(dtos != null && dtos.size() == 1){
            commandesClients = new CommandesClients();
            commandesClients.setCommandeClient_id(dtos.get(0).getCommandeClient_id());
            commandesClients.setDate(dtos.get(0).getDate());
            commandesClients.setAdresse_id(dtos.get(0).getAdresse_id());
        }
        return commandesClients;
    }

    public List<CommandesClients> read() {
        // READ ALL PERSON DANS BDD
        List<CommandesClients> listCommandesClients = null;
        List<CommandesClientsDTO> dtos = this.jdbcTemplate.query("select * from commandesClients", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listCommandesClients = new ArrayList<CommandesClients> ();
            for (CommandesClientsDTO dto : dtos) {
                CommandesClients resp = new CommandesClients();
                resp.setCommandeClient_id(dto.getCommandeClient_id());
                resp.setDate(dto.getDate());
                resp.setAdresse_id(dto.getAdresse_id());
                listCommandesClients.add(resp);
            }
        }
        return listCommandesClients;
    }

}
