package org.example.cuatroenraya;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el menú principal desde el archivo FXML
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/cuatroenraya/MenuView.fxml"));

            // Configurar la escena y mostrarla
            Scene scene = new Scene(root);
            primaryStage.setTitle("Cuatro en Raya");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}