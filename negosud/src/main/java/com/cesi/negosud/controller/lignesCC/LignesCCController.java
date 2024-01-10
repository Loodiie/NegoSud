package com.cesi.negosud.controller.lignesCC;

import com.cesi.negosud.business.lignesCC.LignesCCBusiness;
import com.cesi.negosud.controller.lignesCC.model.LignesCC;
import com.cesi.negosud.controller.lignesCC.model.NewLignesCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class LignesCCController {

    private final String versionBDD = "/api/v1";


    private final LignesCCBusiness lignesCCBusiness;
    @Autowired
    public LignesCCController(LignesCCBusiness lignesCCBusiness){
        this.lignesCCBusiness = lignesCCBusiness;
    }

    @PostMapping(versionBDD + "/lignesCommandesClients")
    public LignesCC createLignesCCBDD(@RequestBody NewLignesCC lignesCC){
        return lignesCCBusiness.createLignesCCBusiness(lignesCC);
    }

    @DeleteMapping(versionBDD + "/lignesCommandesClients/{article_id_and_commandeClient_id}")
    public boolean deleteLignesCCBDD(@PathVariable int article_id, int commandeClient_id){
        return lignesCCBusiness.deleteLignesCCBusiness(article_id, commandeClient_id);
    }

    @PutMapping(versionBDD + "/lignesCommandesClients/{article_id_and_commandeClient_id}")
    public LignesCC updateLignesCCBDD(@PathVariable int article_id, int commandeClient_id, @RequestBody NewLignesCC lignesCC){
        return lignesCCBusiness.updateLignesCCBusiness(article_id, commandeClient_id, lignesCC);
    }

    @GetMapping(versionBDD + "/lignesCommandesClients/{article_id_and_commandeClient_id}")
    public LignesCC getLignesCCBDD(@PathVariable int article_id, int commandeClient_id){
        return lignesCCBusiness.getLignesCCBusiness(article_id, commandeClient_id);
    }

    @GetMapping(versionBDD + "/lignesCommandesClients")
    public List<LignesCC> getAllLignesCCBDD(){return lignesCCBusiness.getAllLignesCCBusiness();}

}
