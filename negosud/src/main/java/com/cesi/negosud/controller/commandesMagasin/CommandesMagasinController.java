package com.cesi.negosud.controller.commandesMagasin;

import com.cesi.negosud.business.commandesMagasin.CommandesMagasinBusiness;
import com.cesi.negosud.controller.commandesMagasin.model.NewCommandesMagasin;
import com.cesi.negosud.controller.commandesMagasin.model.CommandesMagasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("http://localhost:9000/")
public class CommandesMagasinController {
    private final String versionBDD = "/api/v1";
    private final String versionRest = "/api/v1/rest";

    private final CommandesMagasinBusiness commandesMagasinBusiness;

    @Autowired //Constructeur pour injection
    public CommandesMagasinController(CommandesMagasinBusiness commandesMagasinBusiness) {
        this.commandesMagasinBusiness = commandesMagasinBusiness;
    }

    @PostMapping(versionBDD + "/commandesMagasin")
    public CommandesMagasin createCommandesMagasinBDD(@RequestBody NewCommandesMagasin commandesMagasin) {
        return commandesMagasinBusiness.createCommandesMagasinBusiness(commandesMagasin, false);
    }

    /*@PostMapping(versionRest + "/commandesMagasin")
    public CommandesMagasin createCommandesMagasinRest(@RequestBody NewCommandesMagasin commandesMagasin) {
        return commandesMagasinBusiness.createCommandesMagasinBusiness(commandesMagasin, true);
    }*/

    @DeleteMapping(versionBDD + "/commandesMagasin/{commandeMag_id}")
    public boolean deleteCommandesMagasinBDD(@PathVariable int commandeMag_id) {
        return commandesMagasinBusiness.deleteCommandesMagasinBusiness(commandeMag_id, false);
    }

    /*@DeleteMapping(versionRest + "/commandesMagasin/{commandeMag_id}")
    public boolean deleteCommandesMagasinRest(@PathVariable int commandeMag_id) {
        return commandesMagasinBusiness.deleteCommandesMagasinBusiness(commandeMag_id, true);
    }*/

    @PutMapping(versionBDD + "/commandesMagasin/{commandeMag_id}")
    public CommandesMagasin updateCommandesMagasinBDD(@PathVariable int commandeMag_id, @RequestBody NewCommandesMagasin commandesMagasin) {
        return commandesMagasinBusiness.updateCommandesMagasinBusinesss(commandeMag_id, commandesMagasin, false);
    }

    /*@PutMapping(versionRest + "/commandesMagasin/{commandeMag_id}")
    public CommandesMagasin updateCommandesMagasinRest(@PathVariable int commandeMag_id, @RequestBody NewCommandesMagasin commandesMagasin) {
        return commandesMagasinBusiness.updateCommandesMagasinBusinesss(commandeMag_id, commandesMagasin, true);
    }*/

    @GetMapping(versionBDD + "/commandesMagasin/{commandeMag_id}")
    public CommandesMagasin getCommandesMagasinBDD(@PathVariable int commandeMag_id) {
        return commandesMagasinBusiness.getCommandesMagasinBusiness(commandeMag_id, false);
    }

    /*@GetMapping(versionRest + "/commandesMagasin/{commandeMag_id}")
    public CommandesMagasin getCommandesMagasinRest(@PathVariable int commandeMag_id) {
        return commandesMagasinBusiness.getCommandesMagasinBusiness(commandeMag_id, true);
    }*/

    @GetMapping(versionBDD + "/commandesMagasin")
    public List<CommandesMagasin> getAllCommandesMagasinBDD() {
        return commandesMagasinBusiness.getAllCommandesMagasinBusiness(false);
    }

    /*@GetMapping(versionRest + "/commandesMagasin")
    public List<CommandesMagasin> getAllCommandesMagasinRest() {
        return commandesMagasinBusiness.getAllCommandesMagasinBusiness(true);
    }*/

}
