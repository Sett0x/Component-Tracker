package model;



import controller.Controlador;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProductos  {

    public boolean registrar(Grafica item) throws SQLException {

        Controlador.Conectar();

        String sql = "INSERT INTO graficas (id, nombre, vram, marca, fabricante, precio) VALUES (?, ?, ?, ?, ?, ?)";
        
        Controlador.Sentencia(sql);
        

        return true;

    }

    public boolean modificar(Grafica item) throws SQLException {

        Controlador.Conectar();

        String sql = "UPDATE graficas SET nombre=? vram=? marca=? fabricante=? precio=? WHERE id=?";

        Controlador.CUpate(sql);

        return true;

    }

    public boolean eliminar(Grafica item) throws SQLException {

        Controlador.Conectar();

        String sql = "DELETE FROM graficas WHERE id=?";

        ResultSet rs = Controlador.Sentencia(sql);

        return true;

    }
    
    public boolean buscar(Grafica item) throws SQLException {

        Controlador.Conectar();

        String sql = "SELECT * FROM graficas WHERE id=?";

        ResultSet rs = Controlador.Sentencia(sql);

        return true;

    }
}
