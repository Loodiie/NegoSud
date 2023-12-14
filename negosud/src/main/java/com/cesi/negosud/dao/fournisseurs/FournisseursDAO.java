package com.cesi.negosud.dao.fournisseurs;

import com.cesi.negosud.controller.clients.model.Clients;
import com.cesi.negosud.controller.fournisseurs.model.Fournisseurs;
import com.cesi.negosud.controller.fournisseurs.model.NewFournisseurs;
import com.cesi.negosud.dao.fournisseurs.model.FournisseursDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FournisseursDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "fournisseur_id";
    private static final String NOM_FIELD = "nom";
    private static final String TELEPHONE_FIELD = "telephone";
    private static final String MAIL_FIELD = "mail";
    private static final String ADRESSEID_FIELD = "adresse_id";

    @Autowired
    public FournisseursDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<FournisseursDTO> rowMapper = (rs, rowNum) -> {
        final FournisseursDTO fournisseurs = new FournisseursDTO();
        fournisseurs.setFournisseurs_id(rs.getInt(ID_FIELD));
        fournisseurs.setNom(rs.getString(NOM_FIELD));
        fournisseurs.setTelephone(rs.getString(TELEPHONE_FIELD));
        fournisseurs.setMail(rs.getString(MAIL_FIELD));
        fournisseurs.setAdresse_id(rs.getInt(ADRESSEID_FIELD));
        return fournisseurs;
    };

    public Fournisseurs create(NewFournisseurs fournisseurs) {
        //INSERT DANS BDD
        Fournisseurs fournisseurs1 = null;
        final String query = "INSERT INTO fournisseurs(nom, telephone, mail, adresse_id) VALUES(?,?,?,?)";
        int result = this.jdbcTemplate.update(query, fournisseurs.getNom(), fournisseurs.getTelephone(), fournisseurs.getMail(), fournisseurs.getAdresse_id());
        if (result == 1) {
            //faire un select avant
            fournisseurs1 = new Fournisseurs();
            fournisseurs1.setNom(fournisseurs.getNom());
            fournisseurs1.setTelephone(fournisseurs.getTelephone());
            fournisseurs1.setMail(fournisseurs.getMail());
            fournisseurs1.setAdresse_id(fournisseurs.getAdresse_id());
        }
        return fournisseurs1;
    }

    public boolean delete(int fournisseurs_id) {
        final String query = ("DELETE from fournisseurs where id=?");
        int result = this.jdbcTemplate.update(query, fournisseurs_id);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Fournisseurs update(int fournisseurs_id, NewFournisseurs fournisseurs) {
        Fournisseurs fournisseurs1 = null;
        final String query = "UPADATE fournisseurs set nom=?, telephone=?, mail=?, adresse_id=? where id=?";
        int result = this.jdbcTemplate.update(query, fournisseurs.getNom(), fournisseurs.getTelephone(), fournisseurs.getMail(), fournisseurs.getAdresse_id());
        if (result == 1) {
            fournisseurs1 = new Fournisseurs();
            fournisseurs1.setFournisseurs_id(fournisseurs_id);
            fournisseurs1.setNom(fournisseurs.getNom());
            fournisseurs1.setTelephone(fournisseurs.getTelephone());
            fournisseurs1.setMail(fournisseurs.getMail());
            fournisseurs1.setAdresse_id(fournisseurs.getAdresse_id());
        }
        return fournisseurs1;
    }

    public Fournisseurs read(int fournisseurs_id) {
        // READ ONE PERSON DANS BDD
        List<FournisseursDTO> dtos = this.jdbcTemplate.query("select * from fournisseurs where fournisseurs_id ="+fournisseurs_id, this.rowMapper);
        Fournisseurs fournisseurs = null;
        if(dtos != null && dtos.size() == 1){
            fournisseurs = new Fournisseurs();
            fournisseurs.setAdresse_id(dtos.get(0).getAdresse_id());
            fournisseurs.setNom(dtos.get(0).getNom());
            fournisseurs.setTelephone(dtos.get(0).getTelephone());
            fournisseurs.setMail(dtos.get(0).getMail());
            fournisseurs.setAdresse_id(dtos.get(0).getAdresse_id());
        }
        return fournisseurs;
    }

    public List<Fournisseurs> read() {
        // READ ALL PERSON DANS BDD
        List<Fournisseurs> listFournisseurs = null;
        List<FournisseursDTO> dtos = this.jdbcTemplate.query("select * from fournisseurs", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listFournisseurs = new ArrayList<Fournisseurs>();
            for (FournisseursDTO dto : dtos) {
                Fournisseurs resp = new Fournisseurs();
                resp.setFournisseurs_id(dto.getFournisseurs_id());
                resp.setNom(dto.getNom());
                resp.setTelephone(dto.getTelephone());
                resp.setMail(dto.getMail());
                resp.setAdresse_id(dto.getAdresse_id());
                listFournisseurs.add(resp);
            }
        }
        return listFournisseurs;
    }
}
