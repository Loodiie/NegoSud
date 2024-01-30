package com.cesi.negosud.utils;

import com.cesi.negosud.utils.Etat;
import java.util.Locale;

public class EtatEnum {
        public static Etat stringToEtatEnum(String string) {
            return Etat.valueOf(string.toUpperCase());
        }
        public static String typeVinToEtatEnum(Etat etat){
            return String.valueOf(etat).toLowerCase();
        }
}
