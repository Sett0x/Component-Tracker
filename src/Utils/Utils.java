package Utils;

import bbdd.*;
import java.io.File;
import java.sql.PreparedStatement;
import model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Grafica;

public class Utils {

    public static String despedida() {
        String[] mensajesDespedida = {"¡Con Dios!", "La minería ya no renta, estando como está la luz...",
            "Que no te engañen en el Black Friday ese.", "La gráfica que quieres no va a bajar...",
            "Lo que sea, pero una Zotac no..."};
        int indiceMensaje = (int) (Math.random() * mensajesDespedida.length);
        String mensaje = mensajesDespedida[indiceMensaje];
        return mensaje;
    }

    public static Grafica buscarGraficaPorId(int id) throws SQLException {
        Conexion.conectar();
        String sql = "SELECT * FROM graficas WHERE id = " + id;
        ResultSet rs = Conexion.ejecutarSentencia(sql);

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            int vram = rs.getInt("vram");
            String marca = rs.getString("marca");
            String fabricante = rs.getString("fabricante");
            double precio = rs.getDouble("precio");

             Conexion.cerrar();
            return new Grafica(id, nombre, vram, marca, fabricante, precio);
        } else {
             Conexion.cerrar();
            JOptionPane.showMessageDialog(null, "No se encontró ninguna gráfica con el ID especificado.");
            return null; // No se encontró una gráfica con ese ID
        }
    }

    public static void insertarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        try {
            Conexion.conectar();
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
        Conexion.cerrar();

    }

    public static void modificarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        Conexion.conectar();
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
        Conexion.cerrar();
    }

    public static void eliminarGrafica(int id) throws SQLException {
        Conexion.conectar();
        Grafica grafica = buscarGraficaPorId(id);
        if (grafica != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar también el archivo de registro de precios?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM graficas WHERE id = ?";
                try (PreparedStatement stmt = Conexion.preparedStatement(sql)) {
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Gráfica eliminada correctamente.");

                    String nombreArchivo = id + ".txt";
                    File archivo = new File("./src/graficas_registro_precios/" + nombreArchivo);
                    if (archivo.exists() && archivo.isFile()) {
                        if (archivo.delete()) {
                            JOptionPane.showMessageDialog(null, "Archivo de registro de precios borrado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo de registro de precios.");
                        }
                    }
                }
            } else {
                String sql = "DELETE FROM graficas WHERE id = ?";
                try (PreparedStatement stmt = Conexion.preparedStatement(sql)) {
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Gráfica eliminada correctamente.");
                }
            }
        }
        Conexion.cerrar();
    }

    public static void BorrarBBDD() {
        Conexion.conectar();
        String sql = "DELETE FROM graficas";
        try {
            Conexion.ejecutarUpdate(sql);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar también el historial de precios?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                File carpeta = new File("./src/graficas_registro_precios");
                File[] archivos = carpeta.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        archivo.delete();
                    }
                    JOptionPane.showMessageDialog(null, "Historial de precios borrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron archivos en la carpeta.");
                }
            }
            JOptionPane.showMessageDialog(null, "BBDD borrada correctamente.");
        } catch (Exception ex) {
            Logger.getLogger(Utils.class.getSimpleName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al borrar la BBDD. Aguantará un día más.");
        }
        Conexion.cerrar();
    }

}
