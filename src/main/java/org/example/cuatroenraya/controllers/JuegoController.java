package org.example.cuatroenraya.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
@author Eloy
 */

public class JuegoController {

    @FXML
    private GridPane tableroRoot;

    @FXML
    private Button btnVolver;

    //Tamaño del tablero
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private Circle[][] tablero = new Circle[FILAS][COLUMNAS];
    private boolean turnoJugador1 = true; //Turno del jugador, si esta en true es el 1, false el 2

    @FXML
    public void initialize() {
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Circle celda = new Circle(30, Color.LIGHTGRAY);
                celda.setStroke(Color.BLACK);
                tablero[fila][columna] = celda;
                int finalColumna = columna;
                celda.setOnMouseClicked(event -> colocarFicha(finalColumna));
                tableroRoot.add(celda, columna, fila);
            }
        }
    }

    private void colocarFicha(int columna) {

        for (int fila = FILAS - 1; fila >= 0; fila--) {
            if (tablero[fila][columna].getFill().equals(Color.LIGHTGRAY)) {
                Color colorActual = turnoJugador1 ? Color.RED : Color.YELLOW; //Esto deberia cambiarlo para que coja la configuracion
                tablero[fila][columna].setFill(colorActual);

                //Verifica si hay un ganador
                if (verificarGanador(fila, columna, colorActual)) {
                    mostrarGanador(colorActual);
                    return;
                }
                turnoJugador1 = !turnoJugador1; //Cambiar turno
                return;
            }
        }
        System.out.println("Columna llena. Elige otra columna.");
    }

    private boolean verificarGanador(int fila, int columna, Color color) {
        return verificarLinea(fila, columna, 0, 1, color) //Horizontal
                || verificarLinea(fila, columna, 1, 0, color) //Vertical
                || verificarLinea(fila, columna, 1, 1, color) //Diagonal descendente
                || verificarLinea(fila, columna, 1, -1, color); //Diagonal ascendente
    }

    private boolean verificarLinea(int fila, int columna, int incrementoFila, int incrementoColumna, Color color) {
        int cuenta = 1;
        //Verifica la linea hacia delante contando 4
        cuenta += contarFichas(fila, columna, incrementoFila, incrementoColumna, color);
        //Verifica la linea hacia atras contando 4
        cuenta += contarFichas(fila, columna, -incrementoFila, -incrementoColumna, color);
        return cuenta >= 4;
    }

    //Metodo que usa verificarLinea para saber que jugador a ganado contando las fichas del mismo color en orden
    private int contarFichas(int fila, int columna, int incrementoFila, int incrementoColumna, Color color) {
        int cuenta = 0;

        while (true) {
            fila += incrementoFila;
            columna += incrementoColumna;
            if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
                break;
            }
            if (!tablero[fila][columna].getFill().equals(color)) {
                break;
            }
            cuenta++;
        }
        return cuenta;
    }

    private void mostrarGanador(Color colorGanador) {
        //Cambiar los colores a una bandera cuando algun jugador gane
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Color nuevoColor = switch ((fila + columna) % 4) {
                    case 0 -> Color.RED;
                    case 1 -> Color.YELLOW;
                    case 2 -> Color.GREEN;
                    default -> Color.BLUE;
                };
                tablero[fila][columna].setFill(nuevoColor);
            }
        }

        //Mensaje ganador
        String jugador = colorGanador.equals(Color.RED) ? "Jugador 1 (Rojo)" : "Jugador 2 (Amarillo)";
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("¡Ganador!");
        alerta.setHeaderText("¡Tenemos un ganador!");
        alerta.setContentText("El ganador es: " + jugador);
        alerta.showAndWait();

        //Se reinicia
        inicializarTablero();
    }

    @FXML
    private void volverAlMenu() {
        try {
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/cuatroenraya/views/MainMenu.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
