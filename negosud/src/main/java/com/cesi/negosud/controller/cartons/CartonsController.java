package com.cesi.negosud.controller.cartons;

import com.cesi.negosud.business.cartons.CartonsBusiness;
import com.cesi.negosud.controller.cartons.model.Cartons;
import com.cesi.negosud.controller.cartons.model.NewCartons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class CartonsController {

    private final String versionBDD = "/api/v1";

    private final CartonsBusiness cartonsBusiness;

    @Autowired
    public CartonsController(CartonsBusiness cartonsBusiness){this.cartonsBusiness = cartonsBusiness;}

    @PostMapping(versionBDD + "/cartons")
    public Cartons createCartonsBDD(@RequestBody NewCartons cartons){
        return cartonsBusiness.createCartonsBusiness(cartons);
    }

    @DeleteMapping(versionBDD + "/cartons/{carton_id}")
    public boolean deleteCartonsBDD(@PathVariable int carton_id){
        return cartonsBusiness.deleteCartonsBusiness(carton_id);
    }

    @PutMapping(versionBDD + "/cartons/{carton_id}")
    public Cartons updateCartonsBDD(@PathVariable int carton_id, @RequestBody NewCartons cartons){
        return cartonsBusiness.updateCartonsBusiness(carton_id, cartons);
    }

    @GetMapping(versionBDD + "/cartons/{carton_id}")
    public Cartons getCartonsBDD(@PathVariable int carton_id){
        return cartonsBusiness.getCartonsBusiness(carton_id);
    }

    @GetMapping(versionBDD + "/cartons")
    public List<Cartons> getAllCartonsBDD(){ return cartonsBusiness.getAllCartonsBusiness();}
}
