package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JuegoController {

    @FXML
    private GridPane tableroRoot;

    @FXML
    private Button btnVolver;

    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;

    @FXML
    public void initialize() {
        // Inicializar las celdas del tablero
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Circle celda = new Circle(30, Color.LIGHTGRAY);
                celda.setStroke(Color.BLACK);
                tableroRoot.add(celda, columna, fila);
            }
        }
    }

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
