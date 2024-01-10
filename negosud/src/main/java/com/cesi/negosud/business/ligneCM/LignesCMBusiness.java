package com.cesi.negosud.business.ligneCM;

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

    public boolean deleteLignesCMBusiness(int article_id, int commandeMag_id){
        return lignesCMDAO.delete(article_id, commandeMag_id);
    }

    public LignesCM updateLignesCMBusiness(int article_id, int commandeMag_id, NewLignesCM lignesCM){
        return lignesCMDAO.update(article_id, commandeMag_id, lignesCM);
    }

    public LignesCM getLignesCMBusiness(int article_id, int commandeMag_id){
        return lignesCMDAO.read(article_id, commandeMag_id);
    }

    public List<LignesCM> getAllLignesBusiness(){
        return lignesCMDAO.read();
    }

}
