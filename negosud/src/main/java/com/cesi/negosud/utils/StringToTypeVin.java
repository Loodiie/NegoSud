package com.cesi.negosud.utils;

import com.cesi.negosud.utils.TypeVin;
import java.util.Locale;

public class StringToTypeVin {
    public static TypeVin stringToTypeVin(String string) {
        return TypeVin.valueOf(string.toUpperCase());
    }
    public static String typeVinToString(TypeVin typeVin){
        return String.valueOf(typeVin).toLowerCase();
    }
}
