package co.edu.uniquindio.quindioexpress.algoritmos;


import co.edu.uniquindio.quindioexpress.Paquete;

import java.util.List;

public final class DivideYVenceras {
    private DivideYVenceras() {}

    public static Paquete masPesado(List<Paquete> lista) {
        if (lista.isEmpty()) throw new IllegalArgumentException("Lista vacia");
        return masPesado(lista, 0, lista.size() - 1);
    }
    public static Paquete masPesado(List<Paquete> lista, int ini, int fin) {
        if (ini == fin) return lista.get(ini);
        int medio = (ini + fin) / 2;
        Paquete izq = masPesado(lista, ini, medio);
        Paquete der = masPesado(lista, medio + 1, fin);
        return izq.getPeso() >= der.getPeso() ? izq : der;
    }
}