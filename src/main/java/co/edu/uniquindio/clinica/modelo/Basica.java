package co.edu.uniquindio.clinica.modelo;

public class Basica extends Suscripcion {

    public Basica() {
        this.tipo = "Básica";
    }

    @Override
    public int getLimiteCitasMensuales() {
        return 3;
    }

    @Override
    public double calcularCostoServicio(double costoBase) {
        return costoBase * 1.1;
    }
}