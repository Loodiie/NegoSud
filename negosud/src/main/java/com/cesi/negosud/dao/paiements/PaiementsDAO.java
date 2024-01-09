package com.cesi.negosud.dao.paiements;

import com.cesi.negosud.controller.paiements.model.Paiements;
import com.cesi.negosud.controller.paiements.model.NewPaiements;
import com.cesi.negosud.dao.paiements.model.PaiementsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaiementsDAO {
    private final JdbcTemplate jdbcTemplate;

    private static final String ID_FIELD = "paiements_id";
    private static final String DATE_PRELEVELEMENT_FIELD = "date_prelevement";
    private static final String TYPE_PAIEMENT_FIELD = "type_paiement";
    private static final String ACQUITTE_FIELD = "acquitte";
    private static final String ECHEANCE_FIELD = "echeance";
    private static final String FACTUREID_FIELD = "fk_facture";




    @Autowired
    public PaiementsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<PaiementsDTO> rowMapper = (rs, rowNum) -> {
        final PaiementsDTO paiements = new PaiementsDTO();
        paiements.setPaiements_id(rs.getInt(ID_FIELD));
        paiements.setDate_prelevement(rs.getLong(DATE_PRELEVELEMENT_FIELD));
        paiements.setType_paiement(rs.getString(TYPE_PAIEMENT_FIELD));
        paiements.setAcquitte(rs.getBoolean(ACQUITTE_FIELD));
        paiements.setEcheance(rs.getInt(ECHEANCE_FIELD));
        paiements.setEcheance(rs.getInt(FACTUREID_FIELD));

        return paiements;
    };



    public Paiements create(NewPaiements Paiements) {
        //INSERT DANS BDD
        Paiements paiements1= null;
        final String query = "INSERT INTO paiements(date_prelevement,type_prelevement,acquitte,echeance,fk_facture) " +
                "VALUES(?,?,?,?,?)";
        int result = this.jdbcTemplate.update(query, Paiements.getDate_prelevement(),
                Paiements.getType_paiement(),Paiements.isAcquitte(),Paiements.getEcheance(),Paiements.getId_facture());
        if(result ==1){
            //faire un select avant
            paiements1= new Paiements();
            paiements1.setDate_prelevement(Paiements.getDate_prelevement());
            paiements1.setType_paiement(Paiements.getType_paiement());
            paiements1.setAcquitte(Paiements.isAcquitte());
            paiements1.setEcheance(Paiements.getEcheance());
            paiements1.setEcheance(Paiements.getId_facture());
        }
        return paiements1;
    }

    public boolean delete(int paiements_id){
        //DELETE DANS BDD
        final String query = ("DELETE from paiements where paiement_id=?");
        int result = this.jdbcTemplate.update(query, paiements_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Paiements update(int paiements_id, NewPaiements paiements){
        //UPDATE DANS BDD
        Paiements paiements1= null;
        final String query = "UPDATE paiements set date_prelevement=?, type_paiement=?, acquitte=?, echeance=?, fk_facture=? where paiement_id=?";
        int result = this.jdbcTemplate.update(query, paiements.getDate_prelevement(), paiements.getType_paiement(),
                paiements.isAcquitte(), paiements.getEcheance(),paiements.getId_facture(), paiements_id);
        if(result ==1){
            paiements1= new Paiements();
            paiements1.setPaiements_id(paiements_id);
            paiements1.setDate_prelevement(paiements.getDate_prelevement());
            paiements1.setType_paiement(paiements.getType_paiement());
            paiements1.setAcquitte(paiements.isAcquitte());
            paiements1.setEcheance(paiements.getEcheance());

        }
        return paiements1;
    }

    public Paiements read(int paiements_id) {
        // READ ONE PERSON DANS BDD
        List<PaiementsDTO> dtos = this.jdbcTemplate.query("select * from paiements where paiements_id ="+paiements_id, this.rowMapper);
        Paiements paiements = null;
        if(dtos != null && dtos.size() == 1){
            paiements = new Paiements();
            paiements.setPaiements_id(dtos.get(0).getPaiements_id());
            paiements.setDate_prelevement(dtos.get(0).getDate_prelevement());
            paiements.setType_paiement(dtos.get(0).getType_paiement());
            paiements.setAcquitte(dtos.get(0).isAcquitte());
            paiements.setEcheance(dtos.get(0).getEcheance());
            paiements.setId_facture(dtos.get(0).getPaiements_id());
        }
        return paiements;
    }

    public List<Paiements> read() {
        // READ ALL PERSON DANS BDD
        List<Paiements> listPaiements = null;
        List<PaiementsDTO> dtos = this.jdbcTemplate.query("select * from paiements", this.rowMapper);
        if (dtos != null && dtos.size() > 0) {
            listPaiements = new ArrayList<Paiements>();
            for (PaiementsDTO dto : dtos) {
                Paiements resp = new Paiements();
                resp.setPaiements_id(dto.getPaiements_id());
                resp.setDate_prelevement(dto.getDate_prelevement());
                resp.setType_paiement(dto.getType_paiement());
                resp.setAcquitte(dto.isAcquitte());
                resp.setEcheance(dto.getEcheance());
                resp.setId_facture(dto.getPaiements_id());
                listPaiements.add(resp);
            }
        }
        return listPaiements;
    }
}
