package controller;
import model.*;
import static model.Scraper.graficas;
import java.sql.SQLException;
public class Controlador {
    
    public static void Scan() throws SQLException{
        Scraper.scrape();
    }
    
    public static void Update() throws SQLException{
        Scraper.updateGraficas(graficas);
    }
}
