package com.cesi.negosud.business.factures;

import com.cesi.negosud.controller.factures.model.Factures;
import com.cesi.negosud.controller.factures.model.NewFactures;
import com.cesi.negosud.dao.factures.FacturesDAO;
import com.cesi.negosud.dao.factures.FacturesDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturesBusiness {
    private final FacturesDAO facturesDAO;
    private final FacturesDAORest facturesDAORest;
    @Autowired
    public FacturesBusiness(FacturesDAO facturesDAO, FacturesDAORest facturesDAORest) {
        this.facturesDAO = facturesDAO;
        this.facturesDAORest = facturesDAORest;
    }

    public Factures createFacturesBusiness(NewFactures factures, boolean rest) {
        //INSERT BDD
        if(rest){
            return facturesDAO.create(factures);
        }else {
            return facturesDAORest.create(factures);
        }
    }

    public boolean deleteFacturesBusiness(int facture_id, boolean rest){
        //DELETE BDD
        if(rest){
            return facturesDAO.delete(facture_id);
        }else {
            return facturesDAORest.delete(facture_id);
        }
    }

    public Factures updateFacturesBusinesss(int facture_id, NewFactures factures, boolean rest){
        //UPDATE BDD
        if(rest){
            return facturesDAO.update(facture_id, factures);
        }else {
            return facturesDAORest.update(facture_id, factures);
        }
    }

    public Factures getFacturesBusiness(int adresse_id, boolean rest) {
        if(rest){
            return facturesDAO.read(adresse_id);
        }else {
            return facturesDAORest.read(adresse_id);
        }
    }

    public List<Factures> getAllFacturesBusiness(boolean rest) {
        if(rest){
            return facturesDAO.read();
        }else {
            return facturesDAORest.read();
        }
    }
}

