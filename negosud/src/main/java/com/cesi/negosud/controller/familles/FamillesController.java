package com.cesi.negosud.controller.familles;

import com.cesi.negosud.business.familles.FamillesBusiness;
import com.cesi.negosud.controller.familles.model.Familles;
import com.cesi.negosud.controller.familles.model.NewFamilles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("http://localhost:5173/")
public class FamillesController {

    private final String versionBDD = "/api/v1";
    private final String versionRest = "/api/v1/rest";

    private final FamillesBusiness famillesBusiness;

    @Autowired //Constructeur pour injection
    public FamillesController(FamillesBusiness famillesBusiness) {
        this.famillesBusiness = famillesBusiness;
    }

    @PostMapping(versionBDD + "/familles")
    public Familles createFamillesBDD(@RequestBody NewFamilles familles) {
        return famillesBusiness.createFamillesBusiness(familles, false);
    }

    /*@PostMapping(versionRest + "/familles")
    public Familles createFamillesRest(@RequestBody NewFamilles familles) {
        return famillesBusiness.createFamillesBusiness(familles, true);
    }*/

    @DeleteMapping(versionBDD + "/familles/{famille_id}")
    public boolean deleteFamillesBDD(@PathVariable int famille_id) {
        return famillesBusiness.deleteFamillesBusiness(famille_id, false);
    }

    /*@DeleteMapping(versionRest + "/familles/{famille_id}")
    public boolean deleteFamillesRest(@PathVariable int famille_id) {
        return famillesBusiness.deleteFamillesBusiness(famille_id, true);
    }*/

    @PutMapping(versionBDD + "/familles/{famille_id}")
    public Familles updateFamillesBDD(@PathVariable int famille_id, @RequestBody NewFamilles familles) {
        return famillesBusiness.updateFamillesBusinesss(famille_id, familles, false);
    }

    /*@PutMapping(versionRest + "/familles/{famille_id}")
    public Familles updateFamillesRest(@PathVariable int famille_id, @RequestBody NewFamilles familles) {
        return famillesBusiness.updateFamillesBusinesss(famille_id, familles, true);
    }*/

    @GetMapping(versionBDD + "/familles/{famille_id}")
    public Familles getFamillesBDD(@PathVariable int famille_id) {
        return famillesBusiness.getFamillesBusiness(famille_id, false);
    }

    /*@GetMapping(versionRest + "/familles/{famille_id}")
    public Familles getFamillesRest(@PathVariable int famille_id) {
        return famillesBusiness.getFamillesBusiness(famille_id, true);
    }*/

    @GetMapping(versionBDD + "/familles")
    public List<Familles> getAllFamillesBDD() {
        return famillesBusiness.getAllFamillesBusiness(false);
    }

    /*@GetMapping(versionRest + "/familles")
    public List<Familles> getAllFamillesRest() {
        return famillesBusiness.getAllFamillesBusiness(true);
    }*/
}
