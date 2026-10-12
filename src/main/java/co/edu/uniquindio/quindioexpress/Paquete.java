package co.edu.uniquindio.quindioexpress;

import java.io.Serializable;

public class Paquete implements Comparable<Paquete>{
    String codigo;
    Double peso;
    String destino;
    int prioridad;
    int tiempoEstimado;

    public Paquete(String codigo, Double peso, String destino, int prioridad, int tiempoEstimado) {
        this.codigo = codigo;
        this.peso = peso;
        this.destino = destino;
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
