package co.edu.uniquindio.clinica.modelo;

import java.io.Serializable;
import java.util.UUID;


public class Servicio implements Serializable {
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private double costoBase;
}
