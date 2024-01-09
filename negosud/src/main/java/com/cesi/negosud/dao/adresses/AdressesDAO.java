package com.cesi.negosud.dao.adresses;

import com.cesi.negosud.controller.adresses.model.Adresses;
import com.cesi.negosud.controller.adresses.model.NewAdresses;
import com.cesi.negosud.dao.adresses.model.AdressesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdressesDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "adresse_id";
    private static final String VILLE_FIELD = "ville";
    private static final String CODEPOSTAL_FIELD = "code_postal";
    private static final String PAYS_FIELD = "pays";
    private static final String NUMERO_FIELD = "numero";
    private static final String RUE_FIELD = "rue";
    private static final String ETAGE_FIELD = "etage";
    private static final String BATIMENT_FIELD = "batiment";
    private static final String COMPLEMENT_FIELD = "complement";



    @Autowired
    public AdressesDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<AdressesDTO> rowMapper = (rs, rowNum) -> {
        final AdressesDTO adresses = new AdressesDTO();
        adresses.setAdresse_id(rs.getInt(ID_FIELD));
        adresses.setVille(rs.getString(VILLE_FIELD));
        adresses.setCode_postal(rs.getString(CODEPOSTAL_FIELD));
        adresses.setPays(rs.getString(PAYS_FIELD));
        adresses.setNumero(rs.getString(NUMERO_FIELD));
        adresses.setRue(rs.getString(RUE_FIELD));
        adresses.setEtage(rs.getString(ETAGE_FIELD));
        adresses.setBatiment(rs.getString(BATIMENT_FIELD));
        adresses.setComplement(rs.getString(COMPLEMENT_FIELD));
        return adresses;
    };



    public Adresses create(NewAdresses adresses) {
        //INSERT DANS BDD
        Adresses adresses1= null;
        final String query = "INSERT INTO adresses(ville, code_postal, pays, numero, rue, etage, batiment,complement) VALUES(?,?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, adresses.getVille(), adresses.getCode_postal(), adresses.getPays(), adresses.getNumero(), adresses.getRue(), adresses.getEtage(), adresses.getBatiment(), adresses.getComplement());
        if(result ==1){
            //faire un select avant
            adresses1= new Adresses();
            adresses1.setVille(adresses.getVille());
            adresses1.setCode_postal(adresses.getCode_postal());
            adresses1.setPays(adresses.getPays());
            adresses1.setNumero(adresses.getNumero());
            adresses1.setRue(adresses.getRue());
            adresses1.setEtage(adresses.getEtage());
            adresses1.setBatiment(adresses.getBatiment());
            adresses1.setComplement(adresses.getComplement());
        }
        return adresses1;
    }

    public boolean delete(int adresse_id){
        //DELETE DANS BDD
        final String query = ("DELETE from adresses where adresse_id=?");
        int result = this.jdbcTemplate.update(query, adresse_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Adresses update(int adresse_id, NewAdresses adresses){
        //UPDATE DANS BDD
        Adresses adresses1= null;
        final String query = "UPDATE adresses set ville=?, code_postal=?, pays=?, numero=?, rue=?, etage=?, batiment=?, complement=? where adresse_id=?";
        int result = this.jdbcTemplate.update(query, adresses.getVille(), adresses.getCode_postal(), adresses.getPays(), adresses.getNumero(), adresses.getRue(), adresses.getEtage(), adresses.getBatiment(), adresses.getComplement(), adresse_id);
        if(result ==1){
            adresses1= new Adresses();
            adresses1.setAdresse_id(adresse_id);
            adresses1.setVille(adresses.getVille());
            adresses1.setCode_postal(adresses.getCode_postal());
            adresses1.setPays(adresses.getPays());
            adresses1.setNumero(adresses.getNumero());
            adresses1.setRue(adresses.getRue());
            adresses1.setEtage(adresses.getEtage());
            adresses1.setBatiment(adresses.getBatiment());
            adresses1.setComplement(adresses.getComplement());
        }
        return adresses1;
    }

    public Adresses read(int adresse_id) {
        // READ ONE PERSON DANS BDD
        List<AdressesDTO> dtos = this.jdbcTemplate.query("select * from adresses where adresse_id ="+adresse_id, this.rowMapper);
        Adresses adresses = null;
        if(dtos != null && dtos.size() == 1){
            adresses = new Adresses();
            adresses.setAdresse_id(dtos.get(0).getAdresse_id());
            adresses.setVille(dtos.get(0).getVille());
            adresses.setCode_postal(dtos.get(0).getCode_postal());
            adresses.setPays(dtos.get(0).getPays());
            adresses.setNumero(dtos.get(0).getNumero());
            adresses.setRue(dtos.get(0).getRue());
            adresses.setEtage(dtos.get(0).getEtage());
            adresses.setBatiment(dtos.get(0).getBatiment());
            adresses.setComplement(dtos.get(0).getComplement());


        }
        return adresses;
    }

    public List<Adresses> read() {
        // READ ALL PERSON DANS BDD
        List<Adresses> listAdresses = null;
        List<AdressesDTO> dtos = this.jdbcTemplate.query("select * from adresses", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listAdresses = new ArrayList<Adresses>();
            for (AdressesDTO dto : dtos) {
                Adresses resp = new Adresses();
                resp.setAdresse_id(dto.getAdresse_id());
                resp.setVille(dto.getVille());
                resp.setCode_postal(dto.getCode_postal());
                resp.setPays(dto.getPays());
                resp.setNumero(dto.getNumero());
                resp.setRue(dto.getRue());
                resp.setEtage(dto.getEtage());
                resp.setBatiment(dto.getBatiment());
                resp.setComplement(dto.getComplement());
                listAdresses.add(resp);
            }
        }
        return listAdresses;
    }

}

