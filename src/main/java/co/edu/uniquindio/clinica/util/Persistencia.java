package co.edu.uniquindio.clinica.util;

import co.edu.uniquindio.clinica.servicios.ClinicaServicio;

import java.io.*;

public class Persistencia {

    private static final String RUTA_ARCHIVO = "clinica.dat";

    /**
     * Guarda el estado actual del servicio (pacientes, citas, servicios) en un archivo binario.
     */
    public static void guardarDatos(ClinicaServicio clinica) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(clinica);
        }
    }

    /**
     * Carga los datos desde el archivo binario, si existe. Si no, retorna una nueva instancia.
     */
    public static ClinicaServicio cargarDatos() throws IOException, ClassNotFoundException {
        File archivo = new File(RUTA_ARCHIVO);

        if (!archivo.exists()) {
            return ClinicaServicio.getInstancia(); // Si el archivo no existe, retorna nueva instancia
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ClinicaServicio) ois.readObject();
        }
    }
}
