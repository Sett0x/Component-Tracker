package model;

import bbdd.Conexion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Scraper {

    public static ArrayList<Grafica> graficas = new ArrayList<>();

    // OBTENCION DE DATOS MEDIANTE SCRAPE
    public static void scrape() throws SQLException {
        try {

            /*
             * INTENTOS DE SCRAPE FALLIDOS:
             * 
             * 
             * Amazon: https://www.amazon.es/s?rh=n%3A937935031&fs=true&ref=lp_937935031_sar
             * 
             * - Clases y selectores autogenerados (no se consigue seguimiento, de la totalidad de las graficas,
             *   se llega a trackear distinta cantidad o distintos precios, por que a media tabla las clases que se usan cambian.
             * 
             * PcComponentes: https://www.pccomponentes.com/tarjetas-graficas
             * 
             * - CAPTCHA indetectable con xpath o selector (imagen).
             * 
             * Coolmod: https://www.coolmod.com/tarjetas-graficas/
             * 
             * - Funciona con JavaScript pero no con java, (clase utilizada para trackear los datos desaparece en java).
             * 
             */
            String url = "https://www.vsgamers.es/category/componentes/tarjetas-graficas/6"; // URL
            Document document = Jsoup.connect(url).get();

            Elements elements = document.select(".vs-product-card");

            //int num = 1;
            for (Element element : elements) {
                String grafica_nombre = element.select("a").text().trim().split("Tarjetas")[0].replace("™", "").replace("®", "");

                String grafica_id = element.attr("data-id");

                //int grafica_id = Integer.parseInt(id);
                String precio = element.select(".vs-product-card-prices > span:first-child").text().trim().split(" ")[0].replace(".", "").replace(",", ".");

                Float grafica_precio = Float.parseFloat(precio);

                String grafica_fabricante = Fabricante(grafica_nombre);

                String grafica_marca = Marca(grafica_nombre);

                int grafica_vram = VRAM(grafica_nombre);

                Grafica grafica = new Grafica(grafica_id, grafica_nombre, grafica_vram, grafica_marca, grafica_fabricante, grafica_precio);
                graficas.add(grafica);

                /* 
                 System.out.print("Gráfica "+ num+ ": "); 
                 System.out.print("ID: "+ grafica_id);
                 System.out.print(" | ");
                  //COMPROBAR FABRICANTE
                 System.out.print(Fabricante(grafica_nombre));
                 System.out.print(" | ");

                  //COMPROBAR MARCA
                  System.out.print(Marca(grafica_nombre));
                 System.out.print(" | ");

                  //COMPROBAR VRAM
                  System.out.print(VRAM(grafica_nombre));

                 System.out.print(" | ");
                 System.out.print("Grafica: "+ grafica_nombre);
                 System.out.print(" | ");
                 System.out.print("Precio: "+ grafica_precio);
                 System.out.println("\n");
                
                 num++;
                 */
                guardarPrecio(grafica_id, grafica_nombre, grafica_precio);
                insertGraficas(graficas);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Scaneo Completado");
    }

    // VER CONTENIDO EN EL ARRAYLIST
    public void VerDatos() {
        for (int i = 0; i < graficas.size(); i++) {
            Grafica curr = graficas.get(i);
            System.out.print(i + 1 + " ");
            System.out.println(curr);
        }
    }

    // OBTENCION DE FABRICANTE
    private static String Fabricante(String grafica_nombre) {
        String fabricante = "";
        //System.out.print("Fabricante: ");
        if (grafica_nombre.toLowerCase().contains("nvidia") || grafica_nombre.toLowerCase().contains("geforce")
                || grafica_nombre.toLowerCase().contains("rtx") || grafica_nombre.toLowerCase().contains("gt") || grafica_nombre.toLowerCase().contains("gtx")) {
            fabricante = "Nvidia";

        } else if (grafica_nombre.contains("Radeon")) {
            fabricante = "AMD";

        }

        return fabricante;
    }

    // OBTENCION DE MARCA
    private static String Marca(String grafica_nombre) {
        String marca = "";
        //System.out.print("Marca / Ensamblador: ");
        if (grafica_nombre.toLowerCase().contains("asus")) {
            marca = "ASUS";

        } else if (grafica_nombre.toLowerCase().contains("rog")) {
            marca = "ROG";

        } else if (grafica_nombre.toLowerCase().contains("msi")) {
            marca = "MSI";

        } else if (grafica_nombre.toLowerCase().contains("zotac")) {
            marca = "ZOTAC";

        } else if (grafica_nombre.toLowerCase().contains("gigabyte")) {
            marca = "GIGABYTE";

        } else if (grafica_nombre.toLowerCase().contains("asrock")) {
            marca = "ASROCK";

        } else if (grafica_nombre.toLowerCase().contains("evga")) {
            marca = "EVGA";

        } else if (grafica_nombre.toLowerCase().contains("pny")) {
            marca = "PNY";
            ;
        } else if (grafica_nombre.toLowerCase().contains("palit")) {
            marca = "PALIT";

        }
        return marca;
    }

    // OBTENCION DE VRAM
    private static int VRAM(String grafica_nombre) {
        int vram = 0;
        //System.out.print("VRAM (GB): ");
        if (grafica_nombre.toLowerCase().contains("24gb") || grafica_nombre.toLowerCase().contains("24 gb")
                || grafica_nombre.toLowerCase().contains("24g") || grafica_nombre.toLowerCase().contains("24 g")) {
            vram = 24;

        } else if (grafica_nombre.toLowerCase().contains("20gb") || grafica_nombre.toLowerCase().contains("20 gb")
                || grafica_nombre.toLowerCase().contains("20g") || grafica_nombre.toLowerCase().contains("20 g")) {
            vram = 20;

        } else if (grafica_nombre.toLowerCase().contains("16gb") || grafica_nombre.toLowerCase().contains("16 gb")
                || grafica_nombre.toLowerCase().contains("16g") || grafica_nombre.toLowerCase().contains("16 g")
                || grafica_nombre.toLowerCase().contains("6800")) {
            vram = 16;

        } else if (grafica_nombre.toLowerCase().contains("12gb") || grafica_nombre.toLowerCase().contains("12 gb")
                || grafica_nombre.toLowerCase().contains("12g") || grafica_nombre.toLowerCase().contains("12 g")) {
            vram = 12;

        } else if (grafica_nombre.toLowerCase().contains("10gb") || grafica_nombre.toLowerCase().contains("10 gb")
                || grafica_nombre.toLowerCase().contains("10g") || grafica_nombre.toLowerCase().contains("10 g")) {
            vram = 10;

        } else if (grafica_nombre.toLowerCase().contains("8gb") || grafica_nombre.toLowerCase().contains("8 gb")
                || grafica_nombre.toLowerCase().contains("8g") || grafica_nombre.toLowerCase().contains("8 g")) {
            vram = 8;

        } else if (grafica_nombre.toLowerCase().contains("6gb") || grafica_nombre.toLowerCase().contains("6 gb")
                || grafica_nombre.toLowerCase().contains("6g") || grafica_nombre.toLowerCase().contains("6 g")) {
            vram = 6;

        } else if (grafica_nombre.toLowerCase().contains("4gb") || grafica_nombre.toLowerCase().contains("4 gb")
                || grafica_nombre.toLowerCase().contains("4g") || grafica_nombre.toLowerCase().contains("4 g")) {
            vram = 4;

        } else if (grafica_nombre.toLowerCase().contains("2gb") || grafica_nombre.toLowerCase().contains("2 gb")
                || grafica_nombre.toLowerCase().contains("2g") || grafica_nombre.toLowerCase().contains("2 g")) {
            vram = 2;

        }
        return vram;
    }
    
    public ArrayList<Grafica> getGraficas() {
        return graficas;
    }
    // CARGA DE LOS DATOS EN LA BBDD
    public static void insertGraficas(List<Grafica> graficas) throws SQLException {
        Conexion.conectar();
        for (Grafica grafica : graficas) {
            String id = grafica.getId();
            String sql = "SELECT id FROM graficas WHERE id = '" + id + "'";
            ResultSet rs = Conexion.ejecutarSentencia(sql);

            if (!rs.next()) {

                sql = "INSERT INTO graficas (id, nombre, vram, marca, fabricante, precio) VALUES ("
                        + grafica.getId() + ", \""
                        + grafica.getNombre() + "\", \""
                        + grafica.getVram() + "\", \""
                        + grafica.getMarca() + "\", \""
                        + grafica.getFabricante() + "\", "
                        + grafica.getPrecio()
                        + ")";
                Conexion.ejecutarSentencia(sql);
            }
        }

    }

    // UPDATE DE LOS DATOS EN LA BBDD
    public static void updateGraficas(List<Grafica> graficas) throws SQLException {
        Conexion.conectar();
        for (Grafica grafica : graficas) {
            String id = grafica.getId();
            float precio = grafica.getPrecio();

            String sql = "UPDATE graficas SET precio = " + precio + " WHERE id = " + id;

            Conexion.ejecutarUpdate(sql);
        }
        JOptionPane.showMessageDialog(null, "Actualización Completada");

    }

    

    public static void guardarPrecio(String id, String nombreGrafica, float precioAnterior) {
        try {
            // Crear el objeto File con la ruta y nombre del archivo
            File file = new File("./src/files/"+ id + ".txt");

            // Crear el archivo si no existe
            if (!file.exists()) {
                file.createNewFile();
            }

            // Obtener la fecha y hora actual
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaHora = formatoFecha.format(fechaActual);

            // Escribir el precio anterior y la fecha en el archivo
            FileWriter writer = new FileWriter(file, true);
            
            writer.write(fechaHora + "\t" + precioAnterior + "€\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static List<String> leerHistorialPrecios(String idGrafica) throws IOException {
        List<String> historialPrecios = new ArrayList<>();
        String nombreArchivo = "./src/files/" + idGrafica + ".txt";
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            try (Scanner scanner = new Scanner(archivo)) {
                while (scanner.hasNextLine()) {
                    historialPrecios.add(scanner.nextLine());
                }
            }
        }
        return historialPrecios;
    }

    
    
    public static void mostrarDatos() {
        Conexion.conectar();
        String sql = "SELECT * FROM graficas";
        Conexion.ejecutarUpdate(sql);
}

}
