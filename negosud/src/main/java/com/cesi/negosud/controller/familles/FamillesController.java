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
public class FamillesController {

    private final String versionBDD = "/api/v1/bdd";
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

    @PostMapping(versionRest + "/familles")
    public Familles createFamillesRest(@RequestBody NewFamilles familles) {
        return famillesBusiness.createFamillesBusiness(familles, true);
    }

    @DeleteMapping(versionBDD + "/familles/{familles_id}")
    public boolean deleteFamillesBDD(@PathVariable int familles_id) {
        return famillesBusiness.deleteFamillesBusiness(familles_id, false);
    }

    @DeleteMapping(versionRest + "/familles/{familles_id}")
    public boolean deleteFamillesRest(@PathVariable int familles_id) {
        return famillesBusiness.deleteFamillesBusiness(familles_id, true);
    }

    @PutMapping(versionBDD + "/familles/{familles_id}")
    public Familles updateFamillesBDD(@PathVariable int familles_id, @RequestBody NewFamilles familles) {
        return famillesBusiness.updateFamillesBusinesss(familles_id, familles, false);
    }

    @PutMapping(versionRest + "/familles/{familles_id}")
    public Familles updateFamillesRest(@PathVariable int familles_id, @RequestBody NewFamilles familles) {
        return famillesBusiness.updateFamillesBusinesss(familles_id, familles, true);
    }

    @GetMapping(versionBDD + "/familles/{familles_id}")
    public Familles getFamillesBDD(@PathVariable int familles_id) {
        return famillesBusiness.getFamillesBusiness(familles_id, false);
    }

    @GetMapping(versionRest + "/familles/{familles_id}")
    public Familles getFamillesRest(@PathVariable int familles_id) {
        return famillesBusiness.getFamillesBusiness(familles_id, true);
    }

    @GetMapping(versionBDD + "/familles")
    public List<Familles> getAllFamillesBDD() {
        return famillesBusiness.getAllFamillesBusiness(false);
    }

    @GetMapping(versionRest + "/familles")
    public List<Familles> getAllFamillesRest() {
        return famillesBusiness.getAllFamillesBusiness(true);
    }
}
