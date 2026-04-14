package co.edu.poli.examen2_Moreno.tests.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_Moreno.modelo.Casa;
import co.edu.poli.examen2_Moreno.modelo.Inmueble;
import co.edu.poli.examen2_Moreno.modelo.Propietario;
import co.edu.poli.examen2_Moreno.servicios.DAOInmueble;

public class TestDAOInmueble {

    DAOInmueble dao = new DAOInmueble();

    @Test
    void crear_y_readone() {

        Propietario propietario = new Propietario(1, "Test");

        int numero = (int)(Math.random() * 100000);

        Casa casa = new Casa(
            numero,
            "2025-12-25",
            "Activo",
            propietario,
            2
        );

        dao.crear(casa);

        Inmueble i = dao.readone(numero);

        assertNotNull(i);
        assertEquals(numero, i.getNumero());
        assertEquals("Activo", i.getEstado());
    }

    @Test
    void readone_noExiste() {

        Inmueble i = dao.readone(123456);

        assertNull(i);
    }
}