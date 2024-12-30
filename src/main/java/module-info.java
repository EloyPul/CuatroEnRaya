module org.example.cuatroenraya {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.cuatroenraya to javafx.fxml;
    exports org.example.cuatroenraya;
    exports org.example.cuatroenraya.controllers;
    opens org.example.cuatroenraya.controllers to javafx.fxml;
}