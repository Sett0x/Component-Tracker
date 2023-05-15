package controller;


import java.sql.*;
import model.*;
import bbdd.*;
import static model.Scraper.graficas;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Controlador {

    public static void Conectar() throws SQLException {
        Conexion.conectar();
    }

    public static ResultSet Sentencia(String sent) throws SQLException {
        return Conexion.ejecutarSentencia(sent);
    }

    public static DefaultTableModel obtenerDatosTabla() {
        try {
            Conectar();
            ResultSet rs = Sentencia("SELECT * FROM graficas");
            ResultSetMetaData rsMd = rs.getMetaData();

            // Crear modelo de tabla
            DefaultTableModel modelo = new DefaultTableModel();

            // Agregar las columnas al modelo
            int columnas = rsMd.getColumnCount();
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(rsMd.getColumnName(i).toUpperCase());
            }

            // Agregar las filas al modelo
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }

            return modelo;

        } catch (SQLException ex) {
        } finally {
            Conexion.cerrar();
        }
        return null;
    }

    public static void Scan() throws SQLException {
        Scraper.scrape();
    }

    public static void Update() throws SQLException {
        Scraper.updateGraficas(graficas);
    }
}
