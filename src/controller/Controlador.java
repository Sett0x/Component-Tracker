package controller;
import bbdd.*;
import static bbdd.Scraper.graficas;
import java.sql.SQLException;
public class Controlador {
    
    public static void Scan() throws SQLException{
        Scraper.scrape();
    }
    
    public static void Update() throws SQLException{
        Scraper.updateGraficas(graficas);
    }
}
