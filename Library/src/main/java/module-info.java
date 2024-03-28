module library.library {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens library.library to javafx.fxml;
    exports library.library;
}