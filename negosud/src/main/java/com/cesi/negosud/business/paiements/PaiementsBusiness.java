package com.cesi.negosud.business.paiements;

import com.cesi.negosud.controller.paiements.model.Paiements;
import com.cesi.negosud.controller.paiements.model.NewPaiements;
import com.cesi.negosud.dao.paiements.PaiementsDAO;
import com.cesi.negosud.dao.paiements.PaiementsDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementsBusiness {
    private final PaiementsDAO PaiementsDAO;
    private final PaiementsDAORest PaiementsDAORest;
    @Autowired
    public PaiementsBusiness(PaiementsDAO PaiementsDAO, PaiementsDAORest PaiementsDAORest) {
        this.PaiementsDAO = PaiementsDAO;
        this.PaiementsDAORest = PaiementsDAORest;
    }

    public Paiements createPaiementsBusiness(NewPaiements Paiements, boolean rest) {
        //INSERT BDD
        if(rest){
            return PaiementsDAO.create(Paiements);
        }else {
            return PaiementsDAORest.create(Paiements);
        }
    }

    public boolean deletePaiementsBusiness(int famille_id, boolean rest){
        //DELETE BDD
        if(rest){
            return PaiementsDAO.delete(famille_id);
        }else {
            return PaiementsDAORest.delete(famille_id);
        }
    }

    public Paiements updatePaiementsBusinesss(int famille_id, NewPaiements Paiements, boolean rest){
        //UPDATE BDD
        if(rest){
            return PaiementsDAO.update(famille_id, Paiements);
        }else {
            return PaiementsDAORest.update(famille_id, Paiements);
        }
    }

    public Paiements getPaiementsBusiness(int adresse_id, boolean rest) {
        if(rest){
            return PaiementsDAO.read(adresse_id);
        }else {
            return PaiementsDAORest.read(adresse_id);
        }
    }

    public List<Paiements> getAllPaiementsBusiness(boolean rest) {
        if(rest){
            return PaiementsDAO.read();
        }else {
            return PaiementsDAORest.read();
        }
    }
}

