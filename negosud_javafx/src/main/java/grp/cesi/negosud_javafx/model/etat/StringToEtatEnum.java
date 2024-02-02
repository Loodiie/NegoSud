package grp.cesi.negosud_javafx.model.etat;


public class StringToEtatEnum {
        public static Etat stringToEtatEnum(String string) {
            return Etat.valueOf(string.toUpperCase());
        }
        public static String etatEnumToString(Etat etat){
            return String.valueOf(etat).toLowerCase();
        }
}
