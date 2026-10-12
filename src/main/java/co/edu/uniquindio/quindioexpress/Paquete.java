package co.edu.uniquindio.quindioexpress;

import java.util.Objects;

public class Paquete implements Comparable<Paquete>{
    private String codigo;
    private Double peso;
    private String destino;
    private int prioridad;
    private int tiempoEstimado;

    public Paquete(String codigo, Double peso, String destino, int prioridad, int tiempoEstimado) {
        if (codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("El codigo no puede estar vacio");
        validarPeso(peso);
        validarDestino(destino);
        validarPrioridad(prioridad);
        validarTiempo(tiempoEstimado);

        this.codigo = codigo;
        this.peso = peso;
        this.destino = destino;
        this.prioridad = prioridad;
        this.tiempoEstimado = tiempoEstimado;
    }

    public Paquete(String codigo, Double peso, String destino, int tiempoEstimado) {
        this(codigo, peso, destino, 3, tiempoEstimado);
    }

    @Override
    public int compareTo(Paquete paquete) {
        return this.codigo.compareTo(paquete.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paquete)) return false;
        return codigo.equals(((Paquete) o).codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


    private static void validarPeso(Double peso) {
        if (peso == null || peso <= 0)
            throw new IllegalArgumentException("El peso debe ser mayor que cero: " + peso);
    }

    private static void validarDestino(String destino) {
        if (destino == null || destino.isBlank())
            throw new IllegalArgumentException("El destino no puede ser nulo ni vacio");
    }

    private static void validarPrioridad(int prioridad) {
        if (prioridad < 1 || prioridad > 5)
            throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5: " + prioridad);
    }

    private static void validarTiempo(int tiempoEstimado) {
        if (tiempoEstimado <= 0)
            throw new IllegalArgumentException("El tiempo estimado debe ser mayor que cero: " + tiempoEstimado);
    }

    public String getCodigo() {
        return codigo;
    }


    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        validarPeso(peso);
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }


    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        validarPrioridad(prioridad);
        this.prioridad = prioridad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        validarTiempo(tiempoEstimado);
        this.tiempoEstimado = tiempoEstimado;
    }
}