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

    public boolean deleteLignesCCBusiness(int article_id, int commandeClient_id){
        return lignesCCDAO.delete(article_id, commandeClient_id);
    }

    public  LignesCC updateLignesCCBusiness(int article_id, int commanceClient_id, NewLignesCC lignesCC){
        return lignesCCDAO.update(article_id, commanceClient_id, lignesCC);
    }

    public LignesCC getLignesCCBusiness(int article_id, int commandeCLient_id){
        return lignesCCDAO.read(article_id, commandeCLient_id);
    }

    public List<LignesCC> getAllLignesCCBusiness(){
        return lignesCCDAO.read();
    }

}
