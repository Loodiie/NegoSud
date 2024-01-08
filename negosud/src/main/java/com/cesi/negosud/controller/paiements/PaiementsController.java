package com.cesi.negosud.controller.paiements;

import com.cesi.negosud.business.paiements.PaiementsBusiness;
import com.cesi.negosud.controller.paiements.model.Paiements;
import com.cesi.negosud.controller.paiements.model.NewPaiements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class PaiementsController {

    private final String versionBDD = "/api/v1/bdd";
    //private final String versionRest = "/api/v1/rest";

    private final PaiementsBusiness PaiementsBusiness;

    @Autowired //Constructeur pour injection
    public PaiementsController(PaiementsBusiness PaiementsBusiness) {
        this.PaiementsBusiness = PaiementsBusiness;
    }

    @PostMapping(versionBDD + "/Paiements")
    public Paiements createPaiementsBDD(@RequestBody NewPaiements paiements) {
        return PaiementsBusiness.createPaiementsBusiness(paiements, false);
    }

    /*@PostMapping(versionRest + "/Paiements")
    public Paiements createPaiementsRest(@RequestBody NewPaiements paiements) {
        return PaiementsBusiness.createPaiementsBusiness(paiements, true);
    }*/

    @DeleteMapping(versionBDD + "/Paiements/{famille_id}")
    public boolean deletePaiementsBDD(@PathVariable int famille_id) {
        return PaiementsBusiness.deletePaiementsBusiness(famille_id, false);
    }

    /*@DeleteMapping(versionRest + "/Paiements/{famille_id}")
    public boolean deletePaiementsRest(@PathVariable int famille_id) {
        return PaiementsBusiness.deletePaiementsBusiness(famille_id, true);
    }*/

    @PutMapping(versionBDD + "/Paiements/{famille_id}")
    public Paiements updatePaiementsBDD(@PathVariable int famille_id, @RequestBody NewPaiements Paiements) {
        return PaiementsBusiness.updatePaiementsBusinesss(famille_id, Paiements, false);
    }

    /*@PutMapping(versionRest + "/Paiements/{famille_id}")
    public Paiements updatePaiementsRest(@PathVariable int famille_id, @RequestBody NewPaiements Paiements) {
        return PaiementsBusiness.updatePaiementsBusinesss(famille_id, Paiements, true);
    }*/

    @GetMapping(versionBDD + "/Paiements/{famille_id}")
    public Paiements getPaiementsBDD(@PathVariable int famille_id) {
        return PaiementsBusiness.getPaiementsBusiness(famille_id, false);
    }

    /*@GetMapping(versionRest + "/Paiements/{famille_id}")
    public Paiements getPaiementsRest(@PathVariable int famille_id) {
        return PaiementsBusiness.getPaiementsBusiness(famille_id, true);
    }*/

    @GetMapping(versionBDD + "/Paiements")
    public List<Paiements> getAllPaiementsBDD() {
        return PaiementsBusiness.getAllPaiementsBusiness(false);
    }

    /*@GetMapping(versionRest + "/Paiements")
    public List<Paiements> getAllPaiementsRest() {
        return PaiementsBusiness.getAllPaiementsBusiness(true);
    }*/
}
