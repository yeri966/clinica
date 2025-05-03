package co.edu.uniquindio.clinica.controlador;

import co.edu.uniquindio.clinica.servicios.ClinicaServicio;
import lombok.Getter;

public abstract class ControladorAbstracto {

    @Getter
    private ClinicaServicio clinicaServicio;

    public void inicializarClinica(ClinicaServicio servicio) {
        this.clinicaServicio = servicio;
    }
}
