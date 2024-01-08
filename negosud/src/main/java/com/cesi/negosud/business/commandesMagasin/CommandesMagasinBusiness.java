package com.cesi.negosud.business.commandesMagasin;

import com.cesi.negosud.controller.commandesMagasin.model.CommandesMagasin;
import com.cesi.negosud.controller.commandesMagasin.model.NewCommandesMagasin;
import com.cesi.negosud.dao.commandesMagasin.CommandesMagasinDAO;
import com.cesi.negosud.dao.commandesMagasin.CommandesMagasinDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommandesMagasinBusiness {
    private final CommandesMagasinDAO commandesMagasinDAO;
    private final CommandesMagasinDAORest commandesMagasinDAORest;
    @Autowired
    public CommandesMagasinBusiness(CommandesMagasinDAO commandesMagasinDAO, CommandesMagasinDAORest commandesMagasinDAORest) {
        this.commandesMagasinDAO = commandesMagasinDAO;
        this.commandesMagasinDAORest = commandesMagasinDAORest;
    }

    public CommandesMagasin createCommandesMagasinBusiness(NewCommandesMagasin commandesMagasin, boolean rest) {
        //INSERT BDD
        if(rest){
            return commandesMagasinDAORest.create(commandesMagasin);
        }else {
            return commandesMagasinDAO.create(commandesMagasin);
        }
    }

    public boolean deleteCommandesMagasinBusiness(int commandeMag_id, boolean rest){
        //DELETE BDD
        if(rest){
            return commandesMagasinDAORest.delete(commandeMag_id);
        }else {
            return commandesMagasinDAO.delete(commandeMag_id);
        }
    }

    public CommandesMagasin updateCommandesMagasinBusinesss(int commandeMag_id, NewCommandesMagasin commandesMagasin, boolean rest){
        //UPDATE BDD
        if(rest){
            return commandesMagasinDAORest.update(commandeMag_id, commandesMagasin);
        }else {
            return commandesMagasinDAO.update(commandeMag_id, commandesMagasin);
        }
    }

    public CommandesMagasin getCommandesMagasinBusiness(int commandesMagasin_id, boolean rest) {
        if(rest){
            return commandesMagasinDAORest.read(commandesMagasin_id);
        }else {
            return commandesMagasinDAO.read(commandesMagasin_id);
        }
    }

    public List<CommandesMagasin> getAllCommandesMagasinBusiness(boolean rest) {
        if(rest){
            return commandesMagasinDAORest.read();
        }else {
            return commandesMagasinDAO.read();
        }
    }
}
