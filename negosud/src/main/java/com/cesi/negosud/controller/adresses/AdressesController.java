package com.cesi.negosud.controller.adresses;

import com.cesi.negosud.business.adresses.AdressesBusiness;
import com.cesi.negosud.controller.adresses.model.Adresses;
import com.cesi.negosud.controller.adresses.model.NewAdresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("http://localhost:5173/")
public class AdressesController {

    private final String versionBDD = "/api/v1";
    private final String versionRest = "/api/v1/rest";

    private final AdressesBusiness adressesBusiness;

    @Autowired //Constructeur pour injection
    public AdressesController(AdressesBusiness adressesBusiness) {
        this.adressesBusiness = adressesBusiness;
    }

    @PostMapping(versionBDD + "/adresses")
    public Adresses createAdressesBDD(@RequestBody NewAdresses adresses) {
        return adressesBusiness.createAdressesBusiness(adresses, false);
    }

    /*@PostMapping(versionRest + "/adresses")
    public Adresses createAdressesRest(@RequestBody NewAdresses adresses) {
        return adressesBusiness.createAdressesBusiness(adresses, true);
    }*/

    @DeleteMapping(versionBDD + "/adresses/{adresse_id}")
    public boolean deleteAdressesBDD(@PathVariable int adresse_id) {
        return adressesBusiness.deleteAdressesBusiness(adresse_id, false);
    }

   /* @DeleteMapping(versionRest + "/adresses/{adresse_id}")
    public boolean deleteAdressesRest(@PathVariable int adresse_id) {
        return adressesBusiness.deleteAdressesBusiness(adresse_id, true);
    }*/

    @PutMapping(versionBDD + "/adresses/{adresse_id}")
    public Adresses updateAdressesBDD(@PathVariable int adresse_id, @RequestBody NewAdresses adresses) {
        return adressesBusiness.updateAdressesBusinesss(adresse_id, adresses, false);
    }

    /*@PutMapping(versionRest + "/adresses/{adresse_id}")
    public Adresses updateAdressesRest(@PathVariable int adresse_id, @RequestBody NewAdresses adresses) {
        return adressesBusiness.updateAdressesBusinesss(adresse_id, adresses, true);
    }*/

    @GetMapping(versionBDD + "/adresses/{adresse_id}")
    public Adresses getAdressesBDD(@PathVariable int adresse_id) {
        return adressesBusiness.getAdressesBusiness(adresse_id, false);
    }

    /*@GetMapping(versionRest + "/adresses/{adresse_id}")
    public Adresses getAdressesRest(@PathVariable int adresse_id) {
        return adressesBusiness.getAdressesBusiness(adresse_id, true);
    }*/

    @GetMapping(versionBDD + "/adresses")
    public List<Adresses> getAllAdressesBDD() {
        return adressesBusiness.getAllAdressesBusiness(false);
    }

    /*@GetMapping(versionRest + "/adresses")
    public List<Adresses> getAllAdressesRest() {
        return adressesBusiness.getAllAdressesBusiness(true);
    }*/
}



