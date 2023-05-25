module com.converter {
    requires javafx.fxml;
    // requires javafx.controls;
    requires javafx.graphics;
    requires transitive javafx.controls;
    
    opens com.converter to javafx.graphics;
    exports com.converter;
}