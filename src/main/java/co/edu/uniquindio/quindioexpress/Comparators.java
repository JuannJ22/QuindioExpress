package co.edu.uniquindio.quindioexpress;

import java.util.Comparator;

public class Comparators {


    public static final Comparator<Paquete> PRIORIDAD =
            new ComparadorPorPrioridad();

    public static final Comparator<Paquete> PESO =
            new ComparadorPorPeso();

    public static final Comparator<Paquete> TIEMPO =
            new ComparadorPorTiempo();

    public static class ComparadorPorPrioridad implements Comparator<Paquete> {
        @Override
        public int compare(Paquete a, Paquete b) {
            return Double.compare(b.getPrioridad(), a.getPrioridad());
        }
    }

    public static class ComparadorPorPeso implements Comparator<Paquete> {
        @Override
        public int compare(Paquete a, Paquete b) {
            return Double.compare(b.getPeso(), a.getPeso());
        }
    }


    public static class ComparadorPorTiempo implements Comparator<Paquete> {
        @Override
        public int compare(Paquete a, Paquete b) {
            return Double.compare(a.getTiempoEstimado(), b.getTiempoEstimado());
        }
    }

    public static final Comparator<Paquete> DESPACHO =
            PRIORIDAD.thenComparing(TIEMPO).thenComparing(Comparator.naturalOrder());
}