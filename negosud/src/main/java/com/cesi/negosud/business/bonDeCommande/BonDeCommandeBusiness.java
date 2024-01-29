package com.cesi.negosud.business.bonDeCommande;

import com.cesi.negosud.controller.bonDeCommande.model.BonDeCommande;
import com.cesi.negosud.controller.bonDeCommande.model.NewBonDeCommande;
import com.cesi.negosud.dao.bonDeCommande.BonDeCommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonDeCommandeBusiness {

    private final BonDeCommandeDAO bonDeCommandeDAO;

    @Autowired
    public BonDeCommandeBusiness(BonDeCommandeDAO bonDeCommandeDAO){this.bonDeCommandeDAO = bonDeCommandeDAO;}

    public BonDeCommande createBonDeCommandeBusiness(NewBonDeCommande bonDeCommande){return bonDeCommandeDAO.create(bonDeCommande);}

    public boolean deleteBonDeCommandeBusiness(int bonDeCommande_id){return bonDeCommandeDAO.delete(bonDeCommande_id);}

    public BonDeCommande updateBonDeCommandeBusiness(int bonDeCommande_id, NewBonDeCommande bonDeCommande){
        return bonDeCommandeDAO.update(bonDeCommande_id, bonDeCommande);
    }

    public BonDeCommande getBonDeCommandeBusiness(int bonDeCommande_id){return bonDeCommandeDAO.read(bonDeCommande_id);}

    public List<BonDeCommande> getAllBonDeCommandeBusiness(){return bonDeCommandeDAO.read();}
}
