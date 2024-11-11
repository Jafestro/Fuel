module org.example.fuel {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.fuel to javafx.fxml;
    exports org.example.fuel;
}