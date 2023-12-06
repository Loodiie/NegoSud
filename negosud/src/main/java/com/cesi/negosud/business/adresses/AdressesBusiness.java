package com.cesi.negosud.business.adresses;

import com.cesi.negosud.controller.adresses.model.Adresses;
import com.cesi.negosud.controller.adresses.model.NewAdresses;
import com.cesi.negosud.dao.adresses.AdressesDAO;
import com.cesi.negosud.dao.adresses.AdressesDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdressesBusiness {
    private final AdressesDAO adressesDAO;
    private final AdressesDAORest adressesDAORest;
    @Autowired
    public AdressesBusiness(AdressesDAO adressesDAO, AdressesDAORest adressesDAORest) {
        this.adressesDAO = adressesDAO;
        this.adressesDAORest = adressesDAORest;
    }

    public Adresses createAdressesBusiness(NewAdresses Adresses, boolean rest) {
        //INSERT BDD
        if(rest){
            return adressesDAO.create(Adresses);
        }else {
            return adressesDAORest.create(Adresses);
        }
    }

    public boolean deleteAdressesBusiness(int adresse_id, boolean rest){
        //DELETE BDD
        if(rest){
            return adressesDAO.delete(adresse_id);
        }else {
            return adressesDAORest.delete(adresse_id);
        }
    }

    public Adresses updateAdressesBusinesss(int adresse_id, NewAdresses Adresses, boolean rest){
        //UPDATE BDD
        if(rest){
            return adressesDAO.update(adresse_id, Adresses);
        }else {
            return adressesDAORest.update(adresse_id, Adresses);
        }
    }

    public Adresses getAdressesBusiness(int adresse_id, boolean rest) {
        if(rest){
            return adressesDAO.read(adresse_id);
        }else {
            return adressesDAORest.read(adresse_id);
        }
    }

    public List<Adresses> getAllAdressesBusiness(boolean rest) {
        if(rest){
            return adressesDAO.read();
        }else {
            return adressesDAORest.read();
        }
    }
}
