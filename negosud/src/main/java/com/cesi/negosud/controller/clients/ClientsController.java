package com.cesi.negosud.controller.clients;

import com.cesi.negosud.business.clients.ClientsBusiness;
import com.cesi.negosud.controller.clients.model.NewClients;
import com.cesi.negosud.controller.clients.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ClientsController {
    private final String versionBDD = "/api/v1/bdd";
    //private final String versionRest = "/api/v1/rest";

    private final ClientsBusiness clientsBusiness;

    @Autowired //Constructeur pour injection
    public ClientsController(ClientsBusiness clientsBusiness) {
        this.clientsBusiness = clientsBusiness;
    }

    @PostMapping(versionBDD + "/clients")
    public Clients createClientsBDD(@RequestBody NewClients clients) {
        return clientsBusiness.createClientsBusiness(clients, false);
    }

    /*@PostMapping(versionRest + "/clients")
    public Clients createClientsRest(@RequestBody NewClients clients) {
        return clientsBusiness.createClientsBusiness(clients, true);
    }*/

    @DeleteMapping(versionBDD + "/clients/{client_id}")
    public boolean deleteClientsBDD(@PathVariable int client_id) {
        return clientsBusiness.deleteClientsBusiness(client_id, false);
    }

    /*@DeleteMapping(versionRest + "/clients/{client_id}")
    public boolean deleteClientsRest(@PathVariable int client_id) {
        return clientsBusiness.deleteClientsBusiness(client_id, true);
    }*/

    @PutMapping(versionBDD + "/clients/{client_id}")
    public Clients updateClientsBDD(@PathVariable int client_id, @RequestBody NewClients clients) {
        return clientsBusiness.updateClientsBusinesss(client_id, clients, false);
    }

    /*@PutMapping(versionRest + "/clients/{client_id}")
    public Clients updateClientsRest(@PathVariable int client_id, @RequestBody NewClients clients) {
        return clientsBusiness.updateClientsBusinesss(client_id, clients, true);
    }*/

    @GetMapping(versionBDD + "/clients/{client_id}")
    public Clients getClientsBDD(@PathVariable int client_id) {
        return clientsBusiness.getClientsBusiness(client_id, false);
    }

    /*@GetMapping(versionRest + "/clients/{client_id}")
    public Clients getClientssRest(@PathVariable int client_id) {
        return clientsBusiness.getClientsBusiness(client_id, true);
    }*/

    @GetMapping(versionBDD + "/clients")
    public List<Clients> getAllClientsBDD() {
        return clientsBusiness.getAllClientsBusiness(false);
    }

    /*@GetMapping(versionRest + "/clients")
    public List<Clients> getAllClientsRest() {
        return clientsBusiness.getAllClientsBusiness(true);
    }*/

}
