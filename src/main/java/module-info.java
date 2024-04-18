module tn.esprit.dhiajava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens tn.esprit.dhiajava to javafx.fxml;
    exports tn.esprit.dhiajava;
}