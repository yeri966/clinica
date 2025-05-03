package co.edu.uniquindio.clinica.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita implements Serializable {
    private String id = UUID.randomUUID().toString();
    private Paciente paciente;
    private Servicio servicio;
    private LocalDateTime fechaHora;
}
