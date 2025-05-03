package co.edu.uniquindio.clinica.controlador;

import co.edu.uniquindio.clinica.excepciones.ClinicaException;
import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class RegistroCitaControlador extends ControladorAbstracto {

    @FXML private ComboBox<Paciente> cbPaciente;
    @FXML private ComboBox<Servicio> cbServicio;
    @FXML private DatePicker dpFecha;
    @FXML private TextField tfHora; // formato HH:mm
    @FXML private Label lblMensaje;

    @FXML
    public void initialize() {
        cbPaciente.setItems(FXCollections.observableList(getClinicaServicio().getListaPacientes()));
        cbServicio.setItems(FXCollections.observableList(getClinicaServicio().getListaServicios()));
    }

    @FXML
    public void agendarCita() {
        try {
            LocalDateTime fechaHora = LocalDateTime.of(
                    dpFecha.getValue(),
                    LocalTime.parse(tfHora.getText())
            );
            Cita cita = new Cita(null, cbPaciente.getValue(), cbServicio.getValue(), fechaHora);
            getClinicaServicio().agendarCita(cita);
            lblMensaje.setText("Cita agendada.");
        } catch (ClinicaException | DateTimeParseException e) {
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }
}

