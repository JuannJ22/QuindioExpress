package co.edu.uniquindio.quindioexpress.algoritmos;

import co.edu.uniquindio.quindioexpress.Paquete;

import java.util.List;

public class Recursividad {

    private Recursividad() {}

    public static double pesoTotal(List<Paquete> lista, String municipio) {
        return pesoTotal(lista, municipio, 0);
    }

    public static double pesoTotal(List<Paquete> lista, String municipio, int i) {
        if (i == lista.size()) return 0.0;

        double actual;
        if (lista.get(i).getDestino().equalsIgnoreCase(municipio)) {
            actual = lista.get(i).getPeso();
        } else {
            actual = 0.0;
        }

        return actual + pesoTotal(lista, municipio, i + 1);
    }

    public static int contarPrioridad(List<Paquete> lista, int minima) {
        return contarPrioridad(lista, minima, 0);
    }

    public static int contarPrioridad(List<Paquete> lista, int minima, int i) {
        if (i == lista.size()) return 0;
        int cuenta = lista.get(i).getPrioridad() >= minima ? 1 : 0;
        return cuenta + contarPrioridad(lista, minima, i + 1);
    }
}

