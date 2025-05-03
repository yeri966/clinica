package co.edu.uniquindio.clinica.controlador;


import co.edu.uniquindio.clinica.modelo.Cita;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;

public class ListaCitasControlador extends ControladorAbstracto {

    @FXML
    private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colPaciente;
    @FXML private TableColumn<Cita, String> colServicio;
    @FXML private TableColumn<Cita, LocalDateTime> colFechaHora;

    @FXML
    public void initialize() {
        colPaciente.setCellValueFactory(cell -> cell.getValue().getPaciente().nombreProperty());
        colServicio.setCellValueFactory(cell -> cell.getValue().getServicio().nombreProperty());
        colFechaHora.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getFechaHora()));

        tablaCitas.setItems(FXCollections.observableList(getClinicaServicio().getListaCitas()));
    }
}
