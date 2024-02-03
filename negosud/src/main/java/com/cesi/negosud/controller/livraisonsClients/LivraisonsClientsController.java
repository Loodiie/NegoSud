package com.cesi.negosud.controller.livraisonsClients;

import com.cesi.negosud.business.livraisonsClients.LivraisonsClientsBusiness;
import com.cesi.negosud.controller.livraisonsClients.model.NewLivraisonsClients;
import com.cesi.negosud.controller.livraisonsClients.model.LivraisonsClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("http://localhost:9000/")
public class LivraisonsClientsController {
    private final String versionBDD = "/api/v1";
    //private final String versionRest = "/api/v1/rest";

    private final LivraisonsClientsBusiness livraisonsClientsBusiness;

    @Autowired //Constructeur pour injection
    public LivraisonsClientsController(LivraisonsClientsBusiness livraisonsClientsBusiness) {
        this.livraisonsClientsBusiness = livraisonsClientsBusiness;
    }

    @PostMapping(versionBDD + "/livraisonsClients")
    public LivraisonsClients createLivraisonsClientsBDD(@RequestBody NewLivraisonsClients livraisonsClients) {
        return livraisonsClientsBusiness.createLivraisonsClientsBusiness(livraisonsClients, false);
    }

    /*@PostMapping(versionRest + "/livraisonsClients")
    public LivraisonsClients createLivraisonsClientsRest(@RequestBody NewLivraisonsClients livraisonsClients) {
        return livraisonsClientsBusiness.createLivraisonsClientsBusiness(livraisonsClients, true);
    }*/

    @DeleteMapping(versionBDD + "/livraisonsClients/{livraisonClient_id}")
    public boolean deleteLivraisonsClientsBDD(@PathVariable int livraisonClient_id) {
        return livraisonsClientsBusiness.deleteLivraisonsClientsBusiness(livraisonClient_id, false);
    }

    /*@DeleteMapping(versionRest + "/livraisonsClients/{livraisonClient_id}")
    public boolean deleteLivraisonsClientsRest(@PathVariable int livraisonClient_id) {
        return livraisonsClientsBusiness.deleteLivraisonsClientsBusiness(livraisonClient_id, true);
    }*/

    @PutMapping(versionBDD + "/livraisonsClients/{livraisonClient_id}")
    public LivraisonsClients updateLivraisonsClientsBDD(@PathVariable int livraisonClient_id, @RequestBody NewLivraisonsClients livraisonsClients) {
        return livraisonsClientsBusiness.updateLivraisonsClientsBusinesss(livraisonClient_id, livraisonsClients, false);
    }

    /*@PutMapping(versionRest + "/livraisonsClients/{livraisonClient_id}")
    public LivraisonsClients updateLivraisonsClientsRest(@PathVariable int livraisonClient_id, @RequestBody NewLivraisonsClients livraisonsClients) {
        return livraisonsClientsBusiness.updateLivraisonsClientsBusinesss(livraisonClient_id, livraisonsClients, true);
    }*/

    @GetMapping(versionBDD + "/livraisonsClients/{livraisonClient_id}")
    public LivraisonsClients getLivraisonsClientsBDD(@PathVariable int livraisonClient_id) {
        return livraisonsClientsBusiness.getLivraisonsClientsBusiness(livraisonClient_id, false);
    }

    /*@GetMapping(versionRest + "/livraisonsClients/{livraisonClient_id}")
    public LivraisonsClients getLivraisonsClientsRest(@PathVariable int livraisonClient_id) {
        return livraisonsClientsBusiness.getLivraisonsClientsBusiness(livraisonClient_id, true);
    }*/

    @GetMapping(versionBDD + "/livraisonsClients")
    public List<LivraisonsClients> getAllLivraisonsClientsBDD() {
        return livraisonsClientsBusiness.getAllLivraisonsClientsBusiness(false);
    }

    /*@GetMapping(versionRest + "/livraisonsClients")
    public List<LivraisonsClients> getAllLivraisonsClientsRest() {
        return livraisonsClientsBusiness.getAllLivraisonsClientsBusiness(true);
    }*/

}
