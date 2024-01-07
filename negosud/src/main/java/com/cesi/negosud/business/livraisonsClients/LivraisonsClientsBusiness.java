package com.cesi.negosud.business.livraisonsClients;

import com.cesi.negosud.controller.livraisonsClients.model.LivraisonsClients;
import com.cesi.negosud.controller.livraisonsClients.model.NewLivraisonsClients;
import com.cesi.negosud.dao.livraisonsClients.LivraisonsClientsDAO;
import com.cesi.negosud.dao.livraisonsClients.LivraisonsClientsDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LivraisonsClientsBusiness {
    private final LivraisonsClientsDAO livraisonsClientsDAO;
    private final LivraisonsClientsDAORest livraisonsClientsDAORest;
    @Autowired
    public LivraisonsClientsBusiness(LivraisonsClientsDAO livraisonsClientsDAO, LivraisonsClientsDAORest livraisonsClientsDAORest) {
        this.livraisonsClientsDAO = livraisonsClientsDAO;
        this.livraisonsClientsDAORest = livraisonsClientsDAORest;
    }

    public LivraisonsClients createLivraisonsClientsBusiness(NewLivraisonsClients livraisonsClients, boolean rest) {
        //INSERT BDD
        if(rest){
            return livraisonsClientsDAO.create(livraisonsClients);
        }else {
            return livraisonsClientsDAORest.create(livraisonsClients);
        }
    }

    public boolean deleteLivraisonsClientsBusiness(int livraisonClient_id, boolean rest){
        //DELETE BDD
        if(rest){
            return livraisonsClientsDAO.delete(livraisonClient_id);
        }else {
            return livraisonsClientsDAORest.delete(livraisonClient_id);
        }
    }

    public LivraisonsClients updateLivraisonsClientsBusinesss(int livraisonClient_id, NewLivraisonsClients livraisonsClients, boolean rest){
        //UPDATE BDD
        if(rest){
            return livraisonsClientsDAO.update(livraisonClient_id, livraisonsClients);
        }else {
            return livraisonsClientsDAORest.update(livraisonClient_id, livraisonsClients);
        }
    }

    public LivraisonsClients getLivraisonsClientsBusiness(int livraisonClient_id, boolean rest) {
        if(rest){
            return livraisonsClientsDAO.read(livraisonClient_id);
        }else {
            return livraisonsClientsDAORest.read(livraisonClient_id);
        }
    }

    public List<LivraisonsClients> getAllLivraisonsClientsBusiness(boolean rest) {
        if(rest){
            return livraisonsClientsDAO.read();
        }else {
            return livraisonsClientsDAORest.read();
        }
    }
}
