package co.edu.uniquindio.clinica.patrones.factory;

import co.edu.uniquindio.clinica.modelo.Basica;
import co.edu.uniquindio.clinica.modelo.Premium;
import co.edu.uniquindio.clinica.modelo.Suscripcion;

public class SuscripcionFactory {

    public static Suscripcion crearSuscripcion(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "basica" -> new Basica();
            case "premium" -> new Premium();
            default -> throw new IllegalArgumentException("Tipo de suscripción no válido: " + tipo);
        };
    }
}
