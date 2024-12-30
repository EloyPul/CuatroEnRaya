package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/*
@author Eloy
 */

//NO FUNCIONA, SOLO VISUAL
public class ConfiguracionController {
    @FXML
    private ComboBox<String> colorJugador1; //Color del jugador 1
    @FXML
    private ComboBox<String> colorJugador2; //Color del jugador 2
    @FXML
    private ComboBox<String> ordenSalida; //Orden de salida
    @FXML
    private Button btnVolver; //Boton para volver al menú principal

    @FXML
    public void initialize() {
        //Selectores de colores y inicio del juego (No funciona)
        colorJugador1.getItems().addAll("Rojo", "Azul", "Verde", "Amarillo");
        colorJugador2.getItems().addAll("Rojo", "Azul", "Verde", "Amarillo");
        ordenSalida.getItems().addAll("Jugador 1", "Jugador 2", "Aleatorio");
    }

    @FXML
    private void volverAlMenu() { //Metodo para volver al Menu
        try {
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/cuatroenraya/MenuView.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
