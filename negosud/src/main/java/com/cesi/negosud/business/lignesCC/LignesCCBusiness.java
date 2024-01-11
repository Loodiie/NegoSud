package com.cesi.negosud.business.lignesCC;

import com.cesi.negosud.controller.lignesCC.model.LignesCC;
import com.cesi.negosud.controller.lignesCC.model.NewLignesCC;
import com.cesi.negosud.dao.lignesCC.LignesCCDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LignesCCBusiness {

    private final LignesCCDAO lignesCCDAO;

    @Autowired
    public LignesCCBusiness(LignesCCDAO lignesCCDAO){
        this.lignesCCDAO = lignesCCDAO;
    }

    public LignesCC createLignesCCBusiness(NewLignesCC lignesCC){
        return lignesCCDAO.create(lignesCC);
    }

    public boolean deleteLignesCCBusiness(int ligneComClient_id){
        return lignesCCDAO.delete(ligneComClient_id);
    }

    public  LignesCC updateLignesCCBusiness(int ligneComClient_id, NewLignesCC lignesCC){
        return lignesCCDAO.update(ligneComClient_id, lignesCC);
    }

    public LignesCC getLignesCCBusiness(int ligneComClient_id){
        return lignesCCDAO.read(ligneComClient_id);
    }

    public List<LignesCC> getAllLignesCCBusiness(){
        return lignesCCDAO.read();
    }

}
