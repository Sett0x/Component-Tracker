package main;
import java.sql.SQLException;
import bbdd.*;

public class Main {

    public static void main(String[] args) {

        Conexion.conectar();
        try {
            Scraper scraper = new Scraper();
            scraper.scrape();
            //scraper.VerDatos();
            Scraper.insertGraficas(Scraper.graficas);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
