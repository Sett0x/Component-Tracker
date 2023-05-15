package controller;

import java.sql.*;
import model.*;
import bbdd.*;
import static model.Scraper.graficas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    public static void Conectar() throws SQLException {
        Conexion.conectar();
    }

    public static ResultSet Sentencia(String sent) throws SQLException {
        return Conexion.ejecutarSentencia(sent);
    }

    public static void CUpate(String sent) throws SQLException {
        Conexion.ejecutarUpdate(sent);
    }

    public static void Scan() throws SQLException {
        Scraper.scrape();
    }

    public static void Update() throws SQLException {
        Scraper.updateGraficas(graficas);
    }

    public static void registrar(Grafica item) throws SQLException {

        Conectar();

        String sql = "INSERT INTO graficas (id, nombre, vram, marca, fabricante, precio) VALUES (?, ?, ?, ?, ?, ?)";

        Sentencia(sql);
    }

    public static void modificar(Grafica item) throws SQLException {

        Conectar();

        String sql = "UPDATE graficas SET nombre=? vram=? marca=? fabricante=? precio=? WHERE id=?";

        Controlador.CUpate(sql);
    }

    public static void eliminar(Grafica item) throws SQLException {

        Conectar();

        String sql = "DELETE FROM graficas WHERE id=?";

        Sentencia(sql);
    }

    public static Grafica buscarGraficaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM graficas WHERE id = " + id;
        ResultSet rs = Sentencia(sql);

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            int vram = rs.getInt("vram");
            String marca = rs.getString("marca");
            String fabricante = rs.getString("fabricante");
            double precio = rs.getDouble("precio");

            return new Grafica(id, nombre, vram, marca, fabricante, precio);
        } else {
            return null; // No se encontró una gráfica con ese ID
        }
    }

    public static void modificarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        Conectar();
        Grafica grafica = buscarGraficaPorId(id);
        if (grafica != null) {
            String sql = "UPDATE graficas SET nombre = ?, vram = ?, marca = ?, fabricante = ?, precio = ? WHERE id = ?";
            PreparedStatement stmt = Conexion.preparedStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, vram);
            stmt.setString(3, marca);
            stmt.setString(4, fabricante);
            stmt.setDouble(5, precio);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gráfica modificada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una gráfica con el ID proporcionado.");
        }
    }
}
