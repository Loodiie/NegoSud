package com.cesi.negosud.controller.typeVin;

import com.cesi.negosud.business.typeVin.TypeVinBusiness;
import com.cesi.negosud.controller.typeVin.model.TypeVin;
import com.cesi.negosud.controller.typeVin.model.NewTypeVin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class TypeVinController {

    private final String versionBDD ="/api/v1";
    private final TypeVinBusiness typeVinBusiness;

    @Autowired
    private  TypeVinController (TypeVinBusiness typeVinBusiness){this.typeVinBusiness = typeVinBusiness;}

    @PostMapping(versionBDD + "/typeVin")
    public TypeVin createTypeVinBDD(@RequestBody NewTypeVin typeVin){
        return typeVinBusiness.createTypeVinBusiness(typeVin);
    }

    @DeleteMapping(versionBDD + "/typeVin/{typeVin_id}")
    public boolean deleteTypeVinBDD(@PathVariable int typeVin_id){
        return typeVinBusiness.deleteTypeVinBusiness(typeVin_id);
    }

    @PutMapping(versionBDD + "/typeVin/{typeVin_id}")
    public TypeVin updateTypeVinBDD(@PathVariable int typeVin_id, @RequestBody NewTypeVin typeVin){
        return typeVinBusiness.updateTypeVinBusiness(typeVin_id, typeVin);
    }

    @GetMapping(versionBDD + "/typeVin/{typeVin_id}")
    public TypeVin getTypeVinBDD(@PathVariable int typeVin_id){return typeVinBusiness.getTypeVinBusiness(typeVin_id);}

    @GetMapping(versionBDD + "/typeVin")
    public List<TypeVin> getAllTypeVinBDD(){return typeVinBusiness.getAllTypeVinBusiness();}

}
