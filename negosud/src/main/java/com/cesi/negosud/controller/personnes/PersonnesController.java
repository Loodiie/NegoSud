package com.cesi.negosud.controller.personnes;

import com.cesi.negosud.business.personnes.PersonnesBusiness;
import com.cesi.negosud.controller.personnes.model.NewPersonnes;
import com.cesi.negosud.controller.personnes.model.Personnes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin("http://localhost:9000/")
public class PersonnesController {
    private final String versionBDD = "/api/v1";
    //private final String versionRest = "/api/v1/rest";

    private final PersonnesBusiness personnesBusiness;

    @Autowired //Constructeur pour injection
    public PersonnesController(PersonnesBusiness personnesBusiness) {
        this.personnesBusiness = personnesBusiness;
    }

    @PostMapping(versionBDD + "/personnes")
    public Personnes createPersonnesBDD(@RequestBody NewPersonnes personnes) {
        return personnesBusiness.createPersonnesBusiness(personnes, false);
    }

    /*@PostMapping(versionRest + "/personnes")
    public Personnes createPersonnesRest(@RequestBody NewPersonnes personnes) {
        return personnesBusiness.createPersonnesBusiness(personnes, true);
    }*/

    @DeleteMapping(versionBDD + "/personnes/{personne_id}")
    public boolean deletePersonnesBDD(@PathVariable int personne_id) {
        return personnesBusiness.deletePersonnesBusiness(personne_id, false);
    }

    /*@DeleteMapping(versionRest + "/personnes/{personne_id}")
    public boolean deletePersonnesRest(@PathVariable int personne_id) {
        return personnesBusiness.deletePersonnesBusiness(personne_id, true);
    }*/

    @PutMapping(versionBDD + "/personnes/{personne_id}")
    public Personnes updatePersonnesBDD(@PathVariable int personne_id, @RequestBody NewPersonnes personnes) {
        return personnesBusiness.updatePersonnesBusinesss(personne_id, personnes, false);
    }

    /*@PutMapping(versionRest + "/personnes/{personne_id}")
    public Personnes updatePersonnesRest(@PathVariable int personne_id, @RequestBody NewPersonnes personnes) {
        return personnesBusiness.updatePersonnesBusinesss(personne_id, personnes, true);
    }*/

    @GetMapping(versionBDD + "/personnes/{personne_id}")
    public Personnes getPersonnesBDD(@PathVariable int personne_id) {
        return personnesBusiness.getPersonnesBusiness(personne_id, false);
    }

    /*@GetMapping(versionRest + "/personnes/{personne_id}")
    public Personnes getPersonnessRest(@PathVariable int personne_id) {
        return personnesBusiness.getPersonnesBusiness(personne_id, true);
    }*/

    @GetMapping(versionBDD + "/personnes")
    public List<Personnes> getAllPersonnesBDD() {
        return personnesBusiness.getAllPersonnesBusiness(false);
    }

    /*@GetMapping(versionRest + "/personnes")
    public List<Personnes> getAllPersonnesRest() {
        return personnesBusiness.getAllPersonnesBusiness(true);
    }*/

}
