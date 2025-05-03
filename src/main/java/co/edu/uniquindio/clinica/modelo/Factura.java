package co.edu.uniquindio.clinica.modelo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Factura {
    private String idFactura;
    private LocalDate fechaEmision;
    private double total;
}
