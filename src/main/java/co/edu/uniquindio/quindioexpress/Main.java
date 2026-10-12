
package co.edu.uniquindio.quindioexpress;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuindioExpress centro = QuindioExpress.getInstancia();

        // Repartidores
        centro.agregarRepartidor(new Repartidor("Juan", "R01", "Armenia"));
        centro.agregarRepartidor(new Repartidor("Pedro", "R02", "Salento"));
        centro.agregarRepartidor(new Repartidor("Maria", "R03", "Calarca"));
        centro.agregarRepartidor(new Repartidor("Sofia", "R04", "Montenegro"));
        centro.agregarRepartidor(new Repartidor("Andres", "R05", "Quimbaya"));
        centro.agregarRepartidor(new Repartidor("Laura", "R06", "Armenia"));

        // Paquetes de Armenia
        centro.agregarPaquete(new Paquete("PQ731", 4.5, "Armenia", 3, 40));
        centro.agregarPaquete(new Paquete("PQ105", 2.0, "Armenia", 5, 25));
        centro.agregarPaquete(new Paquete("PQ420", 7.8, "Armenia", 2, 60));
        centro.agregarPaquete(new Paquete("PQ330", 3.2, "Armenia", 4, 35));
        centro.agregarPaquete(new Paquete("PQ812", 6.1, "Armenia", 5, 30));
        centro.agregarPaquete(new Paquete("PQ216", 1.9, "Armenia", 1, 20));

        // Paquetes de Salento
        centro.agregarPaquete(new Paquete("PQ942", 5.3, "Salento", 4, 20));
        centro.agregarPaquete(new Paquete("PQ318", 2.7, "Salento", 3, 45));
        centro.agregarPaquete(new Paquete("PQ564", 8.4, "Salento", 5, 50));
        centro.agregarPaquete(new Paquete("PQ127", 1.5, "Salento", 2, 30));
        centro.agregarPaquete(new Paquete("PQ693", 4.8, "Salento", 4, 40));
        centro.agregarPaquete(new Paquete("PQ275", 3.6, "Salento", 1, 25));

        // Paquetes de Calarca
        centro.agregarPaquete(new Paquete("PQ836", 6.9, "Calarca", 5, 35));
        centro.agregarPaquete(new Paquete("PQ149", 2.4, "Calarca", 2, 20));
        centro.agregarPaquete(new Paquete("PQ507", 9.2, "Calarca", 3, 55));
        centro.agregarPaquete(new Paquete("PQ621", 4.1, "Calarca", 4, 30));
        centro.agregarPaquete(new Paquete("PQ384", 1.8, "Calarca", 5, 25));
        centro.agregarPaquete(new Paquete("PQ758", 5.7, "Calarca", 1, 40));

        // Paquetes de Montenegro
        centro.agregarPaquete(new Paquete("PQ912", 7.3, "Montenegro", 4, 50));
        centro.agregarPaquete(new Paquete("PQ243", 3.5, "Montenegro", 2, 35));
        centro.agregarPaquete(new Paquete("PQ675", 6.2, "Montenegro", 5, 20));
        centro.agregarPaquete(new Paquete("PQ156", 2.1, "Montenegro", 3, 45));
        centro.agregarPaquete(new Paquete("PQ804", 8.7, "Montenegro", 1, 60));
        centro.agregarPaquete(new Paquete("PQ469", 4.4, "Montenegro", 5, 30));

        // Paquetes de Quimbaya
        centro.agregarPaquete(new Paquete("PQ593", 5.9, "Quimbaya", 3, 40));
        centro.agregarPaquete(new Paquete("PQ207", 1.7, "Quimbaya", 5, 25));
        centro.agregarPaquete(new Paquete("PQ748", 7.1, "Quimbaya", 4, 35));
        centro.agregarPaquete(new Paquete("PQ361", 3.8, "Quimbaya", 2, 50));
        centro.agregarPaquete(new Paquete("PQ985", 9.5, "Quimbaya", 5, 45));
        centro.agregarPaquete(new Paquete("PQ432", 2.9, "Quimbaya", 1, 20));

        System.out.println("===== QUINDIO EXPRESS =====");

        System.out.println("\nMunicipios registrados:");
        System.out.println(centro.municipios());

        System.out.println("\nMunicipios ordenados:");
        System.out.println(centro.municipiosOrdenados());

        System.out.println("\nPaquetes registrados en Armenia:");
        for (Paquete paquete : centro.porMunicipio("Armenia")) {
            System.out.println(paquete.getCodigo() + " - "
                    + paquete.getPeso() + " kg");
        }

        System.out.println("\nBuscar paquete PQ105:");
        Paquete encontrado = centro.buscarPaquete("PQ105");
        System.out.println(encontrado.getCodigo() + " - " + encontrado.getDestino() + " - Prioridad: " + encontrado.getPrioridad());


        System.out.println("\nSiguiente por llegada:");
        Paquete primero = centro.siguienteOrdenLlegada();
        System.out.println(primero.getCodigo());

        System.out.println("\nSiguiente por prioridad:");
        Paquete prioritario = centro.siguientePorPrioridad();
        System.out.println(prioritario.getCodigo());

        System.out.println("\nCantidad de paquetes pendientes:");
        System.out.println(centro.paquetesPendientes());

        System.out.println("\nPeso total de Armenia:");
        System.out.println(centro.pesoTotalMunicipio("Armenia") + " kg");

        System.out.println("\nPaquetes con prioridad mayor o igual a 4:");
        System.out.println(centro.contarConPrioridadMinima(4));

        System.out.println("\nBusqueda binaria PQ330:");
        Paquete buscado = centro.buscarBinario("PQ330");

        if (buscado != null) {
            System.out.println("Encontrado: " + buscado.getCodigo());
        } else {
            System.out.println("Paquete no encontrado");
        }

        System.out.println("\nPaquete mas pesado:");
        Paquete pesado = centro.paqueteMasPesado();
        System.out.println(pesado.getCodigo() + " - "
                + pesado.getPeso() + " kg");

        System.out.println("\nCinco paquetes de mayor peso:");
        List<Paquete> ordenados = new ArrayList<>();

        for (String municipio : centro.municipios()) {
            ordenados.addAll(centro.porMunicipio(municipio));
        }

        ordenados.sort(Comparators.PESO);

        for (int i = 0; i < 5; i++) {
            Paquete paquete = ordenados.get(i);
            System.out.println(paquete.getCodigo() + " - "
                    + paquete.getPeso() + " kg");
        }

        System.out.println("\nFin de la demostracion.");
    }
}
