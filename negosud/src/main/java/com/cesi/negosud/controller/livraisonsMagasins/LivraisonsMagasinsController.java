package com.cesi.negosud.controller.livraisonsMagasins;

import com.cesi.negosud.business.livraisonsMagasins.LivraisonsMagasinsBusiness;
import com.cesi.negosud.controller.livraisonsMagasins.model.NewLivraisonsMagasins;
import com.cesi.negosud.controller.livraisonsMagasins.model.LivraisonsMagasins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class LivraisonsMagasinsController {
    private final String versionBDD = "/api/v1";
    //private final String versionRest = "/api/v1/rest";

    private final LivraisonsMagasinsBusiness livraisonsMagasinsBusiness;

    @Autowired //Constructeur pour injection
    public LivraisonsMagasinsController(LivraisonsMagasinsBusiness livraisonsMagasinsBusiness) {
        this.livraisonsMagasinsBusiness = livraisonsMagasinsBusiness;
    }

    @PostMapping(versionBDD + "/livraisonsMagasins")
    public LivraisonsMagasins createLivraisonsMagasinsBDD(@RequestBody NewLivraisonsMagasins livraisonsMagasins) {
        return livraisonsMagasinsBusiness.createLivraisonsMagasinsBusiness(livraisonsMagasins, false);
    }

    /*@PostMapping(versionRest + "/livraisonsMagasins")
    public LivraisonsMagasins createLivraisonsMagasinsRest(@RequestBody NewLivraisonsMagasins livraisonsMagasins) {
        return livraisonsMagasinsBusiness.createLivraisonsMagasinsBusiness(livraisonsMagasins, true);
    }*/

    @DeleteMapping(versionBDD + "/livraisonsMagasins/{livraisonMagasin_id}")
    public boolean deleteLivraisonsMagasinsBDD(@PathVariable int livraisonMagasin_id) {
        return livraisonsMagasinsBusiness.deleteLivraisonsMagasinsBusiness(livraisonMagasin_id, false);
    }

    /*@DeleteMapping(versionRest + "/livraisonsMagasins/{livraisonMagasin_id}")
    public boolean deleteLivraisonsMagasinsRest(@PathVariable int livraisonMagasin_id) {
        return livraisonsMagasinsBusiness.deleteLivraisonsMagasinsBusiness(livraisonMagasin_id, true);
    }*/

    @PutMapping(versionBDD + "/livraisonsMagasins/{livraisonMagasin_id}")
    public LivraisonsMagasins updateLivraisonsMagasinsBDD(@PathVariable int livraisonMagasin_id, @RequestBody NewLivraisonsMagasins livraisonsMagasins) {
        return livraisonsMagasinsBusiness.updateLivraisonsMagasinsBusinesss(livraisonMagasin_id, livraisonsMagasins, false);
    }

    /*@PutMapping(versionRest + "/livraisonsMagasins/{livraisonMagasin_id}")
    public LivraisonsMagasins updateLivraisonsMagasinsRest(@PathVariable int livraisonMagasin_id, @RequestBody NewLivraisonsMagasins livraisonsMagasins) {
        return livraisonsMagasinsBusiness.updateLivraisonsMagasinsBusinesss(livraisonMagasin_id, livraisonsMagasins, true);
    }*/

    @GetMapping(versionBDD + "/livraisonsMagasins/{livraisonMagasin_id}")
    public LivraisonsMagasins getLivraisonsMagasinsBDD(@PathVariable int livraisonMagasin_id) {
        return livraisonsMagasinsBusiness.getLivraisonsMagasinsBusiness(livraisonMagasin_id, false);
    }

    /*@GetMapping(versionRest + "/livraisonsMagasins/{livraisonMagasin_id}")
    public LivraisonsMagasins getLivraisonsMagasinsRest(@PathVariable int livraisonMagasin_id) {
        return livraisonsMagasinsBusiness.getLivraisonsMagasinsBusiness(livraisonMagasin_id, true);
    }*/

    @GetMapping(versionBDD + "/livraisonsMagasins")
    public List<LivraisonsMagasins> getAllLivraisonsMagasinsBDD() {
        return livraisonsMagasinsBusiness.getAllLivraisonsMagasinsBusiness(false);
    }

    /*@GetMapping(versionRest + "/livraisonsMagasins")
    public List<LivraisonsMagasins> getAllLivraisonsMagasinsRest() {
        return livraisonsMagasinsBusiness.getAllLivraisonsMagasinsBusiness(true);
    }*/

}
