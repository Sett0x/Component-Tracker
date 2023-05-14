package main;
import bbdd.*;
import controller.*;
import view.*;
import model.*;
import java.sql.SQLException;


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
