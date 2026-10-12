package co.edu.uniquindio.quindioexpress;

public class Repartidor {
    String nombre;
    String identificacion;
    String zona;
    boolean disponible;

    public Repartidor(String nombre, String identificacion, String zona) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.zona = zona;
        this.disponible = true;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void marcarDisponible() {
        this.disponible = true;
    }
    public void marcarOcupado() {
        this.disponible = false;
    }
}
