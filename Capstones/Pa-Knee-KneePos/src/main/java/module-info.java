module org.example.pakneekneepos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens org.example.pakneekneepos to javafx.fxml;
    exports org.example.pakneekneepos;
}