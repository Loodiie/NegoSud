package com.cesi.negosud.dao.familles;

import com.cesi.negosud.controller.familles.model.Familles;
import com.cesi.negosud.controller.familles.model.NewFamilles;
import com.cesi.negosud.dao.familles.model.FamillesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class FamillesDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "famille_id";
    private static final String LIBELLE_FIELD = "libelle";




    @Autowired
    public FamillesDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<FamillesDTO> rowMapper = (rs, rowNum) -> {
        final FamillesDTO familles = new FamillesDTO();
        familles.setFamille_id(rs.getInt(ID_FIELD));
        familles.setLibelle(rs.getString(LIBELLE_FIELD));
        return familles;
    };



    public Familles create(NewFamilles familles) {
        //INSERT DANS BDD
        Familles familles1= null;
        final String query = "INSERT INTO familles(libelle) VALUES(?)";
        int result = this.jdbcTemplate.update(query, familles.getLibelle());
        if(result ==1){
            //faire un select avant
            familles1= new Familles();
            familles1.setLibelle(familles.getLibelle());
        }
        return familles1;
    }

    public boolean delete(int famille_id){
        //DELETE DANS BDD
        final String query = ("DELETE from familles where id=?");
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
        final String query = "UPADATE familles set libelle=? where id=?";
        int result = this.jdbcTemplate.update(query, familles.getLibelle());
        if(result ==1){
            familles1= new Familles();
            familles1.setFamille_id(famille_id);
            familles1.setLibelle(familles.getLibelle());
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
                listFamilles.add(resp);
            }
        }
        return listFamilles;
    }

}

