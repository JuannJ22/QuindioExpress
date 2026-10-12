package co.edu.uniquindio.quindioexpress;

import java.io.Serializable;

public class Paquete implements Comparable<Paquete>{
    String codigo;
    Double peso;
    String municipio;
    int prioridad;
    int tiempoEstimado;

    public Paquete(String codigo, Double peso, String destino, int prioridad, int tiempoEstimado) {
        this.codigo = codigo;
        this.peso = peso;
        this.municipio = destino;
        this.prioridad = prioridad;
        this.tiempoEstimado = tiempoEstimado;
    }

    public Paquete(String codigo, Double peso, String destino, int tiempoEstimado) {
        this(codigo, peso, destino, 3, tiempoEstimado);
    }
    //Por Código
    @Override
    public int compareTo(Paquete paquete) {
        return this.codigo.compareTo(paquete.codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
