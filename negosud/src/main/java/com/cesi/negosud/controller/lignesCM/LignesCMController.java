package com.cesi.negosud.controller.lignesCM;

import com.cesi.negosud.business.lignesCM.LignesCMBusiness;
import com.cesi.negosud.controller.lignesCM.model.LignesCM;
import com.cesi.negosud.controller.lignesCM.model.NewLignesCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class LignesCMController {

    private final String versionBDD = "/api/v1";

    private final LignesCMBusiness lignesCMBusiness;

    @Autowired
    public LignesCMController(LignesCMBusiness lignesCMBusiness){this.lignesCMBusiness = lignesCMBusiness;}

    @PostMapping(versionBDD + "/lignesCommandeMagasin")
    public LignesCM createLignesCMBDD(@RequestBody NewLignesCM lignesCM){
        return lignesCMBusiness.createLignesCMBusiness(lignesCM);
    }

    @DeleteMapping(versionBDD + "/lignesCommandeMagasin/{ligneComMag_id}")
    public boolean deleteLignesCMBDD(@PathVariable int ligneComMag_id){
        return lignesCMBusiness.deleteLignesCMBusiness(ligneComMag_id);
    }

    @PutMapping(versionBDD + "/lignesCommandeMagasin/{ligneComMag_id}")
    public LignesCM updateLignesCMBDD(@PathVariable int ligneComMag_id, @RequestBody NewLignesCM lignesCM){
        return lignesCMBusiness.updateLignesCMBusiness(ligneComMag_id, lignesCM);
    }

    @GetMapping(versionBDD + "/lignesCommandesMagasin/{ligneComMag_id}")
    public LignesCM getLignesCMBDD(@PathVariable int article_id){
        return lignesCMBusiness.getLignesCMBusiness(article_id);
    }

    @GetMapping(versionBDD + "/lignesCommandesMagasin")
    public List<LignesCM> getAllLignesCMBDD(){return lignesCMBusiness.getAllLignesBusiness();}
}
