package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuController {

    @FXML
    private Button btnJugar;
    @FXML
    private Button btnConfiguracion;
    @FXML
    private Button btnCreditos;
    @FXML
    private Button btnSalir;

    @FXML
    public void initialize() {
        btnJugar.setOnAction(e -> cargarVista("/org/example/cuatroenraya/JuegoView.fxml"));
        btnConfiguracion.setOnAction(e -> cargarVista("/org/example/cuatroenraya/ConfiguracionView.fxml"));
        btnCreditos.setOnAction(e -> cargarVista("/org/example/cuatroenraya/CreditosView.fxml"));
        btnSalir.setOnAction(e -> ((Stage) btnSalir.getScene().getWindow()).close());
    }

    private void cargarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage stage = (Stage) btnJugar.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
