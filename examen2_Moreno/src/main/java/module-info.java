module co.edu.poli.examen2_Moreno {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires io.github.cdimascio.dotenv.java;

    opens co.edu.poli.examen2_Moreno.vista to javafx.fxml, javafx.graphics;
    opens co.edu.poli.examen2_Moreno.controlador to javafx.fxml;
    exports co.edu.poli.examen2_Moreno.controlador;
    
}
