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




    @Autowired
    public PaiementsDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<PaiementsDTO> rowMapper = (rs, rowNum) -> {
        final PaiementsDTO Paiements = new PaiementsDTO();
        Paiements.setPaiements_id(rs.getInt(ID_FIELD));
        Paiements.setDate_prelevement(rs.getLong(DATE_PRELEVELEMENT_FIELD));
        Paiements.setType_paiement(rs.getString(TYPE_PAIEMENT_FIELD));
        Paiements.setAcquitte(rs.getBoolean(ACQUITTE_FIELD));
        Paiements.setEcheance(rs.getInt(ECHEANCE_FIELD));

        return Paiements;
    };



    public Paiements create(NewPaiements Paiements) {
        //INSERT DANS BDD
        Paiements Paiements1= null;
        final String query = "INSERT INTO paiements(date_prelevement,type_prelevement,acquitte,echeance) " +
                "VALUES(?,?,?,?)";
        int result = this.jdbcTemplate.update(query, Paiements.getDate_prelevement(),
                Paiements.getType_paiement(),Paiements.isAcquitte(),Paiements.getEcheance());
        if(result ==1){
            //faire un select avant
            Paiements1= new Paiements();
            Paiements1.setDate_prelevement(Paiements.getDate_prelevement());
            Paiements1.setType_paiement(Paiements.getType_paiement());
            Paiements1.setAcquitte(Paiements.isAcquitte());
            Paiements1.setEcheance(Paiements.getEcheance());
        }
        return Paiements1;
    }

    public boolean delete(int paiements_id){
        //DELETE DANS BDD
        final String query = ("DELETE from paiements where id=?");
        int result = this.jdbcTemplate.update(query, paiements_id);
        if(result == 1) {
            return true;
        }else{
            return false;
        }
    }

    public Paiements update(int paiements_id, NewPaiements Paiements){
        //UPDATE DANS BDD
        Paiements Paiements1= null;
        final String query = "UPADATE paiements set date_prelevement=?, type_paiement=?, acquitte=?, echeance=? where id=?";
        int result = this.jdbcTemplate.update(query, Paiements.getDate_prelevement(),
                Paiements.getType_paiement(), Paiements.isAcquitte(), Paiements.getEcheance(), paiements_id);
        if(result ==1){
            Paiements1= new Paiements();
            Paiements1.setPaiements_id(paiements_id);
            Paiements1.setDate_prelevement(Paiements.getDate_prelevement());
            Paiements1.setType_paiement(Paiements.getType_paiement());
            Paiements1.setAcquitte(Paiements.isAcquitte());
            Paiements1.setEcheance(Paiements.getEcheance());

        }
        return Paiements1;
    }

    public Paiements read(int paiements_id) {
        // READ ONE PERSON DANS BDD
        List<PaiementsDTO> dtos = this.jdbcTemplate.query("select * from paiements where paiements_id ="+paiements_id, this.rowMapper);
        Paiements Paiements = null;
        if(dtos != null && dtos.size() == 1){
            Paiements = new Paiements();
            Paiements.setPaiements_id(dtos.get(0).getPaiements_id());
            Paiements.setDate_prelevement(dtos.get(0).getDate_prelevement());
            Paiements.setType_paiement(dtos.get(0).getType_paiement());
            Paiements.setAcquitte(dtos.get(0).isAcquitte());
            Paiements.setEcheance(dtos.get(0).getEcheance());
        }
        return Paiements;
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
                listPaiements.add(resp);
            }
        }
        return listPaiements;
    }
}
