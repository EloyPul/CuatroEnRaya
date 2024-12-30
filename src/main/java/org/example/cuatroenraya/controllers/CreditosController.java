package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
@author Eloy
 */

public class CreditosController {

    @FXML
    private Button btnVolver; //Boton para volver al menú principal

    @FXML
    private void volverAlMenu() {
        try {
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/cuatroenraya/MenuView.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
