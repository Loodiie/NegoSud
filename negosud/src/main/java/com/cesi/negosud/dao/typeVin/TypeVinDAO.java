package com.cesi.negosud.dao.typeVin;

import com.cesi.negosud.controller.typeVin.model.TypeVin;
import com.cesi.negosud.controller.typeVin.model.NewTypeVin;
import com.cesi.negosud.dao.typeVin.model.TypeVinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TypeVinDAO {
    private final JdbcTemplate jdbcTemplate;

    private static String TYPEVINID_FIELD = "typeVin_id";
    private static String LIBELLE_FIELD = "libelle";

    @Autowired
    public TypeVinDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    private final RowMapper<TypeVinDTO> rowMapper = (rs, rowNum) -> {
        final TypeVinDTO typeVin = new TypeVinDTO();
        typeVin.setTypeVin_id(rs.getInt(TYPEVINID_FIELD));
        typeVin.setLibelle(rs.getString(LIBELLE_FIELD));
        return typeVin;
    };

    public TypeVin create(NewTypeVin typeVin){
        TypeVin typeVin1 = null;
        final String query = "INSERT INTO typeVin(libelle) VALUES (?)";
        int result = this.jdbcTemplate.update(query, typeVin.getLibelle());
        if (result == 1){
            List<TypeVin> listTypeVin = read();
            typeVin1 = new TypeVin();
            typeVin1.setTypeVin_id(listTypeVin.get(listTypeVin.size() - 1).getTypeVin_id());
            typeVin1.setLibelle(typeVin.getLibelle());
        }
        return typeVin1;
    }

    public boolean delete(int typeVin_id){
        final String query = ("DELETE from typeVin where typeVin_id=?");
        int result = this.jdbcTemplate.update(query, typeVin_id);
        if (result == 1){
            return true;
        }else  {
            return false;
        }
    }

    public TypeVin update(int typeVin_id, NewTypeVin typeVin){
        TypeVin typeVin1 = null;
        final String query = "UPDATE typeVin set libelle=? where typeVin_id=?";
        int result = this.jdbcTemplate.update(query, typeVin.getLibelle(), typeVin_id);
        if(result == 1){
            typeVin1 = new TypeVin();
            typeVin1.setTypeVin_id(typeVin_id);
            typeVin1.setLibelle(typeVin.getLibelle());
        }
        return typeVin1;
    }

    public TypeVin read(int typeVin_id){
        List<TypeVinDTO>  dtos = this.jdbcTemplate.query("select * from typeVin where typeVin_id="+typeVin_id, this.rowMapper);
        TypeVin typeVin = null;
        if(dtos != null && dtos.size() == 1){
            typeVin = new TypeVin();
            typeVin.setTypeVin_id(dtos.get(0).getTypeVin_id());
            typeVin.setLibelle(dtos.get(0).getLibelle());
        }
        return typeVin;
    }

    public List<TypeVin> read(){
        List<TypeVin> listTypeVin = null;
        List<TypeVinDTO> dtos = this.jdbcTemplate.query("select * from typeVin", this.rowMapper);
        if(dtos != null && dtos.size() > 0){
            listTypeVin = new ArrayList<TypeVin>();
            for(TypeVinDTO dto : dtos){
                TypeVin resp = new TypeVin();
                resp.setTypeVin_id(dto.getTypeVin_id());
                resp.setLibelle(dto.getLibelle());
                listTypeVin.add(resp);
            }
        }
        return listTypeVin;
    }
}
