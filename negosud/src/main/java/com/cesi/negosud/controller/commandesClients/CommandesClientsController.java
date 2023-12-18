package com.cesi.negosud.controller.commandesClients;

import com.cesi.negosud.business.commandesClients.CommandesClientsBusiness;
import com.cesi.negosud.controller.commandesClients.model.NewCommandesClients;
import com.cesi.negosud.controller.commandesClients.model.CommandesClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public class CommandesClientsController {
    private final String versionBDD = "/api/v1/bdd";
    private final String versionRest = "/api/v1/rest";

    private final CommandesClientsBusiness commandesclientsBusiness;

    @Autowired //Constructeur pour injection
    public CommandesClientsController(CommandesClientsBusiness commandesclientsBusiness) {
        this.commandesclientsBusiness = commandesclientsBusiness;
    }

    @PostMapping(versionBDD + "/commandesclients")
    public CommandesClients createCommandesClientsBDD(@RequestBody NewCommandesClients commandesclients) {
        return commandesclientsBusiness.createCommandesCleintsBusiness(commandesclients, false);
    }

    @PostMapping(versionRest + "/commandesclients")
    public CommandesClients createCommandesClientsRest(@RequestBody NewCommandesClients commandesclients) {
        return commandesclientsBusiness.createCommandesCleintsBusiness(commandesclients, true);
    }

    @DeleteMapping(versionBDD + "/commandesclients/{commandeclient_id}")
    public boolean deleteCommandesClientsBDD(@PathVariable int commandeclient_id) {
        return commandesclientsBusiness.deleteCommandesClientsBusiness(commandeclient_id, false);
    }

    @DeleteMapping(versionRest + "/commandesclients/{commandeclient_id}")
    public boolean deleteCommandesClientsRest(@PathVariable int commandeclient_id) {
        return commandesclientsBusiness.deleteCommandesClientsBusiness(commandeclient_id, true);
    }

    @PutMapping(versionBDD + "/commandesclients/{commandeclient_id}")
    public CommandesClients updateCommandesClientsBDD(@PathVariable int clicommandeclient_ident_id, @RequestBody NewCommandesClients commandesclients) {
        return commandesclientsBusiness.updateCommandesClientsBusinesss(commandeclient_id, commandesclients, false);
    }

    @PutMapping(versionRest + "/commandesclients/{commandeclient_id}")
    public CommandesClients updateCommandesClientsRest(@PathVariable int commandeclient_id, @RequestBody NewCommandesClients commandesclients) {
        return commandesclientsBusiness.updateCommandesClientsBusinesss(commandeclient_id, commandesclients, true);
    }

    @GetMapping(versionBDD + "/commandesclients/{commandeclient_id}")
    public CommandesClients getCommandesClientsBDD(@PathVariable int commandeclient_id) {
        return commandesclientsBusiness.getCommandesClientsBusiness(commandeclient_id, false);
    }

    @GetMapping(versionRest + "/commandesclients/{commandeclient_id}")
    public CommandesClients getCommandesClientsRest(@PathVariable int commandeclient_id) {
        return commandesclientsBusiness.getCommandesClientsBusiness(commandeclient_id, true);
    }

    @GetMapping(versionBDD + "/commandesclients")
    public List<CommandesClients> getAllCommandesClientsBDD() {
        return commandesclientsBusiness.getAllCommandesClientsBusiness(false);
    }

    @GetMapping(versionRest + "/commandesclients")
    public List<CommandesClients> getAllCommandesClientsRest() {
        return commandesclientsBusiness.getAllCommandesClientsBusiness(true);
    }

}
