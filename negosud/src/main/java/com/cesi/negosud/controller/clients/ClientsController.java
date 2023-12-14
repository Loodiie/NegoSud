package com.cesi.negosud.controller.clients;

import com.cesi.negosud.business.clients.ClientsBusiness;
import com.cesi.negosud.controller.clients.model.NewClients;
import com.cesi.negosud.controller.clients.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public class ClientsController {
    private final String versionBDD = "/api/v1/bdd";
    private final String versionRest = "/api/v1/rest";

    private final ClientsBusiness clientsBusiness;

    @Autowired //Constructeur pour injection
    public ClientsController(ClientsBusiness clientsBusiness) {
        this.clientsBusiness = clientsBusiness;
    }

    @PostMapping(versionBDD + "/clients")
    public Clients createClientsBDD(@RequestBody NewClients clients) {
        return clientsBusiness.createCleintsBusiness(clients, false);
    }

    @PostMapping(versionRest + "/clients")
    public Clients createClientsRest(@RequestBody NewClients clients) {
        return clientsBusiness.createCleintsBusiness(clients, true);
    }

    @DeleteMapping(versionBDD + "/clients/{client_id}")
    public boolean deleteClientsBDD(@PathVariable int clients_id) {
        return clientsBusiness.deleteClientsBusiness(clients_id, false);
    }

    @DeleteMapping(versionRest + "/clients/{client_id}")
    public boolean deleteClientsRest(@PathVariable int clients_id) {
        return clientsBusiness.deleteClientsBusiness(clients_id, true);
    }

    @PutMapping(versionBDD + "/clients/{client_id}")
    public Clients updateAdressesBDD(@PathVariable int clients_id, @RequestBody NewClients clients) {
        return clientsBusiness.updateClientsBusinesss(clients_id, clients, false);
    }

    @PutMapping(versionRest + "/clients/{client_id}")
    public Clients updateAdressesRest(@PathVariable int clients_id, @RequestBody NewClients clients) {
        return clientsBusiness.updateClientsBusinesss(clients_id, clients, true);
    }

    @GetMapping(versionBDD + "/clients/{client_id}")
    public Clients getAdressesBDD(@PathVariable int clients_id) {
        return clientsBusiness.getClientsBusiness(clients_id, false);
    }

    @GetMapping(versionRest + "/clients/{client_id}")
    public Clients getAdressesRest(@PathVariable int clients_id) {
        return clientsBusiness.getClientsBusiness(clients_id, true);
    }

    @GetMapping(versionBDD + "/clients")
    public List<Clients> getAllAdressesBDD() {
        return clientsBusiness.getAllClientsBusiness(false);
    }

    @GetMapping(versionRest + "/clients")
    public List<Clients> getAllAdressesRest() {
        return clientsBusiness.getAllClientsBusiness(true);
    }

}
