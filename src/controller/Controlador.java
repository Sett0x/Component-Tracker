package controller;

import java.sql.*;
import model.*;
import bbdd.*;
import java.io.File;
import java.io.IOException;
import static model.Scraper.graficas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static model.Scraper.*;
import view.vista;

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
    public static void CUpdate(String sent) throws SQLException {
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

    // BORRAR BBDD
    public static void BorrarBBDD() {
        String sql = ("DELETE FROM graficas");
        try {
            Controlador.CUpdate(sql);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar también el historial de precios?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                File carpeta = new File("./src/graficas_registro_precios");
                File[] archivos = carpeta.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        archivo.delete();
                    }
                }
                if (carpeta.delete()) {
                    JOptionPane.showMessageDialog(null, "Historial de precios borrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo borrar la carpeta.");
                }
            }
            JOptionPane.showMessageDialog(null, "BBDD borrada correctamente.");

        } catch (SQLException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al borrar la BBDD. Aguantará un día más.");
        }
    }

    public static String despedida() {
        String[] mensajesDespedida = {"¡Con Dios!", "La minería ya no renta, estando como está la luz...",
            "Que no te engañen en el Black Friday ese.", "La gráfica que quieres no va a bajar...",
            "Lo que sea, pero una Zotac no..."};
        int indiceMensaje = (int) (Math.random() * mensajesDespedida.length);
        String mensaje = mensajesDespedida[indiceMensaje];
        return mensaje;
    }

    public static String filtroVRAM(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY vram ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY vram DESC";
                break;
            case "2GB":
                sql = "SELECT * FROM graficas WHERE vram = '2'";
                break;
            case "4GB":
                sql = "SELECT * FROM graficas WHERE vram = '4'";
                break;
            case "6GB":
                sql = "SELECT * FROM graficas WHERE vram = '6'";
                break;
            case "8GB":
                sql = "SELECT * FROM graficas WHERE vram = '8'";
                break;
            case "10GB":
                sql = "SELECT * FROM graficas WHERE vram = '10'";
                break;
            case "12GB":
                sql = "SELECT * FROM graficas WHERE vram = '12'";
                break;
            case "16GB":
                sql = "SELECT * FROM graficas WHERE vram = '16'";
                break;
            case "20GB":
                sql = "SELECT * FROM graficas WHERE vram = '20'";
                break;
            case "24GB":
                sql = "SELECT * FROM graficas WHERE vram = '24'";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroFabricante(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Nvidia":
                sql = "SELECT * FROM graficas WHERE fabricante = 'Nvidia'";
                break;
            case "AMD":
                sql = "SELECT * FROM graficas WHERE fabricante = 'AMD'";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroPrecio(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY precio ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY precio DESC";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroMarca(String ordenSeleccionado) {
        String sql = "";
        switch (ordenSeleccionado) {
            case "Asrock":
                sql = "SELECT * FROM graficas WHERE marca = 'ASROCK'";
                break;
            case "Asus":
                sql = "SELECT * FROM graficas WHERE marca = 'ASUS'";
                break;
            case "Gigabyte":
                sql = "SELECT * FROM graficas WHERE marca = 'GIGABYTE'";
                break;
            case "MSI":
                sql = "SELECT * FROM graficas WHERE marca = 'MSI'";
                break;
            case "Palit":
                sql = "SELECT * FROM graficas WHERE marca = 'PALIT'";
                break;
            case "PNY":
                sql = "SELECT * FROM graficas WHERE marca = 'PNY'";
                break;
            case "Zotac":
                sql = "SELECT * FROM graficas WHERE marca = 'ZOTAC'";
                break;
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY marca ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY marca DESC";
                break;
            default:
                break;
        }
        return sql;
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
            String idString = Integer.toString(id);
            Scraper.guardarPrecio(idString, nombre, precio);
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
