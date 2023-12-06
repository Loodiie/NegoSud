package com.cesi.negosud.controller.inventaires;

import com.cesi.negosud.business.adresses.AdressesBusiness;
import com.cesi.negosud.controller.adresses.model.Adresses;
import com.cesi.negosud.controller.adresses.model.NewAdresses;
import com.cesi.negosud.controller.inventaires.model.NewInventaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class InventairesController {

    private final String versionBDD = "/api/v1/bdd";
    private final String versionRest = "/api/v1/rest";

    private final InventairesBusiness inventairesBusiness;

    @Autowired //Constructeur pour injection
    public InventairesController(InventaireBusiness inventaireBusiness) {
        this.inventaireBusiness = inventaireBusiness;
    }

    @PostMapping(versionBDD + "/inventaire")
    public Inventaire createInventaireBDD(@RequestBody NewInventaires inventaires) {
        return inventaireBusiness.createInventaireBusiness(inventaires, false);
    }

    @PostMapping(versionRest + "/inventaire")
    public Inventaire createInventairesRest(@RequestBody NewInventaires inventaires) {
        return inventaireBusiness.createInventairesBusiness(inventaires, true);
    }

    @DeleteMapping(versionBDD + "/inventaire/{inventaire_id}")
    public boolean deleteInventairesBDD(@PathVariable int inventaires_id) {
        return inventaireBusiness.deleteInventairesBusiness(inventaires_id, false);
    }

    @DeleteMapping(versionRest + "/inventaire/{inventaire_id}")
    public boolean deleteInventairesRest(@PathVariable int inventaires_id) {
        return inventaireBusiness.deleteInventairesBusiness(inventaires_id, true);
    }

    @PutMapping(versionBDD + "/inventaire/{inventaire_id}")
    public Inventaire updateInventairesBDD(@PathVariable int inventaires_id, @RequestBody NewInventaires inventaires) {
        return inventaireBusiness.updateInventairesBusinesss(inventaires_id, inventaires, false);
    }

    @PutMapping(versionRest + "/inventaire/{inventaire_id}")
    public Inventaire updateInventairesRest(@PathVariable int inventaires_id, @RequestBody NewInventaires inventaires) {
        return inventaireBusiness.updateInventairesBusinesss(inventaires_id, inventaires, true);
    }

    @GetMapping(versionBDD + "/inventaire/{inventaire_id}")
    public Inventaire getInventairesBDD(@PathVariable int inventaires_id) {
        return inventaireBusiness.getInventairesBusiness(inventaires_id, false);
    }

    @GetMapping(versionRest + "/inventaire/{inventaire_id}")
    public Inventaire getInventairesRest(@PathVariable int inventaires_id) {
        return inventaireBusiness.getInventairesBusiness(inventaires_id, true);
    }

    @GetMapping(versionBDD + "/inventaire")
    public List<Inventaire> getAllInventairesBDD() {
        return inventaireBusiness.getAllInventairesBusiness(false);
    }

    @GetMapping(versionRest + "/inventaire")
    public List<Inventaire> getAllInventairesRest() {
        return inventaireBusiness.getAllInventairesBusiness(true);
    }
}
