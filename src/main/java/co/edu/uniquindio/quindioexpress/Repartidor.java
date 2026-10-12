package co.edu.uniquindio.quindioexpress;

public class Repartidor {
    private String nombre;
    private String identificacion;
    private String zona;
    private boolean disponible;

    public Repartidor(String nombre, String identificacion, String zona) {
        if (identificacion == null || identificacion.isBlank())
            throw new IllegalArgumentException("La identificacion no puede estar vacia");
        validarNombre(nombre);
        validarZona(zona);

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.zona = zona;
        this.disponible = true;
    }

    private static void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacio");
    }

    private static void validarZona(String zona) {
        if (zona == null || zona.isBlank())
            throw new IllegalArgumentException("La zona no puede estar vacia");
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }


    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        validarZona(zona);
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