package co.edu.uniquindio.clinica.modelo;


import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class Suscripcion implements Serializable {
    protected String tipo;

    public abstract int getLimiteCitasMensuales();

    public abstract double calcularCostoServicio(double costoBase);
}
