package com.cesi.negosud.utils;


public class StringToEtatEnum {
        public static Etat stringToEtatEnum(String string) {
            return Etat.valueOf(string.toUpperCase());
        }
        public static String etatEnumToString(Etat etat){
            return String.valueOf(etat).toLowerCase();
        }
}
