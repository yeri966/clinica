module co.edu.uniquindio.clinica {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires com.sanctionco.jmail;
    requires org.simplejavamail;
    requires org.simplejavamail.core;


    opens co.edu.uniquindio.clinica to javafx.fxml;
    exports co.edu.uniquindio.clinica;
    exports co.edu.uniquindio.clinica.controlador;
    opens co.edu.uniquindio.clinica.controlador to javafx.fxml;
}