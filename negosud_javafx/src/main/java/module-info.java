module grp.cesi.negosud_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens grp.cesi.negosud_javafx to javafx.fxml;
    exports grp.cesi.negosud_javafx;
}