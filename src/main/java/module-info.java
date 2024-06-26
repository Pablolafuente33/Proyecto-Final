module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires jdk.internal.le;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports Tablero;
    opens Tablero to javafx.fxml;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports Parameter.Properties;
    opens Parameter.Properties to javafx.fxml;
}