package com.cesi.negosud.dao.clients;

import com.cesi.negosud.controller.clients.model.Clients;
import com.cesi.negosud.controller.clients.model.NewClients;
import com.cesi.negosud.dao.clients.model.ClientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientsDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "client_id";
    private static final String NOM_FIELD = "nom";
    private static final String PRENOM_FIELD = "prenom";
    private static final String TELEPHONE_FIELD = "telephone";
    private static final String MAIL_FIELD = "mail";
    private static final String ADRESSEID_FIELD = "fk_adresse";

    @Autowired
    public ClientsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<ClientsDTO> rowMapper = (rs, rowNum) -> {
        final ClientsDTO clients = new ClientsDTO();
        clients.setClient_id(rs.getInt(ID_FIELD));
        clients.setNom(rs.getString(NOM_FIELD));
        clients.setPrenom(rs.getString(PRENOM_FIELD));
        clients.setTelephone(rs.getString(TELEPHONE_FIELD));
        clients.setMail(rs.getString(MAIL_FIELD));
        clients.setAdresse_id(rs.getInt(ADRESSEID_FIELD));
        return clients;
    };

    public Clients create(NewClients clients) {
        //INSERT DANS BDD
        Clients clients1= null;
        final String query = "INSERT INTO clients(nom, prenom, telephone, mail, fk_adresse) VALUES(?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, clients.getNom(), clients.getPrenom(), clients.getTelephone(), clients.getMail(), clients.getAdresse_id());
        if(result ==1){
            //faire un select avant
            clients1= new Clients();
            clients1.setNom(clients.getNom());
            clients1.setPrenom(clients.getPrenom());
            clients1.setTelephone(clients.getTelephone());
            clients1.setMail(clients.getMail());
            clients1.setAdresse_id(clients.getAdresse_id());
        }
        return clients1;
    }

    public boolean delete(int client_id){
        //DELETE DANS BDD
        final String query = ("DELETE from clients where client_id=?");
        int result = this.jdbcTemplate.update(query, client_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Clients update(int client_id, NewClients clients){
        //UPDATE DANS BDD
        Clients clients1= null;
        final String query = "UPDATE clients set nom=?, prenom=?, telephone=?, mail=?, fk_adresse=? where client_id=?";
        int result = this.jdbcTemplate.update(query, clients.getNom(), clients.getPrenom(), clients.getTelephone(), clients.getMail(), clients.getAdresse_id(), client_id);
        if(result == 1){
            clients1= new Clients();
            clients1.setClient_id(client_id);
            clients1.setNom(clients.getNom());
            clients1.setPrenom(clients.getPrenom());
            clients1.setTelephone(clients.getTelephone());
            clients1.setMail(clients.getMail());
            clients1.setAdresse_id(clients.getAdresse_id());
        }
        return clients1;
    }

    public Clients read(int client_id) {
        // READ ONE PERSON DANS BDD
        List<ClientsDTO> dtos = this.jdbcTemplate.query("select * from clients where client_id ="+client_id, this.rowMapper);
        Clients clients = null;
        if(dtos != null && dtos.size() == 1){
            clients = new Clients();
            clients.setClient_id(dtos.get(0).getClient_id());
            clients.setNom(dtos.get(0).getNom());
            clients.setPrenom(dtos.get(0).getPrenom());
            clients.setTelephone(dtos.get(0).getTelephone());
            clients.setMail(dtos.get(0).getMail());
            clients.setAdresse_id(dtos.get(0).getAdresse_id());
        }
        return clients;
    }

    public List<Clients> read() {
        // READ ALL PERSON DANS BDD
        List<Clients> listClients = null;
        List<ClientsDTO> dtos = this.jdbcTemplate.query("select * from clients", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listClients = new ArrayList<Clients> ();
            for (ClientsDTO dto : dtos) {
                Clients resp = new Clients();
                resp.setClient_id(dto.getClient_id());
                resp.setNom(dto.getNom());
                resp.setPrenom(dto.getPrenom());
                resp.setTelephone(dto.getTelephone());
                resp.setMail(dto.getMail());
                resp.setAdresse_id(dto.getAdresse_id());
                listClients.add(resp);
            }
        }
        return listClients;
    }

}
