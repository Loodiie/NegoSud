package com.cesi.negosud.business.lignesCM;

import com.cesi.negosud.controller.lignesCM.model.LignesCM;
import com.cesi.negosud.controller.lignesCM.model.NewLignesCM;
import com.cesi.negosud.dao.lignesCM.LignesCMDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LignesCMBusiness {

    private final LignesCMDAO lignesCMDAO;

    @Autowired
    public  LignesCMBusiness(LignesCMDAO lignesCMDAO){
        this.lignesCMDAO = lignesCMDAO;
    }

    public LignesCM createLignesCMBusiness(NewLignesCM lignesCM){
        return lignesCMDAO.create(lignesCM);}

    public boolean deleteLignesCMBusiness(int ligneComMag_id){
        return lignesCMDAO.delete(ligneComMag_id);
    }

    public LignesCM updateLignesCMBusiness(int ligneComMag_id, NewLignesCM lignesCM){
        return lignesCMDAO.update(ligneComMag_id, lignesCM);
    }

    public LignesCM getLignesCMBusiness(int ligneComMag_id){
        return lignesCMDAO.read(ligneComMag_id);
    }

    public List<LignesCM> getAllLignesBusiness(){
        return lignesCMDAO.read();
    }

}
