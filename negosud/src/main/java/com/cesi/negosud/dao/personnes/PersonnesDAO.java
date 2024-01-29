package com.cesi.negosud.dao.personnes;

import com.cesi.negosud.controller.personnes.model.Personnes;
import com.cesi.negosud.controller.personnes.model.NewPersonnes;
import com.cesi.negosud.dao.personnes.model.PersonnesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnesDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "personne_id";
    private static final String NOM_FIELD = "nom";
    private static final String PRENOM_FIELD = "prenom";
    private static final String TELEPHONE_FIELD = "telephone";
    private static final String MAIL_FIELD = "mail";
    private static final String MDP_FIELD = "mdp";
    private static final String EMPLOYEES_FIELD = "employees";
    private static final String ADRESSEID_FIELD = "fk_adresse";

    @Autowired
    public PersonnesDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final RowMapper<PersonnesDTO> rowMapper = (rs, rowNum) -> {
        final PersonnesDTO personnes = new PersonnesDTO();
        personnes.setPersonne_id(rs.getInt(ID_FIELD));
        personnes.setNom(rs.getString(NOM_FIELD));
        personnes.setPrenom(rs.getString(PRENOM_FIELD));
        personnes.setTelephone(rs.getString(TELEPHONE_FIELD));
        personnes.setMail(rs.getString(MAIL_FIELD));
        personnes.setMdp(rs.getString(MDP_FIELD));
        personnes.setEmployees(rs.getBoolean(EMPLOYEES_FIELD));
        personnes.setAdresse_id(rs.getInt(ADRESSEID_FIELD));
        return personnes;
    };

    public Personnes create(NewPersonnes personnes) {
        //INSERT DANS BDD
        Personnes personnes1= null;
        final String query = "INSERT INTO personnes(nom, prenom, telephone, mail, mdp, employees, fk_adresse) VALUES(?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, personnes.getNom(), personnes.getPrenom(), personnes.getTelephone(),
                personnes.getMail(), personnes.getMdp(), personnes.isEmployees(), personnes.getAdresse_id());
        if(result ==1){
            List<Personnes> listPersonnes = read();
            personnes1= new Personnes();
            personnes1.setPersonne_id(listPersonnes.get(listPersonnes.size() -1).getPersonne_id ());
            personnes1.setNom(personnes.getNom());
            personnes1.setPrenom(personnes.getPrenom());
            personnes1.setTelephone(personnes.getTelephone());
            personnes1.setMail(personnes.getMail());
            personnes1.setMdp(personnes.getMdp());
            personnes1.setAdresse_id(personnes.getAdresse_id());
        }
        return personnes1;
    }

    public boolean delete(int personne_id){
        //DELETE DANS BDD
        final String query = ("DELETE from personnes where personne_id=?");
        int result = this.jdbcTemplate.update(query, personne_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Personnes update(int personne_id, NewPersonnes personnes){
        //UPDATE DANS BDD
        Personnes personnes1= null;
        final String query = "UPDATE personnes set nom=?, prenom=?, telephone=?, mail=?, mdp=?, employees=?, fk_adresse=? where personne_id=?";
        int result = this.jdbcTemplate.update(query, personnes.getNom(), personnes.getPrenom(), personnes.getTelephone(),
                personnes.getMail(), personnes.getMdp(), personnes.isEmployees(), personnes.getAdresse_id(), personne_id);
        if(result == 1){
            personnes1= new Personnes();
            personnes1.setPersonne_id(personne_id);
            personnes1.setNom(personnes.getNom());
            personnes1.setPrenom(personnes.getPrenom());
            personnes1.setTelephone(personnes.getTelephone());
            personnes1.setMail(personnes.getMail());
            personnes1.setMdp(personnes.getMdp());
            personnes1.setEmployees(personnes.isEmployees());
            personnes1.setAdresse_id(personnes.getAdresse_id());
        }
        return personnes1;
    }

    public Personnes read(int personne_id) {
        // READ ONE PERSON DANS BDD
        List<PersonnesDTO> dtos = this.jdbcTemplate.query("select * from personnes where personne_id ="+personne_id, this.rowMapper);
        Personnes personnes = null;
        if(dtos != null && dtos.size() == 1){
            personnes = new Personnes();
            personnes.setPersonne_id(dtos.get(0).getPersonne_id());
            personnes.setNom(dtos.get(0).getNom());
            personnes.setPrenom(dtos.get(0).getPrenom());
            personnes.setTelephone(dtos.get(0).getTelephone());
            personnes.setMail(dtos.get(0).getMail());
            personnes.setMdp(dtos.get(0).getMdp());
            personnes.setEmployees(dtos.get(0).isEmployees());
            personnes.setAdresse_id(dtos.get(0).getAdresse_id());
        }
        return personnes;
    }

    public List<Personnes> read() {
        // READ ALL PERSON DANS BDD
        List<Personnes> listPersonnes = null;
        List<PersonnesDTO> dtos = this.jdbcTemplate.query("select * from personnes", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listPersonnes = new ArrayList<Personnes> ();
            for (PersonnesDTO dto : dtos) {
                Personnes resp = new Personnes();
                resp.setPersonne_id(dto.getPersonne_id());
                resp.setNom(dto.getNom());
                resp.setPrenom(dto.getPrenom());
                resp.setTelephone(dto.getTelephone());
                resp.setMail(dto.getMail());
                resp.setMdp(dto.getMdp());
                resp.setEmployees(dto.isEmployees());
                resp.setAdresse_id(dto.getAdresse_id());
                listPersonnes.add(resp);
            }
        }
        return listPersonnes;
    }

}
