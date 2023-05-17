package controller;

import java.sql.*;
import model.*;
import bbdd.*;
import java.io.IOException;
import static model.Scraper.graficas;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static model.Scraper.*;

public class Controlador {
    // CONECTAR A LA BBDD
    public static void Conectar() throws SQLException {
        Conexion.conectar();
    }
    // DESCONECTAR DE LA BBDD
    public static void Desconectar() throws SQLException {
        Conexion.cerrar();
    }
    // SENTENCIA A LA BBDD
    public static ResultSet Sentencia(String sent) throws SQLException {
        return Conexion.ejecutarSentencia(sent);
    }
    // UPDATE A LA BBDD
    public static void CUpate(String sent) throws SQLException {
        Conexion.ejecutarUpdate(sent);
    }
    // EJECUCION DE SCRAPE
    public static void Scan() throws SQLException {
        Scraper.scrape();
    }
    // UPDATE DE GRAFICAS
    public static void Update() throws SQLException {
        Scraper.updateGraficas(graficas);
    }
    // FUNCION PARA BUSCAR GRAFICA POR ID EN LA BBDD
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
            JOptionPane.showMessageDialog(null, "No se encontró ninguna gráfica con el ID especificado.");
            return null; // No se encontró una gráfica con ese ID
        }
    }
    // FUNCION PARA INSERTAR GRAFICA EN LA BBDD
    public static void insertarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        try {
            Conectar();
            String sql = "INSERT INTO graficas (id, nombre, vram, marca, fabricante, precio) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = Conexion.preparedStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setInt(3, vram);
            stmt.setString(4, marca);
            stmt.setString(5, fabricante);
            stmt.setDouble(6, precio);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gráfica registrada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar la gráfica: " + ex.getMessage());
        }

    }
    // FUNCION PARA MODIFICAR GRAFICA EN LA BBDD
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
    // FUNCION PARA ELIMINAR GRAFICA EN LA BBDD
    public static void eliminarGrafica(int id) throws SQLException {
        Conectar();
        Grafica grafica = buscarGraficaPorId(id);
        if (grafica != null) {
            String sql = "DELETE FROM graficas WHERE id = ?";
            PreparedStatement stmt = Conexion.preparedStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Gráfica eliminada correctamente.");
        } 
            
        
    }
    // FUNCION PARA MOSTRAR EL HISTORIAL DE PRECIOS
    public static String obtenerHistorialPrecios(int idGrafica) throws IOException {
    return leerHistorialPrecios(idGrafica);
}


}
