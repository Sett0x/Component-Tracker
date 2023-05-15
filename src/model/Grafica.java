package model;

// OBJETO GRAFICA
public class Grafica {
    public int id;
    public String nombre;
    public int vram;
    public String marca;
    public String fabricante;
    public float precio;

    public Grafica(int id, String nombre, int vram, String marca, String fabricante, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.vram = vram;
        this.marca = marca;
        this.fabricante = fabricante;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Grafica [id=" + id + ", nombre=" + nombre + ", vram=" + vram + ", marca=" + marca + ", fabricante="
                + fabricante + ", precio=" + precio + "]\n";
    }
    
    
}


