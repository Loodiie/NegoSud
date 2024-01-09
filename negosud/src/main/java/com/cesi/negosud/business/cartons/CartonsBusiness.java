package com.cesi.negosud.business.cartons;

import com.cesi.negosud.controller.cartons.model.Cartons;
import com.cesi.negosud.controller.cartons.model.NewCartons;
import com.cesi.negosud.dao.cartons.CartonsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartonsBusiness {
    private final CartonsDAO cartonsDAO;

    @Autowired
    public CartonsBusiness(CartonsDAO cartonsDAO){
        this.cartonsDAO = cartonsDAO;
    }

    public Cartons createCartonsBusiness(NewCartons cartons){
        return cartonsDAO.create(cartons);
    }

    public boolean deleteCartonsBusiness(int carton_id){
        return cartonsDAO.delete(carton_id);
    }

    public Cartons updateCartonsBusiness(int carton_id, NewCartons cartons){
        return cartonsDAO.update(carton_id, cartons);
    }

    public Cartons getCartonsBusiness(int carton_id){
        return cartonsDAO.read(carton_id);
    }

    public  List<Cartons> getAllCartonsBusiness(){
        return cartonsDAO.read();
    }

}
