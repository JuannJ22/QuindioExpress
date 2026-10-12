package co.edu.uniquindio.quindioexpress.algoritmos;

import co.edu.uniquindio.quindioexpress.Paquete;

import java.util.List;

public final class DivideYVenceras {
    private DivideYVenceras() {}

    public static Paquete masPesado(List<Paquete> lista) {
        if (lista.isEmpty()) throw new IllegalArgumentException("Lista vacia");
        return masPesado(lista, 0, lista.size() - 1);
    }
    private static Paquete masPesado(List<Paquete> lista, int inicio, int fin) {
        if (inicio == fin) return lista.get(inicio);
        int medio = (inicio + fin) / 2;
        Paquete izq = masPesado(lista, inicio, medio);
        Paquete der = masPesado(lista, medio + 1, fin);
        if (izq.getPeso() >= der.getPeso()) {
            return izq;
        } else {
            return der;
        }
    }
}