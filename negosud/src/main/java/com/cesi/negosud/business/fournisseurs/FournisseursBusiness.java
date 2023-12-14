package com.cesi.negosud.business.fournisseurs;

import com.cesi.negosud.controller.fournisseurs.model.Fournisseurs;
import com.cesi.negosud.controller.fournisseurs.model.NewFournisseurs;
import com.cesi.negosud.dao.fournisseurs.FournisseursDAO;
import com.cesi.negosud.dao.fournisseurs.FournisseursDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseursBusiness {
    private final FournisseursDAO fournisseursDAO;
    private final FournisseursDAORest fournisseursDAORest;

    @Autowired
    public FournisseursBusiness(FournisseursDAO fournisseursDAO, FournisseursDAORest fournisseursDAORest){
        this.fournisseursDAO = fournisseursDAO;
        this.fournisseursDAORest = fournisseursDAORest;
    }

    public Fournisseurs createFournisseursBusiness(NewFournisseurs fournisseurs, boolean rest){
        if(rest){
            return fournisseursDAO.create(fournisseurs);
        } else {
            return fournisseursDAORest.create(fournisseurs);
        }
    }

    public boolean deleteFournisseursBusiness(int fournisseurs_id, boolean rest){
        if(rest){
            return fournisseursDAO.delete(fournisseurs_id);
        } else {
            return fournisseursDAORest.delete(fournisseurs_id);
        }
    }

    public Fournisseurs updateFournisseursBusiness(int fournisseurs_id, NewFournisseurs fournisseurs, boolean rest){
        if(rest){
            return fournisseursDAO.update(fournisseurs_id, fournisseurs);
        } else {
            return fournisseursDAORest.update(fournisseurs_id, fournisseurs);
        }
    }

    public Fournisseurs getFournisseursBusiness(int fournisseurs_id, boolean rest){
        if(rest){
            return fournisseursDAO.read(fournisseurs_id);
        } else {
            return fournisseursDAORest.read(fournisseurs_id);
        }
    }

    public List<Fournisseurs> getAllFournisseursBusiness(boolean rest){
        if(rest){
            return fournisseursDAO.read();
        } else {
            return fournisseursDAORest.read();
        }
    }
}
