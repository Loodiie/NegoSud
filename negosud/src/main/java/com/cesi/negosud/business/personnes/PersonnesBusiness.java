package com.cesi.negosud.business.personnes;

import com.cesi.negosud.controller.personnes.model.Personnes;
import com.cesi.negosud.controller.personnes.model.NewPersonnes;
import com.cesi.negosud.dao.personnes.PersonnesDAO;
import com.cesi.negosud.dao.personnes.PersonnesDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnesBusiness {

    private final PersonnesDAO personnesDAO;
    private final PersonnesDAORest personnesDAORest;

    @Autowired
    public PersonnesBusiness(PersonnesDAO personnesDAO, PersonnesDAORest personnesDAORest){
        this.personnesDAO = personnesDAO;
        this.personnesDAORest = personnesDAORest;
    }

    public Personnes createPersonnesBusiness(NewPersonnes personnes, boolean rest){
        //INSERT BDD
        if(rest){
            return personnesDAORest.create(personnes);
        }else {
            return personnesDAO.create(personnes);
        }
    }

    public boolean deletePersonnesBusiness(int personne_id, boolean rest){
        //DELETE BDD
        if(rest){
            return personnesDAORest.delete(personne_id);
        }else {
            return personnesDAO.delete(personne_id);
        }
    }

    public Personnes updatePersonnesBusinesss(int personne_id, NewPersonnes personnes, boolean rest){
        //UPDATE BDD
        if(rest){
            return personnesDAORest.update(personne_id, personnes);
        }else {
            return personnesDAO.update(personne_id, personnes);
        }
    }

    public Personnes getPersonnesBusiness(int personne_id, boolean rest) {
        if(rest){
            return personnesDAORest.read(personne_id);
        }else {
            return personnesDAO.read(personne_id);
        }
    }

    public List<Personnes> getAllPersonnesBusiness(boolean rest) {
        if(rest){
            return personnesDAORest.read();
        }else {
            return personnesDAO.read();
        }
    }
    public String connectService(String userEmail, String password) {
        String authJSON = personnesDAO.connect(userEmail, password);
        return authJSON;
    }


}
