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
        String sql = Filters.filtroVRAM(ordenSeleccionado);
        return sql;
    }

    public static String filtroFabricante(String ordenSeleccionado) {
        String sql = Filters.filtroFabricante(ordenSeleccionado);
        return sql;
    }

    public static String filtroPrecio(String ordenSeleccionado) {
        String sql = Filters.filtroPrecio(ordenSeleccionado);
        return sql;
    }

    public static String filtroMarca(String ordenSeleccionado) {
        String sql = Filters.filtroMarca(ordenSeleccionado);
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
