package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.excepciones.ClinicaException;
import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ClinicaServicio implements Serializable {

    private static ClinicaServicio instancia;

    private final List<Paciente> listaPacientes;
    private final List<Servicio> listaServicios;
    private final List<Cita> listaCitas;

    private ClinicaServicio() {
        this.listaPacientes = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
        inicializarServicios();
    }

    public static ClinicaServicio getInstancia() {
        if (instancia == null) {
            instancia = new ClinicaServicio();
        }
        return instancia;
    }

    private void inicializarServicios() {
        listaServicios.add(new Servicio(null, "Odontología", 100_000));
        listaServicios.add(new Servicio(null, "Medicina General", 80_000));
        listaServicios.add(new Servicio(null, "Pediatría", 90_000));
        listaServicios.add(new Servicio(null, "Dermatología", 120_000));
    }

    public void registrarPaciente(Paciente paciente) throws ClinicaException {
        if (paciente == null || paciente.getDocumento() == null) {
            throw new ClinicaException("Paciente inválido");
        }

        Optional<Paciente> existente = listaPacientes.stream()
                .filter(p -> p.getDocumento().equals(paciente.getDocumento()))
                .findFirst();

        if (existente.isPresent()) {
            throw new ClinicaException("Ya existe un paciente con ese documento");
        }

        listaPacientes.add(paciente);
    }

    public void agendarCita(Cita cita) throws ClinicaException {
        if (cita == null || cita.getPaciente() == null || cita.getServicio() == null || cita.getFechaHora() == null) {
            throw new ClinicaException("Datos de cita inválidos");
        }

        long citasDelMes = listaCitas.stream()
                .filter(c -> c.getPaciente().getDocumento().equals(cita.getPaciente().getDocumento()))
                .filter(c -> c.getFechaHora().getMonth() == cita.getFechaHora().getMonth()
                        && c.getFechaHora().getYear() == cita.getFechaHora().getYear())
                .count();

        int limite = cita.getPaciente().getSuscripcion().getLimiteCitasMensuales();

        if (citasDelMes >= limite) {
            throw new ClinicaException("El paciente ha alcanzado el límite de citas para este mes");
        }

        listaCitas.add(cita);
    }

    public List<Cita> obtenerCitasPorPaciente(String documento) {
        return listaCitas.stream()
                .filter(c -> c.getPaciente().getDocumento().equals(documento))
                .toList();
    }

    public double calcularCostoCita(Cita cita) {
        double costoBase = cita.getServicio().getCostoBase();
        return cita.getPaciente().getSuscripcion().calcularCostoServicio(costoBase);
    }

    public List<Servicio> listarServicios() {
        return listaServicios;
    }

    public Paciente buscarPacientePorDocumento(String documento) throws ClinicaException {
        return listaPacientes.stream()
                .filter(p -> p.getDocumento().equals(documento))
                .findFirst()
                .orElseThrow(() -> new ClinicaException("Paciente no encontrado"));
    }
}
