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
            return PaiementsDAORest.create(Paiements);
        }else {
            return PaiementsDAO.create(Paiements);
        }
    }

    public boolean deletePaiementsBusiness(int paiement_id, boolean rest){
        //DELETE BDD
        if(rest){
            return PaiementsDAORest.delete(paiement_id);
        }else {
            return PaiementsDAO.delete(paiement_id);
        }
    }

    public Paiements updatePaiementsBusinesss(int paiement_id, NewPaiements Paiements, boolean rest){
        //UPDATE BDD
        if(rest){
            return PaiementsDAORest.update(paiement_id, Paiements);
        }else {
            return PaiementsDAO.update(paiement_id, Paiements);
        }
    }

    public Paiements getPaiementsBusiness(int paiement_id, boolean rest) {
        if(rest){
            return PaiementsDAORest.read(paiement_id);
        }else {
            return PaiementsDAO.read(paiement_id);
        }
    }

    public List<Paiements> getAllPaiementsBusiness(boolean rest) {
        if(rest){
            return PaiementsDAORest.read();
        }else {
            return PaiementsDAO.read();
        }
    }
}

