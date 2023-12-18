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
            return commandesClientsDAO.create(commandesClients);
        }else {
            return commandesClientsDAORest.create(commandesClients);
        }
    }

    public boolean deleteCommandesClientsBusiness(int adresse_id, boolean rest){
        //DELETE BDD
        if(rest){
            return commandesClientsDAO.delete(adresse_id);
        }else {
            return commandesClientsDAORest.delete(adresse_id);
        }
    }

    public CommandesClients updateCommandesClientsBusinesss(int adresse_id, NewCommandesClients commandesClients, boolean rest){
        //UPDATE BDD
        if(rest){
            return commandesClientsDAO.update(adresse_id, commandesClients);
        }else {
            return commandesClientsDAORest.update(adresse_id, commandesClients);
        }
    }

    public CommandesClients getCommandesClientsBusiness(int adresse_id, boolean rest) {
        if(rest){
            return commandesClientsDAO.read(adresse_id);
        }else {
            return commandesClientsDAORest.read(adresse_id);
        }
    }

    public List<CommandesClients> getAllCommandesClientsBusiness(boolean rest) {
        if(rest){
            return commandesClientsDAO.read();
        }else {
            return commandesClientsDAORest.read();
        }
    }
}
