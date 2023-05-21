package Utils;

public class Filters {
    
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
}
