package co.edu.poli.examen2_Moreno.tests.unitaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_Moreno.modelo.Casa;
import co.edu.poli.examen2_Moreno.modelo.Inmueble;
import co.edu.poli.examen2_Moreno.modelo.Propietario;

public class TestInmueble {

    @Test
    void constructor_y_getters_funcionan() {

        Propietario propietario = new Propietario(1, "Test");

        Inmueble i = new Casa(123, "2025-12-25", "Activo", propietario, 2);

        assertEquals(123, i.getNumero());
        assertEquals("2025-12-25", i.getFechaCompra());
        assertEquals("Activo", i.getEstado());
        assertEquals(propietario, i.getPropietario());
    }

    @Test
    void setters_modificanValores() {

        Propietario propietario = new Propietario(1, "Test");
        Propietario nuevo = new Propietario(2, "Nuevo");

        Inmueble i = new Casa(123, "2025-12-25", "Activo", propietario, 2);

        i.setNumero(999);
        i.setFechaCompra("2030-01-01");
        i.setEstado("Inactivo");
        i.setPropietario(nuevo);

        assertEquals(999, i.getNumero());
        assertEquals("2030-01-01", i.getFechaCompra());
        assertEquals("Inactivo", i.getEstado());
        assertEquals(nuevo, i.getPropietario());
    }

    @Test
    void toString_contieneDatos() {

        Propietario propietario = new Propietario(1, "Test");

        Inmueble i = new Casa(123, "2025-12-25", "Activo", propietario, 2);

        String texto = i.toString();

        assertTrue(texto.contains("123"));
        assertTrue(texto.contains("2025-12-25"));
        assertTrue(texto.contains("Activo"));
    }
}