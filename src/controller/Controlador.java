package controller;


import java.sql.*;
import model.*;
import bbdd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static model.Scraper.graficas;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{

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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
