package co.edu.uniquindio.quindioexpress.algoritmos;

import co.edu.uniquindio.quindioexpress.Paquete;

import java.util.List;

public class Binaria {

    public static int buscar(List<Paquete> ordenada, String codigo) {
        return binaria(ordenada, codigo, 0, ordenada.size() - 1);
    }

    private static int binaria(List<Paquete> ordenada, String codigo, int ini, int fin) {
        if (ini > fin) return -1;
        int medio = ini + (fin - ini) / 2;
        int cmp = codigo.compareTo(ordenada.get(medio).getCodigo());
        if (cmp == 0) return medio;
        if (cmp < 0) return binaria(ordenada, codigo, ini, medio - 1);
        return binaria(ordenada, codigo, medio + 1, fin);
    }
}

