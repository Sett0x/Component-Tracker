package bbdd;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbName = "vsgamers_components";
    static String host = "localhost";
    static int port = 3306;
    static String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + timeZone;
    static String user = "root";
    static String pass = "";
    static String driver = "com.mysql.cj.jdbc.Driver";

    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;

    public static void conectar() {
        System.out.println(url);
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Base de datos situada en :\n " + url);
            consulta = conexion.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    // EJECUTAR SENTENCIA
    public static ResultSet ejecutarSentencia(String sentencia) {
        try {
            resultado = consulta.executeQuery(sentencia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error: " + sentencia);
        }
        return resultado;
    }
    // EJECUTAR UPDATE
    public static void ejecutarUpdate(String sentencia) {
        try {
            consulta.executeUpdate(sentencia);
            System.out.println("Done: " + sentencia);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error: " + sentencia);
        }
    }
    
    // FUNCION STATEMENT PARA CARGA DE DATOS
    public static PreparedStatement preparedStatement(String sql) {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        return stmt;
    }

    public static void cerrar() {
        try {
            consulta.close();
        } catch (Exception e) {
        }
    }

}
