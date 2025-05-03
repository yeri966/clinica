package co.edu.uniquindio.clinica.modelo;


public class Premium extends Suscripcion {

    public Premium() {
        this.tipo = "Premium";
    }

    @Override
    public int getLimiteCitasMensuales() {
        return 10;
    }

    @Override
    public double calcularCostoServicio(double costoBase) {
        return costoBase;
    }
}
