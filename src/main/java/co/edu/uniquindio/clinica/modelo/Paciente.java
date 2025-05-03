package co.edu.uniquindio.clinica.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private String documento;
    private String correo;
    private LocalDate fechaNacimiento;
    private Suscripcion suscripcion;
}
