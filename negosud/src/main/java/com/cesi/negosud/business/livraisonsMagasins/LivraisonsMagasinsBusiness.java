package com.cesi.negosud.business.livraisonsMagasins;

import com.cesi.negosud.controller.livraisonsMagasins.model.LivraisonsMagasins;
import com.cesi.negosud.controller.livraisonsMagasins.model.NewLivraisonsMagasins;
import com.cesi.negosud.dao.livraisonsMagasins.LivraisonsMagasinsDAO;
import com.cesi.negosud.dao.livraisonsMagasins.LivraisonsMagasinsDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LivraisonsMagasinsBusiness {
    private final LivraisonsMagasinsDAO livraisonsMagasinsDAO;
    private final LivraisonsMagasinsDAORest livraisonsMagasinsDAORest;
    @Autowired
    public LivraisonsMagasinsBusiness(LivraisonsMagasinsDAO livraisonsMagasinsDAO, LivraisonsMagasinsDAORest livraisonsMagasinsDAORest) {
        this.livraisonsMagasinsDAO = livraisonsMagasinsDAO;
        this.livraisonsMagasinsDAORest = livraisonsMagasinsDAORest;
    }

    public LivraisonsMagasins createLivraisonsMagasinsBusiness(NewLivraisonsMagasins livraisonsMagasins, boolean rest) {
        //INSERT BDD
        if(rest){
            return livraisonsMagasinsDAO.create(livraisonsMagasins);
        }else {
            return livraisonsMagasinsDAORest.create(livraisonsMagasins);
        }
    }

    public boolean deleteLivraisonsMagasinsBusiness(int livraisonMagasin_id, boolean rest){
        //DELETE BDD
        if(rest){
            return livraisonsMagasinsDAO.delete(livraisonMagasin_id);
        }else {
            return livraisonsMagasinsDAORest.delete(livraisonMagasin_id);
        }
    }

    public LivraisonsMagasins updateLivraisonsMagasinsBusinesss(int livraisonMagasin_id, NewLivraisonsMagasins livraisonsMagasins, boolean rest){
        //UPDATE BDD
        if(rest){
            return livraisonsMagasinsDAO.update(livraisonMagasin_id, livraisonsMagasins);
        }else {
            return livraisonsMagasinsDAORest.update(livraisonMagasin_id, livraisonsMagasins);
        }
    }

    public LivraisonsMagasins getLivraisonsMagasinsBusiness(int livraisonMagasin_id, boolean rest) {
        if(rest){
            return livraisonsMagasinsDAO.read(livraisonMagasin_id);
        }else {
            return livraisonsMagasinsDAORest.read(livraisonMagasin_id);
        }
    }

    public List<LivraisonsMagasins> getAllLivraisonsMagasinsBusiness(boolean rest) {
        if(rest){
            return livraisonsMagasinsDAO.read();
        }else {
            return livraisonsMagasinsDAORest.read();
        }
    }
}
