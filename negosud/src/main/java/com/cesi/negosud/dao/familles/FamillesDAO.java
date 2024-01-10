package com.cesi.negosud.dao.familles;

import com.cesi.negosud.controller.familles.model.Familles;
import com.cesi.negosud.controller.familles.model.NewFamilles;
import com.cesi.negosud.dao.familles.model.FamillesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FamillesDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "famille_id";
    private static final String LIBELLE_FIELD = "libelle";
    private static final String DESIGNATION_FIELD = "designation";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String PRIX_UNIT_FIELD = "prix_unit";
    private static final String SEUIL_FIELD = "seuil";
    private static final String FOURNISSEUR_FIELD = "fk_fournisseur";





    @Autowired
    public FamillesDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<FamillesDTO> rowMapper = (rs, rowNum) -> {
        final FamillesDTO familles = new FamillesDTO();
        familles.setFamille_id(rs.getInt(ID_FIELD));
        familles.setLibelle(rs.getString(LIBELLE_FIELD));
        familles.setDesignation(rs.getString(DESIGNATION_FIELD));
        familles.setDescription(rs.getString(DESCRIPTION_FIELD));
        familles.setPrix_unit(rs.getFloat(PRIX_UNIT_FIELD));
        familles.setSeuil(rs.getInt(SEUIL_FIELD));
        familles.setFournisseur_id(rs.getInt(FOURNISSEUR_FIELD));

        return familles;
    };



    public Familles create(NewFamilles familles) {
        //INSERT DANS BDD
        Familles familles1= null;
        final String query = "INSERT INTO familles(libelle, designation, description, prix_unit, seuil, fk_fournisseur) VALUES(?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, familles.getLibelle(), familles.getDesignation(), familles.getDescription(), familles.getPrix_unit(), familles.getSeuil(), familles.getFournisseur_id());
        if(result ==1){
            //faire un select avant
            familles1= new Familles();
            familles1.setLibelle(familles.getLibelle());
            familles1.setDesignation(familles.getDesignation());
            familles1.setDescription(familles.getDescription());
            familles1.setPrix_unit(familles.getPrix_unit());
            familles1.setSeuil(familles.getSeuil());
            familles1.setFournisseur_id(familles.getFournisseur_id());
        }
        return familles1;
    }

    public boolean delete(int famille_id){
        //DELETE DANS BDD
        final String query = ("DELETE from familles where famille_id=?");
        int result = this.jdbcTemplate.update(query, famille_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Familles update(int famille_id, NewFamilles familles){
        //UPDATE DANS BDD
        Familles familles1= null;
        final String query = "UPDATE familles set libelle=?, designation=?, description=?, prix_unit=?, seuil=?, fk_fournisseur=? where famille_id=?";
        int result = this.jdbcTemplate.update(query, familles.getLibelle(), familles.getDesignation(), familles.getDescription(), familles.getPrix_unit(), familles.getSeuil(), familles.getFournisseur_id(), famille_id);
        if(result ==1){
            familles1= new Familles();
            familles1.setFamille_id(famille_id);
            familles1.setLibelle(familles.getLibelle());
            familles1.setDesignation(familles.getDesignation());
            familles1.setDescription(familles.getDescription());
            familles1.setPrix_unit(familles.getPrix_unit());
            familles1.setSeuil(familles.getSeuil());
            familles1.setFournisseur_id(familles.getFournisseur_id());
        }
        return familles1;
    }

    public Familles read(int famille_id) {
        // READ ONE PERSON DANS BDD
        List<FamillesDTO> dtos = this.jdbcTemplate.query("select * from familles where famille_id ="+famille_id, this.rowMapper);
        Familles familles = null;
        if(dtos != null && dtos.size() == 1){
            familles = new Familles();
            familles.setFamille_id(dtos.get(0).getFamille_id());
            familles.setLibelle(dtos.get(0).getLibelle());
            familles.setDesignation(dtos.get(0).getDesignation());
            familles.setDescription(dtos.get(0).getDescription());
            familles.setPrix_unit(dtos.get(0).getPrix_unit());
            familles.setSeuil(dtos.get(0).getSeuil());
            familles.setFournisseur_id(dtos.get(0).getFournisseur_id());
        }
        return familles;
    }

    public List<Familles> read() {
        // READ ALL PERSON DANS BDD
        List<Familles> listFamilles = null;
        List<FamillesDTO> dtos = this.jdbcTemplate.query("select * from familles", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listFamilles = new ArrayList<Familles> ();
            for (FamillesDTO dto : dtos) {
                Familles resp = new Familles();
                resp.setFamille_id(dto.getFamille_id());
                resp.setLibelle(dto.getLibelle());
                resp.setDesignation(dto.getDesignation());
                resp.setDescription(dto.getDescription());
                resp.setPrix_unit(dto.getPrix_unit());
                resp.setSeuil(dto.getSeuil());
                resp.setFournisseur_id(dto.getFournisseur_id());
                listFamilles.add(resp);
            }
        }
        return listFamilles;
    }

}

