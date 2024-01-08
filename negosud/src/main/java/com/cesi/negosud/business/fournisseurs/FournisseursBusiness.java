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
            return fournisseursDAORest.create(fournisseurs);
        } else {
            return fournisseursDAO.create(fournisseurs);
        }
    }

    public boolean deleteFournisseursBusiness(int fournisseur_id, boolean rest){
        if(rest){
            return fournisseursDAORest.delete(fournisseur_id);
        } else {
            return fournisseursDAO.delete(fournisseur_id);
        }
    }

    public Fournisseurs updateFournisseursBusiness(int fournisseur_id, NewFournisseurs fournisseurs, boolean rest){
        if(rest){
            return fournisseursDAORest.update(fournisseur_id, fournisseurs);
        } else {
            return fournisseursDAO.update(fournisseur_id, fournisseurs);
        }
    }

    public Fournisseurs getFournisseursBusiness(int fournisseur_id, boolean rest){
        if(rest){
            return fournisseursDAORest.read(fournisseur_id);
        } else {
            return fournisseursDAO.read(fournisseur_id);
        }
    }

    public List<Fournisseurs> getAllFournisseursBusiness(boolean rest){
        if(rest){
            return fournisseursDAORest.read();
        } else {
            return fournisseursDAO.read();
        }
    }
}
