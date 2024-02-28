module com.cesi.client_lourd_negosud {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.fasterxml.jackson.databind;

    opens com.cesi.client_lourd_negosud to javafx.fxml;
    exports com.cesi.client_lourd_negosud;
    exports com.cesi.client_lourd_negosud.models;

}