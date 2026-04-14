package co.edu.poli.examen2_Moreno.controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import co.edu.poli.examen2_Moreno.modelo.Apartamento;
import co.edu.poli.examen2_Moreno.modelo.Casa;
import co.edu.poli.examen2_Moreno.modelo.Inmueble;
import co.edu.poli.examen2_Moreno.modelo.Propietario;
import co.edu.poli.examen2_Moreno.servicios.DAOInmueble;
import co.edu.poli.examen2_Moreno.servicios.DAOPropietario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControlFormCard {

    @FXML
    private TextField txtNumeroConsulta;

    @FXML
    private TextField txtNumeroCrear;

    @FXML
    private TextArea txtAreaResultado;

    @FXML
    private DatePicker datepk1;

    @FXML
    private ComboBox<Propietario> cmbPropietario;

    @FXML
    private RadioButton radioCasa;

    @FXML
    private RadioButton radioApartamento;

    @FXML
    private ToggleGroup tipo;

    private DAOInmueble daoInmueble;
    private DAOPropietario daoPropietario;

    @FXML
    private void initialize() {
        daoInmueble = new DAOInmueble();
        daoPropietario = new DAOPropietario();

        datepk1.setValue(LocalDate.now());

        try {
            List<Propietario> lista = daoPropietario.listar();
            cmbPropietario.getItems().setAll(lista);
        } catch (Exception e) {
            mostrarAlerta(e.getMessage());
        }
    }

    @FXML
    private void pressConsulta(ActionEvent event) {
        txtAreaResultado.setText("");

        if (!txtNumeroConsulta.getText().isEmpty()) {
            try {
                int numero = Integer.parseInt(txtNumeroConsulta.getText());

                Inmueble i = daoInmueble.readone(numero);

                if (i != null)
                    txtAreaResultado.setText(i.toString());
                else
                    mostrarAlerta("No existe el inmueble");

            } catch (Exception e) {
                mostrarAlerta(e.getMessage());
            }
        } else {
            mostrarAlerta("Ingrese número");
        }
    }

    @FXML
    private void pressCreacion(ActionEvent event) {

        String numTxt = txtNumeroCrear.getText().trim();
        if (numTxt.isEmpty()) {
            mostrarAlerta("Ingrese número");
            return;
        }

        int numero = Integer.parseInt(numTxt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = datepk1.getValue().format(formatter);

        Propietario propietario = cmbPropietario.getValue();
        if (propietario == null) {
            mostrarAlerta("Seleccione propietario");
            return;
        }

        Inmueble nuevo;

        if (radioCasa.isSelected()) {
            nuevo = new Casa(numero, fecha, "Activo", propietario, 2);
        } else {
            nuevo = new Apartamento(numero, fecha, "Activo", propietario, 3);
        }

        try {
            daoInmueble.crear(nuevo);
            mostrarAlerta("Inmueble creado correctamente");
            limpiarFormCrear();
        } catch (Exception e) {
            mostrarAlerta(e.getMessage());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarFormCrear() {
        txtNumeroCrear.clear();
        datepk1.setValue(LocalDate.now());
        cmbPropietario.setValue(null);
        radioCasa.setSelected(true);
    }
}