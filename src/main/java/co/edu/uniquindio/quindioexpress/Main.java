
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
        System.out.println("Singleton: " +
                (centro == QuindioExpress.getInstancia()));

        // Repartidores
        centro.agregarRepartidor(new Repartidor("Juan", "R01", "Armenia"));
        centro.agregarRepartidor(new Repartidor("Pedro", "R02", "Salento"));
        centro.agregarRepartidor(new Repartidor("Maria", "R03", "Calarca"));
        centro.agregarRepartidor(new Repartidor("Sofia", "R04", "Montenegro"));
        centro.agregarRepartidor(new Repartidor("Andres", "R05", "Quimbaya"));
        centro.agregarRepartidor(new Repartidor("Esteban", "R06", "Armenia"));

        System.out.println("\n--- REPARTIDORES ---");

        Repartidor repartidor = centro.buscarRepartidor("R01");
        System.out.println(repartidor.getNombre() + " - " + repartidor.getZona());

        Repartidor eliminado = centro.eliminarRepartidor("R06");
        System.out.println("Eliminado: " + eliminado.getNombre());

        centro.agregarRepartidor(new Repartidor("Laura", "R06", "Armenia"));

        probarError("Repartidor duplicado", () ->
                centro.agregarRepartidor(
                        new Repartidor("Otro", "R01", "Armenia")
                )
        );

        System.out.println("Repartidor inexistente: " +
                centro.buscarRepartidor("R99"));

        System.out.println("Eliminar inexistente: " +
                centro.eliminarRepartidor("R99"));

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

        System.out.println("\n--- REGISTRO DE PAQUETES ---");

        System.out.println("Paquetes pendientes: " + centro.paquetesPendientes());
        System.out.println("Hay pendientes: " + centro.hayPendientes());

        probarError("Codigo duplicado", () ->
                centro.agregarPaquete(
                        new Paquete("PQ731", 3.0, "Salento", 4, 30)
                )
        );

        Paquete encontrado = centro.buscarPaquete("PQ105");
        System.out.println("Encontrado: " + encontrado.getCodigo()
                + " - " + encontrado.getDestino());

        probarError("Buscar paquete inexistente", () ->
                centro.buscarPaquete("PQ999")
        );

        System.out.println("\n--- MUNICIPIOS ---");

        System.out.println("Municipios: " + centro.municipios());
        System.out.println("Ordenados: " + centro.municipiosOrdenados());

        System.out.println("\nPaquetes para Armenia:");
        for (Paquete p : centro.porMunicipio("Armenia")) {
            System.out.println(p.getCodigo() + " - " + p.getPeso() + " kg");
        }

        System.out.println("Paquetes para Pereira: " +
                centro.porMunicipio("Pereira").size());

        System.out.println("\n--- COLAS ---");

        Paquete primero = centro.siguienteOrdenLlegada();
        Paquete prioritario = centro.siguientePorPrioridad();

        System.out.println("Primero por llegada: " + primero.getCodigo());
        System.out.println("Primero por prioridad: " + prioritario.getCodigo());

        System.out.println("\n--- ALGORITMOS ---");

        System.out.println("Peso total Armenia: " +
                centro.pesoTotalMunicipio("Armenia") + " kg");

        System.out.println("Prioridad mayor o igual a 4: " +
                centro.contarConPrioridadMinima(4));

        Paquete binario = centro.buscarBinario("PQ330");
        System.out.println("Busqueda binaria: " + binario.getCodigo());

        System.out.println("Busqueda binaria inexistente: " +
                centro.buscarBinario("PQ999"));

        Paquete pesado = centro.paqueteMasPesado();
        System.out.println("Mas pesado: " + pesado.getCodigo()
                + " - " + pesado.getPeso() + " kg");

        System.out.println("\n--- ORDENAMIENTOS ---");

        List<Paquete> ordenados = new ArrayList<>();

        ordenados.addAll(centro.porMunicipio("Armenia"));
        ordenados.addAll(centro.porMunicipio("Salento"));
        ordenados.addAll(centro.porMunicipio("Calarca"));
        ordenados.addAll(centro.porMunicipio("Montenegro"));
        ordenados.addAll(centro.porMunicipio("Quimbaya"));

        Collections.sort(ordenados);
        System.out.println("Primero por codigo: " +
                ordenados.get(0).getCodigo());

        ordenados.sort(Comparators.PESO);
        System.out.println("Mayor peso: " +
                ordenados.get(0).getCodigo());

        ordenados.sort(Comparators.PRIORIDAD);
        System.out.println("Mayor prioridad: " +
                ordenados.get(0).getCodigo());

        ordenados.sort(Comparators.TIEMPO);
        System.out.println("Menor tiempo: " +
                ordenados.get(0).getCodigo());

        ordenados.sort(Comparators.DESPACHO);
        System.out.println("Primero para despacho: " +
                ordenados.get(0).getCodigo());

        System.out.println("\n--- ASIGNACIONES ---");

        probarError("Zona incorrecta", () ->
                centro.asignarPaquete("PQ731", "R02")
        );

        probarError("Repartidor inexistente", () ->
                centro.asignarPaquete("PQ731", "R99")
        );

        probarError("Paquete inexistente", () ->
                centro.asignarPaquete("PQ999", "R01")
        );

        centro.asignarPaquete("PQ675", "R04");

        System.out.println("Asignado PQ675 a R04");
        System.out.println("Disponible R04: " +
                centro.buscarRepartidor("R04").isDisponible());

        probarError("Repartidor ocupado", () ->
                centro.asignarPaquete("PQ912", "R04")
        );

        probarError("Eliminar repartidor ocupado", () ->
                centro.eliminarRepartidor("R04")
        );

        System.out.println("Pendientes despues de asignar: " +
                centro.paquetesPendientes());

        System.out.println("\n--- ENTREGAS ---");

        centro.RegistrarEntrega("PQ675");

        System.out.println("Entregado: PQ675");
        System.out.println("Disponible R04: " +
                centro.buscarRepartidor("R04").isDisponible());

        probarError("Entrega repetida", () ->
                centro.RegistrarEntrega("PQ675")
        );

        probarError("Entrega sin asignacion", () ->
                centro.RegistrarEntrega("PQ420")
        );

        centro.asignarPaquete("PQ731", "R01");

        probarError("Asignar paquete dos veces", () ->
                centro.asignarPaquete("PQ731", "R06")
        );

        centro.RegistrarEntrega("PQ731");

        System.out.println("Entregado: PQ731");
        System.out.println("Pendientes finales: " +
                centro.paquetesPendientes());

        System.out.println("\n--- LISTA ENLAZADA PROPIA ---");

        ColeccionPropia<String> lista = new ListaEnlazadaPropia<>();

        System.out.println("Lista vacia: " + lista.estaVacia());

        lista.agregarElemento("Primero");
        lista.agregarElemento("Segundo");
        lista.agregarElemento("Tercero");

        System.out.println("Tamanio: " + lista.tamanio());
        System.out.println("Posicion 1: " + lista.obtener(1));

        System.out.println("Eliminar Segundo: " +
                lista.eliminarElemento("Segundo"));

        System.out.println("Eliminar inexistente: " +
                lista.eliminarElemento("Cuarto"));

        System.out.println("Elementos de la lista:");

        for (String elemento : lista) {
            System.out.println(elemento);
        }

        System.out.println("Lista vacia: " + lista.estaVacia());

        System.out.println("\nFin de la demostracion.");
    }

    private static void probarError(String prueba, Runnable accion) {
        try {
            accion.run();
            System.out.println(prueba + ": no se rechazo");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(prueba + ": " + e.getMessage());
        }
    }
}
