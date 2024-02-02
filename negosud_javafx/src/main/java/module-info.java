module grp.cesi.negosud_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens grp.cesi.negosud_javafx to javafx.fxml;
    exports grp.cesi.negosud_javafx;
    exports grp.cesi.negosud_javafx.model.adresses;

}