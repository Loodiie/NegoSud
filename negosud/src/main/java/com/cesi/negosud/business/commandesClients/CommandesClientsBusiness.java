package com.cesi.negosud.business.commandesClients;

import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import com.cesi.negosud.controller.commandesClients.model.NewCommandesClients;
import com.cesi.negosud.dao.commandesClients.CommandesClientsDAO;
import com.cesi.negosud.dao.commandesClients.CommandesClientsDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommandesClientsBusiness {
    private final CommandesClientsDAO commandesClientsDAO;
    private final CommandesClientsDAORest commandesClientsDAORest;
    @Autowired
    public CommandesClientsBusiness(CommandesClientsDAO commandesClientsDAO, CommandesClientsDAORest commandesClientsDAORest) {
        this.commandesClientsDAO = commandesClientsDAO;
        this.commandesClientsDAORest = commandesClientsDAORest;
    }

    public CommandesClients createCommandesClientsBusiness(NewCommandesClients commandesClients, boolean rest) {
        //INSERT BDD
        if(rest){
            return commandesClientsDAORest.create(commandesClients);
        }else {
            return commandesClientsDAO.create(commandesClients);
        }
    }

    public boolean deleteCommandesClientsBusiness(int commandeClient_id, boolean rest){
        //DELETE BDD
        if(rest){
            return commandesClientsDAORest.delete(commandeClient_id);
        }else {
            return commandesClientsDAO.delete(commandeClient_id);
        }
    }

    public CommandesClients updateCommandesClientsBusinesss(int commandeClient_id, NewCommandesClients commandesClients, boolean rest){
        //UPDATE BDD
        if(rest){
            return commandesClientsDAORest.update(commandeClient_id, commandesClients);
        }else {
            return commandesClientsDAO.update(commandeClient_id, commandesClients);
        }
    }

    public CommandesClients getCommandesClientsBusiness(int commandeClient_id, boolean rest) {
        if(rest){
            return commandesClientsDAORest.read(commandeClient_id);
        }else {
            return commandesClientsDAO.read(commandeClient_id);
        }
    }

    public List<CommandesClients> getAllCommandesClientsBusiness(boolean rest) {
        if(rest){
            return commandesClientsDAORest.read();
        }else {
            return commandesClientsDAO.read();
        }
    }
}
