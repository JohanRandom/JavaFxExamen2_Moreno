package co.edu.poli.examen2_Moreno.tests.integracion;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_Moreno.modelo.Propietario;
import co.edu.poli.examen2_Moreno.servicios.DAOPropietario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestDAOPropietario {

    @Test
    void listar_noDebeRetornarNull() {
        DAOPropietario dao = new DAOPropietario();

        List<Propietario> lista = dao.listar();

        assertNotNull(lista);
    }

    @Test
    void listar_listaInicializada() {
        DAOPropietario dao = new DAOPropietario();

        List<Propietario> lista = dao.listar();

        assertTrue(lista.size() >= 0);
    }

    @Test
    void listar_objetosValidos() {
        DAOPropietario dao = new DAOPropietario();

        List<Propietario> lista = dao.listar();

        if (!lista.isEmpty()) {
            Propietario p = lista.get(0);

            assertNotNull(p.getNombre());
        }
    }
}