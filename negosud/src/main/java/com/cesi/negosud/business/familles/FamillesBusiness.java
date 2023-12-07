package com.cesi.negosud.business.familles;

import com.cesi.negosud.controller.familles.model.Familles;
import com.cesi.negosud.controller.familles.model.NewFamilles;
import com.cesi.negosud.dao.familles.FamillesDAO;
import com.cesi.negosud.dao.familles.FamillesDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamillesBusiness {
    private final FamillesDAO famillesDAO;
    private final FamillesDAORest famillesDAORest;
    @Autowired
    public FamillesBusiness(FamillesDAO famillesDAO, FamillesDAORest famillesDAORest) {
        this.famillesDAO = famillesDAO;
        this.famillesDAORest = famillesDAORest;
    }

    public Familles createFamillesBusiness(NewFamilles familles, boolean rest) {
        //INSERT BDD
        if(rest){
            return famillesDAO.create(familles);
        }else {
            return famillesDAORest.create(familles);
        }
    }

    public boolean deleteFamillesBusiness(int familles_id, boolean rest){
        //DELETE BDD
        if(rest){
            return famillesDAO.delete(familles_id);
        }else {
            return famillesDAORest.delete(familles_id);
        }
    }

    public Familles updateFamillesBusinesss(int familles_id, NewFamilles familles, boolean rest){
        //UPDATE BDD
        if(rest){
            return famillesDAO.update(familles_id, familles);
        }else {
            return famillesDAORest.update(familles_id, familles);
        }
    }

    public Familles getFamillesBusiness(int adresse_id, boolean rest) {
        if(rest){
            return famillesDAO.read(adresse_id);
        }else {
            return famillesDAORest.read(adresse_id);
        }
    }

    public List<Familles> getAllFamillesBusiness(boolean rest) {
        if(rest){
            return famillesDAO.read();
        }else {
            return famillesDAORest.read();
        }
    }
}

