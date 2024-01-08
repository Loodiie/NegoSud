package com.cesi.negosud.controller.facture;

import com.cesi.negosud.business.factures.FacturesBusiness;
import com.cesi.negosud.controller.factures.model.Factures;
import com.cesi.negosud.controller.factures.model.NewFactures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class FacturesController {

    private final String versionBDD = "/api/v1/bdd";
    private final String versionRest = "/api/v1/rest";

    private final FacturesBusiness facturesBusiness;

    @Autowired //Constructeur pour injection
    public FacturesController(FacturesBusiness facturesBusiness) {
        this.facturesBusiness = facturesBusiness;
    }

    @PostMapping(versionBDD + "/factures")
    public Factures createFacturesBDD(@RequestBody NewFactures factures) {
        return facturesBusiness.createFacturesBusiness(factures, false);
    }

    /*@PostMapping(versionRest + "/factures")
    public Factures createFacturesRest(@RequestBody NewFactures factures) {
        return facturesBusiness.createFacturesBusiness(factures, true);
    }*/

    @DeleteMapping(versionBDD + "/factures/{facture_id}")
    public boolean deleteFacturesBDD(@PathVariable int facture_id) {
        return facturesBusiness.deleteFacturesBusiness(facture_id, false);
    }

    /*@DeleteMapping(versionRest + "/factures/{facture_id}")
    public boolean deleteFacturesRest(@PathVariable int facture_id) {
        return facturesBusiness.deleteFacturesBusiness(facture_id, true);
    }*/

    @PutMapping(versionBDD + "/factures/{facture_id}")
    public Factures updateFacturesBDD(@PathVariable int facture_id, @RequestBody NewFactures factures) {
        return facturesBusiness.updateFacturesBusinesss(facture_id, factures, false);
    }

    /*@PutMapping(versionRest + "/factures/{facture_id}")
    public Factures updateFacturesRest(@PathVariable int facture_id, @RequestBody NewFactures factures) {
        return facturesBusiness.updateFacturesBusinesss(facture_id, factures, true);
    }*/

    @GetMapping(versionBDD + "/factures/{facture_id}")
    public Factures getFacturesBDD(@PathVariable int facture_id) {
        return facturesBusiness.getFacturesBusiness(facture_id, false);
    }

    /*@GetMapping(versionRest + "/factures/{facture_id}")
    public Factures getFacturesRest(@PathVariable int facture_id) {
        return facturesBusiness.getFacturesBusiness(facture_id, true);
    }*/

    @GetMapping(versionBDD + "/factures")
    public List<Factures> getAllFacturesBDD() {
        return facturesBusiness.getAllFacturesBusiness(false);
    }

    /*@GetMapping(versionRest + "/factures")
    public List<Factures> getAllFacturesRest() {
        return facturesBusiness.getAllFacturesBusiness(true);
    }*/
}
