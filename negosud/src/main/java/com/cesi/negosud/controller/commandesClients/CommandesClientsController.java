package com.cesi.negosud.controller.commandesClients;

import com.cesi.negosud.business.commandesClients.CommandesClientsBusiness;
import com.cesi.negosud.controller.commandesClients.model.NewCommandesClients;
import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class CommandesClientsController {
    private final String versionBDD = "/api/v1";
    private final String versionRest = "/api/v1/rest";

    private final CommandesClientsBusiness commandesClientsBusiness;

    @Autowired //Constructeur pour injection
    public CommandesClientsController(CommandesClientsBusiness commandesClientsBusiness) {
        this.commandesClientsBusiness = commandesClientsBusiness;
    }

    @PostMapping(versionBDD + "/commandesClients")
    public CommandesClients createCommandesClientsBDD(@RequestBody NewCommandesClients commandesClients) {
        return commandesClientsBusiness.createCommandesClientsBusiness(commandesClients, false);
    }

    /*@PostMapping(versionRest + "/commandesClients")
    public CommandesClients createCommandesClientsRest(@RequestBody NewCommandesClients commandesClients) {
        return commandesClientsBusiness.createCommandesClientsBusiness(commandesClients, true);
    }*/

    @DeleteMapping(versionBDD + "/commandesClients/{commandeClient_id}")
    public boolean deleteCommandesClientsBDD(@PathVariable int commandeClient_id) {
        return commandesClientsBusiness.deleteCommandesClientsBusiness(commandeClient_id, false);
    }

    /*@DeleteMapping(versionRest + "/commandesClients/{commandeClient_id}")
    public boolean deleteCommandesClientsRest(@PathVariable int commandeClient_id) {
        return commandesClientsBusiness.deleteCommandesClientsBusiness(commandeClient_id, true);
    }*/

    @PutMapping(versionBDD + "/commandesClients/{commandeclient_id}")
    public CommandesClients updateCommandesClientsBDD(@PathVariable int commandeclient_id, @RequestBody NewCommandesClients commandesClients) {
        return commandesClientsBusiness.updateCommandesClientsBusinesss(commandeclient_id, commandesClients, false);
    }

    /*@PutMapping(versionRest + "/commandesClients/{commandeclient_id}")
    public CommandesClients updateCommandesClientsRest(@PathVariable int commandeclient_id, @RequestBody NewCommandesClients commandesClients) {
        return commandesClientsBusiness.updateCommandesClientsBusinesss(commandeclient_id, commandesClients, true);
    }*/

    @GetMapping(versionBDD + "/commandesClients/{commandeclient_id}")
    public CommandesClients getCommandesClientsBDD(@PathVariable int commandeclient_id) {
        return commandesClientsBusiness.getCommandesClientsBusiness(commandeclient_id, false);
    }

    /*@GetMapping(versionRest + "/commandesClients/{commandeclient_id}")
    public CommandesClients getCommandesClientsRest(@PathVariable int commandeclient_id) {
        return commandesClientsBusiness.getCommandesClientsBusiness(commandeclient_id, true);
    }*/

    @GetMapping(versionBDD + "/commandesClients")
    public List<CommandesClients> getAllCommandesClientsBDD() {
        return commandesClientsBusiness.getAllCommandesClientsBusiness(false);
    }

    /*@GetMapping(versionRest + "/commandesClients")
    public List<CommandesClients> getAllCommandesClientsRest() {
        return commandesClientsBusiness.getAllCommandesClientsBusiness(true);
    }*/

}
