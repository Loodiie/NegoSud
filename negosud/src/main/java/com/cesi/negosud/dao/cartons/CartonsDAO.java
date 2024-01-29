package com.cesi.negosud.dao.cartons;

import com.cesi.negosud.controller.cartons.model.Cartons;
import com.cesi.negosud.controller.cartons.model.NewCartons;
import com.cesi.negosud.dao.cartons.model.CartonsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartonsDAO {
    private final JdbcTemplate jdbcTemplate;
    private static String CARTONID_FIELD = "carton_id";
    private static String DESCRIPTION_FIELD = "description";

    @Autowired
    public CartonsDAO(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate (dataSource);}

    private final RowMapper<CartonsDTO> rowMapper = (rs, rowNum) -> {
        final CartonsDTO cartons = new CartonsDTO();
        cartons.setCarton_id(rs.getInt(CARTONID_FIELD));
        cartons.setDescription(rs.getString(DESCRIPTION_FIELD));
        return cartons;
    };

    public Cartons create(NewCartons cartons){
        Cartons cartons1 = null;
        final String query = "INSERT INTO cartons(description) VALUES(?)";
        int result = this.jdbcTemplate.update(query, cartons.getDescription());
        if(result == 1){
            List<Cartons> listCartons = read();
            cartons1 = new Cartons();
            cartons1.setCarton_id(listCartons.get(listCartons.size() - 1).getCarton_id());
            cartons1.setDescription(cartons.getDescription());
        }
        return cartons1;
    }

    public boolean delete(int carton_id){
        final String query = ("DELETE from cartons where carton_id=?");
        int result = this.jdbcTemplate.update(query, carton_id);
        if(result == 1){
            return true;
        }else {
            return false;
        }
    }

    public Cartons update(int carton_id, NewCartons cartons){
        Cartons cartons1 = null;
        final String query = "UPDATE cartons set description=? where carton_id=?";
        int result = this.jdbcTemplate.update(query, cartons.getDescription(), carton_id);
        if(result == 1){
            cartons1 = new Cartons();
            cartons1.setCarton_id(carton_id);
            cartons1.setDescription(cartons.getDescription());
        }
        return cartons1;
    }

    public Cartons read(int carton_id){
        List<CartonsDTO> dtos = this.jdbcTemplate.query("select * from cartons where carton_id="+carton_id, this.rowMapper);
        Cartons cartons = null;
        if(dtos != null && dtos.size() == 1){
            cartons = new Cartons();
            cartons.setCarton_id(dtos.get(0).getCarton_id());
            cartons.setDescription(dtos.get(0).getDescription());
        }
        return cartons;
    }

    public List<Cartons> read(){
        List<Cartons> listCartons = null;
        List<CartonsDTO> dtos = this.jdbcTemplate.query("select * from cartons", this.rowMapper);
        if(dtos != null && dtos.size() > 0){
            listCartons = new ArrayList<Cartons>();
            for(CartonsDTO dto : dtos){
                Cartons resp = new Cartons();
                resp.setCarton_id(dto.getCarton_id());
                resp.setDescription(dto.getDescription());
                listCartons.add(resp);
            }
        }
        return listCartons;
    }
}
