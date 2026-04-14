package co.edu.poli.examen2_Moreno.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import co.edu.poli.examen2_Moreno.modelo.Inmueble;
import co.edu.poli.examen2_Moreno.modelo.Propietario;
import co.edu.poli.examen2_Moreno.modelo.Casa;

public class DAOInmueble {

    private Connection conexion;

    public DAOInmueble() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    public void crear(Inmueble inmueble) {

        try {
            String sql = "INSERT INTO inmueble (numero, fecha_compra, estado, propietario_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, inmueble.getNumero());
            ps.setString(2, inmueble.getFechaCompra());
            ps.setString(3, inmueble.getEstado());
            ps.setInt(4, inmueble.getPropietario().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Inmueble readone(int numero) {

        Inmueble inmueble = null;

        try {
            String sql = "SELECT * FROM inmueble WHERE numero = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int num = rs.getInt("numero");
                String fecha = rs.getString("fecha_compra");
                String estado = rs.getString("estado");
                int propietarioId = rs.getInt("propietario_id");

                // Crear propietario (solo con ID por ahora)
                Propietario propietario = new Propietario(propietarioId, ""); 

                // ⚠️ Aquí usamos Casa por defecto (simplificación)
                inmueble = new Casa(num, fecha, estado, propietario, 1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inmueble;
    }
}
