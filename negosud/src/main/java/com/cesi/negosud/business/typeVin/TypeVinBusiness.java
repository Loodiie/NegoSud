package com.cesi.negosud.business.typeVin;

import com.cesi.negosud.controller.typeVin.model.TypeVin;
import com.cesi.negosud.controller.typeVin.model.NewTypeVin;
import com.cesi.negosud.dao.typeVin.TypeVinDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVinBusiness {

    private final TypeVinDAO typeVinDAO;

    @Autowired
    public TypeVinBusiness(TypeVinDAO typeVinDAO){this.typeVinDAO = typeVinDAO;}

    public TypeVin createTypeVinBusiness(NewTypeVin typeVin){return typeVinDAO.create(typeVin);}

    public boolean deleteTypeVinBusiness(int typeVin_id){return typeVinDAO.delete(typeVin_id);}

    public TypeVin updateTypeVinBusiness(int typeVin_id, NewTypeVin typeVin){
        return typeVinDAO.update(typeVin_id, typeVin);
    }

    public TypeVin getTypeVinBusiness(int typeVin_id){return typeVinDAO.read(typeVin_id);}

    public List<TypeVin> getAllTypeVinBusiness(){return typeVinDAO.read();}
}
