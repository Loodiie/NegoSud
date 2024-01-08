package com.cesi.negosud.controller.fournisseurs;

import com.cesi.negosud.business.fournisseurs.FournisseursBusiness;
import com.cesi.negosud.controller.fournisseurs.model.Fournisseurs;
import com.cesi.negosud.controller.fournisseurs.model.NewFournisseurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class FournisseursController {
    private final String versionBDD = "/api/v1";
    //private final String versionRest = "/api/v1/rest";

    private final FournisseursBusiness fournisseursBusiness;

    @Autowired
    public FournisseursController(FournisseursBusiness fournisseursBusiness){
        this.fournisseursBusiness = fournisseursBusiness;
    }

    @PostMapping(versionBDD + "/inventaires")
    public Fournisseurs createFournisseursBDD(@RequestBody NewFournisseurs fournisseurs){
        return fournisseursBusiness.createFournisseursBusiness(fournisseurs, false);
    }
    /*@PostMapping(versionRest + "/inventaires")
    public Fournisseurs createFournisseursRest(@RequestBody NewFournisseurs fournisseurs){
        return fournisseursBusiness.createFournisseursBusiness(fournisseurs, true);
    }*/

    @DeleteMapping(versionBDD + "/inventaires/{inventaires_id}")
    public boolean deleteFournisseursBDD(@PathVariable int fournisseur_id){
        return fournisseursBusiness.deleteFournisseursBusiness(fournisseur_id, false);
    }

    /*@DeleteMapping(versionRest + "/inventaires/{inventaires_id}")
    public boolean deleteFournisseursRest(@PathVariable int fournisseur_id){
        return fournisseursBusiness.deleteFournisseursBusiness(fournisseur_id, true);
    }*/

    @PutMapping(versionBDD + "/inventaires/{inventaires_id}")
    public Fournisseurs updateFournisseursBDD(@PathVariable int fournisseur_id, @RequestBody NewFournisseurs fournisseurs){
        return fournisseursBusiness.updateFournisseursBusiness(fournisseur_id, fournisseurs, false);
    }

    /*@PutMapping(versionRest + "/inventaires/{inventaires_id}")
    public Fournisseurs updateFournisseursRest(@PathVariable int fournisseur_id, @RequestBody NewFournisseurs fournisseurs){
        return fournisseursBusiness.updateFournisseursBusiness(fournisseur_id, fournisseurs, true);
    }*/

    @GetMapping(versionBDD + "/inventaires/{inventaires_id}")
    public Fournisseurs getFournisseursBDD(@PathVariable int fournisseur_id){
        return fournisseursBusiness.getFournisseursBusiness(fournisseur_id, false);
    }

    /*@GetMapping(versionRest + "/inventaires/{inventaires_id}")
    public Fournisseurs getFournisseursRest(@PathVariable int fournisseur_id){
        return fournisseursBusiness.getFournisseursBusiness(fournisseur_id, true);
    }*/

    @GetMapping(versionBDD + "/inventaires")
    public List<Fournisseurs> getAllInventairesBDD(){
        return fournisseursBusiness.getAllFournisseursBusiness(false);
    }

    /*@GetMapping(versionRest + "/inventaires")
    public List<Fournisseurs> getAllFournisseursRest(){
        return fournisseursBusiness.getAllFournisseursBusiness(true);
    }*/

}
