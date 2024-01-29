package com.cesi.negosud.controller.bonDeCommande;

import com.cesi.negosud.business.bonDeCommande.BonDeCommandeBusiness;
import com.cesi.negosud.controller.bonDeCommande.model.BonDeCommande;
import com.cesi.negosud.controller.bonDeCommande.model.NewBonDeCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class BonDeCommandeController {

    private final String versionBDD ="/api/v1";
    private final BonDeCommandeBusiness bonDeCommandeBusiness;

    @Autowired
    private  BonDeCommandeController (BonDeCommandeBusiness bonDeCommandeBusiness){this.bonDeCommandeBusiness = bonDeCommandeBusiness;}

    @PostMapping(versionBDD + "/bonDeCommande")
    public BonDeCommande createTypeVinBDD(@RequestBody NewBonDeCommande bonDeCommande){
        return bonDeCommandeBusiness.createBonDeCommandeBusiness(bonDeCommande);
    }

    @DeleteMapping(versionBDD + "/bonDeCommande/{bonDeCommande_id}")
    public boolean deleteTypeVinBDD(@PathVariable int bonDeCommande_id){
        return bonDeCommandeBusiness.deleteBonDeCommandeBusiness(bonDeCommande_id);
    }

    @PutMapping(versionBDD + "/bonDeCommande/{bonDeCommande_id}")
    public BonDeCommande updateTypeVinBDD(@PathVariable int bonDeCommande_id, @RequestBody NewBonDeCommande bonDeCommande){
        return bonDeCommandeBusiness.updateBonDeCommandeBusiness(bonDeCommande_id, bonDeCommande);
    }

    @GetMapping(versionBDD + "/bonDeCommande/{bonDeCommande_id}")
    public BonDeCommande getTypeVinBDD(@PathVariable int bonDeCommande_id){return bonDeCommandeBusiness.getBonDeCommandeBusiness(bonDeCommande_id);}

    @GetMapping(versionBDD + "/bonDeCommande")
    public List<BonDeCommande> getAllTypeVinBDD(){return bonDeCommandeBusiness.getAllBonDeCommandeBusiness();}
}
