package com.cesi.negosud.dao.bonDeCommande;

import com.cesi.negosud.controller.bonDeCommande.model.BonDeCommande;
import com.cesi.negosud.controller.bonDeCommande.model.NewBonDeCommande;
import com.cesi.negosud.dao.bonDeCommande.model.BonDeCommandeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BonDeCommandeDAO {

    private final JdbcTemplate jdbcTemplate;

    private static String BONDECOMMANDEID_FIELD = "bonDeCommande_id";
    private static String QUANTITE_FIELD = "quantite";
    private static String ETAT_FIELD = "actif";
    private static String COMMANDECLIENTID_FIELD = "fk_commandeC";
    private static String ARTICLEVIDEID_FIELD = "fk_articleVide";

    @Autowired
    public BonDeCommandeDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<BonDeCommandeDTO> rowMapper = (rs, rowNum) -> {
        final BonDeCommandeDTO bonDeCommande = new BonDeCommandeDTO();
        bonDeCommande.setBonDeCommande_id(rs.getInt(BONDECOMMANDEID_FIELD));
        bonDeCommande.setQuantite(rs.getInt(QUANTITE_FIELD));
        bonDeCommande.setEtat(rs.getBoolean(ETAT_FIELD));
        bonDeCommande.setCommandeClient_id(rs.getInt(COMMANDECLIENTID_FIELD));
        bonDeCommande.setArticleVide_id(rs.getInt(ARTICLEVIDEID_FIELD));
        return bonDeCommande;
    };

    public BonDeCommande create(NewBonDeCommande bonDeCommande){
        BonDeCommande bonDeCommande1 = null;
        final String query = "INSERT INTO bonDeCommande(quantite, actif, fk_commandeC, fk_articleVide) VALUES (?,?,?,?)";
        int result = this.jdbcTemplate.update(query, bonDeCommande.getQuantite(), bonDeCommande.getEtat(),
                bonDeCommande.getCommandeClient_id(), bonDeCommande.getArticleVide_id());
        if (result == 1){
            List<BonDeCommande> listBonDeCommande = read();
            bonDeCommande1 = new BonDeCommande();
            bonDeCommande1.setBonDeCommande_id(listBonDeCommande.get(listBonDeCommande.size() - 1).getBonDeCommande_id());
            bonDeCommande1.setQuantite(bonDeCommande.getQuantite());
            bonDeCommande1.setEtat(bonDeCommande.getEtat());
            bonDeCommande1.setCommandeClient_id(bonDeCommande.getCommandeClient_id());
            bonDeCommande1.setArticleVide_id(bonDeCommande.getArticleVide_id());
        }
        return bonDeCommande1;
    }

    public boolean delete(int bonDeCommande_id){
        final String query = ("DELETE from bonDeCommande where bonDeCommande_id=?");
        int result = this.jdbcTemplate.update(query, bonDeCommande_id);
        if (result == 1){
            return true;
        }else  {
            return false;
        }
    }

    public BonDeCommande update(int bonDeCommande_id, NewBonDeCommande bonDeCommande){
        BonDeCommande bonDeCommande1 = null;
        final String query = "UPDATE bonDeCommande set quantite=?, actif=?, fk_commandeC=?, fk_articleVide=? where bonDeCommande_id=?";
        int result = this.jdbcTemplate.update(query, bonDeCommande.getQuantite(), bonDeCommande.getEtat(),
                bonDeCommande.getCommandeClient_id(), bonDeCommande.getArticleVide_id(), bonDeCommande_id);
        if(result == 1){
            bonDeCommande1 = new BonDeCommande();
            bonDeCommande1.setBonDeCommande_id(bonDeCommande_id);
            bonDeCommande1.setQuantite(bonDeCommande.getQuantite());
            bonDeCommande1.setEtat(bonDeCommande.getEtat());
            bonDeCommande1.setCommandeClient_id(bonDeCommande.getCommandeClient_id());
            bonDeCommande1.setArticleVide_id(bonDeCommande.getArticleVide_id());
        }
        return bonDeCommande1;
    }

    public BonDeCommande read(int bonDeCommande_id){
        List<BonDeCommandeDTO>  dtos = this.jdbcTemplate.query("select * from bonDeCommande where bonDeCommande_id="+bonDeCommande_id, this.rowMapper);
        BonDeCommande bonDeCommande = null;
        if(dtos != null && dtos.size() == 1){
            bonDeCommande = new BonDeCommande();
            bonDeCommande.setBonDeCommande_id(dtos.get(0).getBonDeCommande_id());
            bonDeCommande.setQuantite(dtos.get(0).getQuantite());
            bonDeCommande.setEtat(dtos.get(0).getEtat());
            bonDeCommande.setCommandeClient_id(dtos.get(0).getCommandeClient_id());
            bonDeCommande.setArticleVide_id(dtos.get(0).getArticleVide_id());
        }
        return bonDeCommande;
    }

    public List<BonDeCommande> read(){
        List<BonDeCommande> listBonDeCommande = null;
        List<BonDeCommandeDTO> dtos = this.jdbcTemplate.query("select * from bonDeCommande", this.rowMapper);
        if(dtos != null && dtos.size() > 0){
            listBonDeCommande = new ArrayList<BonDeCommande>();
            for(BonDeCommandeDTO dto : dtos){
                BonDeCommande resp = new BonDeCommande();
                resp.setBonDeCommande_id(dto.getBonDeCommande_id());
                resp.setQuantite(dto.getQuantite());
                resp.setEtat(dto.getEtat());
                resp.setCommandeClient_id(dto.getCommandeClient_id());
                resp.setArticleVide_id(dto.getArticleVide_id());
                listBonDeCommande.add(resp);
            }
        }
        return listBonDeCommande;
    }
}
