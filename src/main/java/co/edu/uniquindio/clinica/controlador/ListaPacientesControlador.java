package co.edu.uniquindio.clinica.controlador;

import co.edu.uniquindio.clinica.modelo.Paciente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaPacientesControlador extends ControladorAbstracto {

    @FXML
    private TableView<Paciente> tablaPacientes;
    @FXML private TableColumn<Paciente, String> colDocumento;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, String> colCorreo;
    @FXML private TableColumn<Paciente, String> colSuscripcion;

    @FXML
    public void initialize() {
        colDocumento.setCellValueFactory(cell -> cell.getValue().documentoProperty());
        colNombre.setCellValueFactory(cell -> cell.getValue().nombreProperty());
        colCorreo.setCellValueFactory(cell -> cell.getValue().correoProperty());
        colSuscripcion.setCellValueFactory(cell -> cell.getValue().getSuscripcion().tipoProperty());

        tablaPacientes.setItems(FXCollections.observableList(getClinicaServicio().getListaPacientes()));
    }
}
