package com.cesi.negosud.business.clients;

import com.cesi.negosud.controller.clients.model.Clients;
import com.cesi.negosud.controller.clients.model.NewClients;
import com.cesi.negosud.dao.clients.ClientsDAO;
import com.cesi.negosud.dao.clients.ClientsDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsBusiness {

    private final ClientsDAO clientsDAO;
    private final ClientsDAORest clientsDAORest;

    @Autowired
    public ClientsBusiness(ClientsDAO clientsDAO, ClientsDAORest clientsDAORest){
        this.clientsDAO = clientsDAO;
        this.clientsDAORest = clientsDAORest;
    }

    public Clients createCleintsBusiness(NewClients clients, boolean rest){
        //INSERT BDD
        if(rest){
            return clientsDAO.create(clients);
        }else {
            return clientsDAORest.create(clients);
        }
    }

    public boolean deleteClientsBusiness(int client_id, boolean rest){
        //DELETE BDD
        if(rest){
            return clientsDAO.delete(client_id);
        }else {
            return clientsDAORest.delete(client_id);
        }
    }

    public Clients updateClientsBusinesss(int client_id, NewClients Clients, boolean rest){
        //UPDATE BDD
        if(rest){
            return clientsDAO.update(client_id, Clients);
        }else {
            return clientsDAORest.update(client_id, Clients);
        }
    }

    public Clients getClientsBusiness(int client_id, boolean rest) {
        if(rest){
            return clientsDAO.read(client_id);
        }else {
            return clientsDAORest.read(client_id);
        }
    }

    public List<Clients> getAllClientsBusiness(boolean rest) {
        if(rest){
            return clientsDAO.read();
        }else {
            return clientsDAO.read();
        }
    }
}
