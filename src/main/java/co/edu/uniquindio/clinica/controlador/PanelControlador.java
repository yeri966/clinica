package co.edu.uniquindio.clinica.controlador;

import co.edu.uniquindio.clinica.servicios.ClinicaServicio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.awt.event.ActionEvent;

public class PanelControlador {

    @FXML private StackPane panelPrincipal;
    private final ClinicaServicio servicio = ClinicaServicio.getInstancia();

    @FXML
    public void initialize() {
        // Carga inicial si quieres
    }

    @FXML
    public void mostrarRegistroPaciente(ActionEvent e) {
        cargarPanel("/co/edu/uniquindio/clinica/vista/registroPaciente.fxml");
    }

    @FXML
    public void mostrarListaPacientes(ActionEvent e) {
        cargarPanel("/co/edu/uniquindio/clinica/vista/listaPaciente.fxml");
    }

    @FXML
    public void mostrarRegistroCita(ActionEvent e) {
        cargarPanel("/co/edu/uniquindio/clinica/vista/registroCita.fxml");
    }

    @FXML
    public void mostrarListaCitas(ActionEvent e) {
        cargarPanel("/co/edu/uniquindio/clinica/vista/listaCitas.fxml");
    }

    private void cargarPanel(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent node = loader.load();
            // Inyectar servicio
            ((ControladorAbstracto)loader.getController()).inicializarClinica(servicio);
            panelPrincipal.getChildren().setAll(node);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
