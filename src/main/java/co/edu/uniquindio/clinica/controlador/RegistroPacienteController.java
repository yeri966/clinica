package co.edu.uniquindio.clinica.controlador;

import co.edu.uniquindio.clinica.excepciones.ClinicaException;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.patrones.factory.SuscripcionFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistroPacienteControlador extends ControladorAbstracto {

    @FXML
    private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtCorreo;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cbSuscripcion;
    @FXML private Label lblMensaje;

    @FXML
    public void initialize() {
        cbSuscripcion.getItems().addAll("Básica", "Premium");
    }

    @FXML
    public void registrarPaciente() {
        try {
            Paciente p = Paciente.builder()
                    .nombre(txtNombre.getText())
                    .documento(txtDocumento.getText())
                    .correo(txtCorreo.getText())
                    .fechaNacimiento(dpFechaNacimiento.getValue())
                    .suscripcion(SuscripcionFactory.crearSuscripcion(cbSuscripcion.getValue()))
                    .build();

            getClinicaServicio().registrarPaciente(p);
            lblMensaje.setText("Paciente registrado.");
            limpiarFormulario();
        } catch (ClinicaException e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtDocumento.clear();
        txtCorreo.clear();
        dpFechaNacimiento.setValue(null);
        cbSuscripcion.getSelectionModel().clearSelection();
    }
}
