package Utils;

public class Validations {

    public static String validarID(String idString) {
        if (!idString.matches("\\d+")) {
            return "El ID debe ser un valor numérico";
        }
        return null; // No hay error, la validación pasa
    }

    public static String validarVRAM(String vramString) {
        if (!vramString.matches("\\d+")) {
            return "VRAM debe ser un valor numérico";
        }
        return null; 
    }

    public static String validarPrecio(String precioString) {
        if (!precioString.matches("\\d+(\\.\\d+)?")) {
            return "El precio debe ser un valor numérico";
        }
        return null; 
    }

    public static String validarNombre(String nombre) {
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s\\d-]+")) {
            return "El nombre solo puede contener letras, números, guiones y espacios";
        }
        return null; 
    }

    public static String validarMarca(String marca) {
        if (!marca.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            return "La marca solo puede contener letras y espacios";
        }
        return null; 
    }

    public static String validarFabricante(String fabricante) {
        if (!fabricante.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            return "El fabricante solo puede contener letras y espacios";
        }
        return null; 
    }
}
