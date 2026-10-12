package co.edu.uniquindio.quindioexpress;

import co.edu.uniquindio.quindioexpress.Estructuras.ColeccionPropia;
import co.edu.uniquindio.quindioexpress.Estructuras.ListaEnlazadaPropia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuindioExpress centro = QuindioExpress.getInstancia();
        System.out.println("===== QUINDIO EXPRESS =====");

        // ================= REPARTIDORES =================
        System.out.println("\n--- REPARTIDORES ---");
        centro.agregarRepartidor(new Repartidor("Juan", "R01", "Armenia"));
        centro.agregarRepartidor(new Repartidor("Pedro", "R02", "Salento"));
        centro.agregarRepartidor(new Repartidor("Maria", "R03", "Calarca"));
        centro.agregarRepartidor(new Repartidor("Sofia", "R04", "Montenegro"));
        centro.agregarRepartidor(new Repartidor("Andres", "R05", "Quimbaya"));
        centro.agregarRepartidor(new Repartidor("Laura", "R06", "Armenia"));

        System.out.println("Buscar R01: " + centro.buscarRepartidor("R01").getNombre());

        try {
            centro.agregarRepartidor(new Repartidor("Otro", "R01", "Armenia"));
        } catch (IllegalArgumentException e) {
            System.out.println("Repartidor duplicado: " + e.getMessage());
        }

        // ================= PAQUETES =================
        // Armenia
        centro.agregarPaquete(new Paquete("PQ731", 4.5, "Armenia", 3, 40));
        centro.agregarPaquete(new Paquete("PQ105", 2.0, "Armenia", 5, 25));
        centro.agregarPaquete(new Paquete("PQ420", 7.8, "Armenia", 2, 60));
        centro.agregarPaquete(new Paquete("PQ330", 3.2, "Armenia", 4, 35));
        centro.agregarPaquete(new Paquete("PQ812", 6.1, "Armenia", 5, 30));
        centro.agregarPaquete(new Paquete("PQ216", 1.9, "Armenia", 1, 20));
        // Salento
        centro.agregarPaquete(new Paquete("PQ942", 5.3, "Salento", 4, 20));
        centro.agregarPaquete(new Paquete("PQ318", 2.7, "Salento", 3, 45));
        centro.agregarPaquete(new Paquete("PQ564", 8.4, "Salento", 5, 50));
        centro.agregarPaquete(new Paquete("PQ127", 1.5, "Salento", 2, 30));
        centro.agregarPaquete(new Paquete("PQ693", 4.8, "Salento", 4, 40));
        centro.agregarPaquete(new Paquete("PQ275", 3.6, "Salento", 1, 25));
        // Calarca
        centro.agregarPaquete(new Paquete("PQ836", 6.9, "Calarca", 5, 35));
        centro.agregarPaquete(new Paquete("PQ149", 2.4, "Calarca", 2, 20));
        centro.agregarPaquete(new Paquete("PQ507", 9.2, "Calarca", 3, 55));
        centro.agregarPaquete(new Paquete("PQ621", 4.1, "Calarca", 4, 30));
        centro.agregarPaquete(new Paquete("PQ384", 1.8, "Calarca", 5, 25));
        centro.agregarPaquete(new Paquete("PQ758", 5.7, "Calarca", 1, 40));
        // Montenegro
        centro.agregarPaquete(new Paquete("PQ912", 7.3, "Montenegro", 4, 50));
        centro.agregarPaquete(new Paquete("PQ243", 3.5, "Montenegro", 2, 35));
        centro.agregarPaquete(new Paquete("PQ675", 6.2, "Montenegro", 5, 20));
        centro.agregarPaquete(new Paquete("PQ156", 2.1, "Montenegro", 3, 45));
        centro.agregarPaquete(new Paquete("PQ804", 8.7, "Montenegro", 1, 60));
        centro.agregarPaquete(new Paquete("PQ469", 4.4, "Montenegro", 5, 30));
        // Quimbaya
        centro.agregarPaquete(new Paquete("PQ593", 5.9, "Quimbaya", 3, 40));
        centro.agregarPaquete(new Paquete("PQ207", 1.7, "Quimbaya", 5, 25));
        centro.agregarPaquete(new Paquete("PQ748", 7.1, "Quimbaya", 4, 35));
        centro.agregarPaquete(new Paquete("PQ361", 3.8, "Quimbaya", 2, 50));
        centro.agregarPaquete(new Paquete("PQ985", 9.5, "Quimbaya", 5, 45));
        centro.agregarPaquete(new Paquete("PQ432", 2.9, "Quimbaya", 1, 20));

        System.out.println("\n--- PAQUETES ---");
        System.out.println("Paquetes registrados: " + centro.paquetesPendientes());

        // Validaciones
        try {
            new Paquete("PQ001", 0.0, "Armenia", 3, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Peso invalido: " + e.getMessage());
        }
        try {
            new Paquete("PQ002", 2.0, "Armenia", 7, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Prioridad invalida: " + e.getMessage());
        }
        try {
            centro.agregarPaquete(new Paquete("PQ731", 3.0, "Salento", 4, 30));
        } catch (IllegalArgumentException e) {
            System.out.println("Codigo duplicado: " + e.getMessage());
        }

        // Consulta por codigo
        System.out.println("Existe PQ105: " + centro.existePaquete("PQ105"));
        System.out.println("Existe PQ999: " + centro.existePaquete("PQ999"));
        System.out.println("Buscar PQ105: " + centro.buscarPaquete("PQ105"));

        // ================= MUNICIPIOS =================
        System.out.println("\n--- MUNICIPIOS ---");
        System.out.println("Sin repetir: " + centro.municipios());
        System.out.println("Ordenados:   " + centro.municipiosOrdenados());

        System.out.print("Paquetes de Armenia: ");
        for (Paquete p : centro.porMunicipio("Armenia")) {
            System.out.print(p.getCodigo() + " ");
        }
        System.out.println();

        // ================= COLAS =================
        System.out.println("\n--- COLAS ---");
        System.out.print("Orden de llegada: ");
        for (Paquete p : centro.ordenLlegadaPendientes()) {
            System.out.print(p.getCodigo() + " ");
        }
        System.out.println();

        System.out.print("Orden de despacho: ");
        for (Paquete p : centro.ordenDespachoPendientes()) {
            System.out.print(p.getCodigo() + " ");
        }
        System.out.println();

        // ================= ORDENAMIENTOS =================
        System.out.println("\n--- ORDENAMIENTOS ---");
        List<Paquete> copia = new ArrayList<>(centro.ordenLlegadaPendientes());

        Collections.sort(copia);
        System.out.println("Primero por codigo:    " + copia.get(0).getCodigo());

        copia.sort(Comparators.PESO);
        System.out.println("Mayor peso:            " + copia.get(0).getCodigo());

        copia.sort(Comparators.PRIORIDAD);
        System.out.println("Mayor prioridad:       " + copia.get(0).getCodigo());

        copia.sort(Comparators.TIEMPO);
        System.out.println("Menor tiempo:          " + copia.get(0).getCodigo());

        // ================= ALGORITMOS =================
        System.out.println("\n--- ALGORITMOS ---");
        System.out.println("Peso total Armenia (recursivo): " + centro.pesoTotalMunicipio("Armenia") + " kg");
        System.out.println("Prioridad >= 4 (recursivo):     " + centro.contarConPrioridadMinima(4));
        System.out.println("Busqueda binaria PQ330:         " + centro.buscarBinario("PQ330"));
        System.out.println("Busqueda binaria PQ999:         " + centro.buscarBinario("PQ999"));
        System.out.println("Mas pesado (divide y venceras): " + centro.paqueteMasPesado());

        // ================= ASIGNACIONES =================
        System.out.println("\n--- ASIGNACIONES ---");
        try {
            centro.asignarPaquete("PQ731", "R02");   // PQ731 va a Armenia, R02 es de Salento
        } catch (IllegalArgumentException e) {
            System.out.println("Zona incorrecta: " + e.getMessage());
        }

        centro.asignarPaquete("PQ675", "R04");
        System.out.println("PQ675 asignado a R04. R04 disponible: " + centro.buscarRepartidor("R04").isDisponible());

        try {
            centro.asignarPaquete("PQ912", "R04");   // R04 ya esta ocupado
        } catch (IllegalStateException e) {
            System.out.println("Repartidor ocupado: " + e.getMessage());
        }

        // ================= ENTREGAS =================
        System.out.println("\n--- ENTREGAS ---");
        centro.registrarEntrega("PQ675");
        System.out.println("PQ675 entregado. R04 disponible: " + centro.buscarRepartidor("R04").isDisponible());

        centro.asignarPaquete("PQ731", "R01");
        centro.registrarEntrega("PQ731");
        System.out.println("PQ731 entregado");

        Paquete despachado = centro.despacharSiguientePrioritario();
        centro.registrarEntrega(despachado.getCodigo());
        System.out.println(despachado.getCodigo() + " despachado por prioridad y entregado");

        System.out.print("Historial: ");
        for (Paquete p : centro.getHistorial()) {
            System.out.print(p.getCodigo() + " -> ");
        }
        System.out.println("fin");

        // ================= LISTA PROPIA =================
        System.out.println("\n--- LISTA ENLAZADA PROPIA ---");
        ColeccionPropia<String> lista = new ListaEnlazadaPropia<>();

        System.out.println("Vacia: " + lista.estaVacia());
        System.out.println("Eliminar en lista vacia: " + lista.eliminarElemento("X"));

        lista.agregarElemento("A");
        System.out.println("Eliminar unico elemento: " + lista.eliminarElemento("A"));

        lista.agregarElemento("B");
        lista.agregarElemento("C");
        lista.agregarElemento("D");
        lista.agregarElemento("E");
        System.out.println("Tamanio: " + lista.tamanio() + ", posicion 1: " + lista.obtener(1));

        System.out.println("Eliminar primero (B):    " + lista.eliminarElemento("B"));
        System.out.println("Eliminar intermedio (D): " + lista.eliminarElemento("D"));
        System.out.println("Eliminar ultimo (E):     " + lista.eliminarElemento("E"));
        System.out.println("Eliminar inexistente:    " + lista.eliminarElemento("Z"));

        lista.agregarElemento("F");
        System.out.print("Quedan (esperado C F): ");
        for (String s : lista) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("\nFin de la demostracion.");
    }
}