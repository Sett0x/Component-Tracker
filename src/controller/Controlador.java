package controller;

import java.sql.*;
import Utils.*;
import model.*;
import bbdd.*;
import java.io.IOException;
import static model.Scraper.graficas;
import java.sql.SQLException;
import static model.Scraper.*;

public class Controlador {

    // CONECTAR A LA BBDD
    public static void Conectar() throws SQLException {
        Conexion.conectar();
    }

    // DESCONECTAR DE LA BBDD
    public static void Desconectar() throws SQLException {
        Conexion.cerrar();
    }

    // SENTENCIA A LA BBDD
    public static ResultSet Sentencia(String sent) throws SQLException {
        return Conexion.ejecutarSentencia(sent);
    }

    // UPDATE A LA BBDD
    public static void CUpdate(String sent) throws SQLException {
        Conexion.ejecutarUpdate(sent);
    }

    // EJECUCION DE SCRAPE
    public static void Scan() throws SQLException {
        Scraper.scrape();
    }

    // UPDATE DE GRAFICAS
    public static void Update() throws SQLException {
        Scraper.updateGraficas(graficas);
    }

    // BORRAR BBDD
    public static void BorrarBBDD() {
        Utils.BorrarBBDD();
    }

    public static String despedida() {
        String mensaje = Utils.despedida();
        return mensaje;
    }

    public static String filtroVRAM(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY vram ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY vram DESC";
                break;
            case "2GB":
                sql = "SELECT * FROM graficas WHERE vram = '2'";
                break;
            case "4GB":
                sql = "SELECT * FROM graficas WHERE vram = '4'";
                break;
            case "6GB":
                sql = "SELECT * FROM graficas WHERE vram = '6'";
                break;
            case "8GB":
                sql = "SELECT * FROM graficas WHERE vram = '8'";
                break;
            case "10GB":
                sql = "SELECT * FROM graficas WHERE vram = '10'";
                break;
            case "12GB":
                sql = "SELECT * FROM graficas WHERE vram = '12'";
                break;
            case "16GB":
                sql = "SELECT * FROM graficas WHERE vram = '16'";
                break;
            case "20GB":
                sql = "SELECT * FROM graficas WHERE vram = '20'";
                break;
            case "24GB":
                sql = "SELECT * FROM graficas WHERE vram = '24'";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroFabricante(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Nvidia":
                sql = "SELECT * FROM graficas WHERE fabricante = 'Nvidia'";
                break;
            case "AMD":
                sql = "SELECT * FROM graficas WHERE fabricante = 'AMD'";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroPrecio(String ordenSeleccionado) {
        String sql = "";

        switch (ordenSeleccionado) {
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY precio ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY precio DESC";
                break;
            default:
                break;
        }
        return sql;
    }

    public static String filtroMarca(String ordenSeleccionado) {
        String sql = "";
        switch (ordenSeleccionado) {
            case "Asrock":
                sql = "SELECT * FROM graficas WHERE marca = 'ASROCK'";
                break;
            case "Asus":
                sql = "SELECT * FROM graficas WHERE marca = 'ASUS'";
                break;
            case "Gigabyte":
                sql = "SELECT * FROM graficas WHERE marca = 'GIGABYTE'";
                break;
            case "MSI":
                sql = "SELECT * FROM graficas WHERE marca = 'MSI'";
                break;
            case "Palit":
                sql = "SELECT * FROM graficas WHERE marca = 'PALIT'";
                break;
            case "PNY":
                sql = "SELECT * FROM graficas WHERE marca = 'PNY'";
                break;
            case "Zotac":
                sql = "SELECT * FROM graficas WHERE marca = 'ZOTAC'";
                break;
            case "Ascendente":
                sql = "SELECT * FROM graficas ORDER BY marca ASC";
                break;
            case "Descendente":
                sql = "SELECT * FROM graficas ORDER BY marca DESC";
                break;
            default:
                break;
        }
        return sql;
    }

    // FUNCION PARA BUSCAR GRAFICA POR ID EN LA BBDD
    public static Grafica buscarGraficaPorId(int id) throws SQLException {
        return Utils.buscarGraficaPorId(id);

    }

    // FUNCION PARA INSERTAR GRAFICA EN LA BBDD
    public static void insertarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        Utils.insertarGrafica(id, nombre, vram, marca, fabricante, precio);

    }

    // FUNCION PARA MODIFICAR GRAFICA EN LA BBDD
    public static void modificarGrafica(int id, String nombre, int vram, String marca, String fabricante, double precio) throws SQLException {
        Utils.modificarGrafica(id, nombre, vram, marca, fabricante, precio);
    }

    // FUNCION PARA ELIMINAR GRAFICA EN LA BBDD
    public static void eliminarGrafica(int id) throws SQLException {
        Utils.eliminarGrafica(id);
    }

    // FUNCION PARA MOSTRAR EL HISTORIAL DE PRECIOS
    public static String obtenerHistorialPrecios(int idGrafica) throws IOException {
        return leerHistorialPrecios(idGrafica);
    }

    public static String Validations(String idString, String vramString, String precioString, String nombre, String marca, String fabricante) {
        String errorID = Validations.validarID(idString);
        if (errorID != null) {
            return errorID;
        }

        String errorVRAM = Validations.validarVRAM(vramString);
        if (errorVRAM != null) {
            return errorVRAM;
        }

        String errorPrecio = Validations.validarPrecio(precioString);
        if (errorPrecio != null) {
            return errorPrecio;
        }

        String errorNombre = Validations.validarNombre(nombre);
        if (errorNombre != null) {
            return errorNombre;
        }

        String errorMarca = Validations.validarMarca(marca);
        if (errorMarca != null) {
            return errorMarca;
        }

        String errorFabricante = Validations.validarFabricante(fabricante);
        if (errorFabricante != null) {
            return errorFabricante;
        }

        return null; // No hay errores, la validación pasa
    }

    public static String ValidarID(String idString) {
        String errorID = Validations.validarID(idString);
        if (errorID != null) {
            return errorID;
        }
        return null;
    }

}
