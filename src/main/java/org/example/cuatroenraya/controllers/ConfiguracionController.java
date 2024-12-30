package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class ConfiguracionController {

    @FXML
    private Button btnVolver;

    @FXML
    private void volverAlMenu() {
        // Cargar el menú principal
        try {
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/cuatroenraya/MenuView.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
