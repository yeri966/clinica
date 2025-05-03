package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.servicios.ClinicaServicio;
import co.edu.uniquindio.clinica.util.Persistencia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClinicaApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/clinica/vista/panel.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Clínica");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}