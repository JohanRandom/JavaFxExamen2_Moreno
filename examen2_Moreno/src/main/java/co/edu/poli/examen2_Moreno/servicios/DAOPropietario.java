package co.edu.poli.examen2_Moreno.servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import co.edu.poli.examen2_Moreno.modelo.Propietario;

public class DAOPropietario {

    private Connection conexion;

    public DAOPropietario() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    public List<Propietario> listar() {
        List<Propietario> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM propietario";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Propietario p = new Propietario(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}