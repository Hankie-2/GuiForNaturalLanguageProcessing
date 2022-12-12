module kg.charginov.naturallanguageprocessing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens kg.charginov.naturallanguageprocessing to javafx.fxml;
    exports kg.charginov.naturallanguageprocessing;
}