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
            return famillesDAORest.create(familles);
        }else {
            return famillesDAO.create(familles);
        }
    }

    public boolean deleteFamillesBusiness(int famille_id, boolean rest){
        //DELETE BDD
        if(rest){
            return famillesDAORest.delete(famille_id);
        }else {
            return famillesDAO.delete(famille_id);
        }
    }

    public Familles updateFamillesBusinesss(int famille_id, NewFamilles familles, boolean rest){
        //UPDATE BDD
        if(rest){
            return famillesDAORest.update(famille_id, familles);
        }else {
            return famillesDAO.update(famille_id, familles);
        }
    }

    public Familles getFamillesBusiness(int adresse_id, boolean rest) {
        if(rest){
            return famillesDAORest.read(adresse_id);
        }else {
            return famillesDAO.read(adresse_id);
        }
    }

    public List<Familles> getAllFamillesBusiness(boolean rest) {
        if(rest){
            return famillesDAORest.read();
        }else {
            return famillesDAO.read();
        }
    }
}

