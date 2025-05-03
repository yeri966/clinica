package co.edu.uniquindio.clinica.patrones.builder;


import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Suscripcion;

import java.time.LocalDate;

public class PacienteBuilder {

    private String nombre;
    private String documento;
    private String correo;
    private LocalDate fechaNacimiento;
    private Suscripcion suscripcion;

    public PacienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PacienteBuilder documento(String documento) {
        this.documento = documento;
        return this;
    }

    public PacienteBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public PacienteBuilder fechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public PacienteBuilder suscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
        return this;
    }

    public Paciente build() {
        return new Paciente(null, nombre, documento, correo, fechaNacimiento, suscripcion);
    }
}
