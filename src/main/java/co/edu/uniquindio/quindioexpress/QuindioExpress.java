package co.edu.uniquindio.quindioexpress;

import co.edu.uniquindio.quindioexpress.Estructuras.ColeccionPropia;
import co.edu.uniquindio.quindioexpress.Estructuras.ListaEnlazadaPropia;

import java.util.*;

public class QuindioExpress {
    private final List<Paquete> registro = new ArrayList<>();
    private final Map<String, Paquete> porCodigo = new HashMap<>();
    private final Queue<Paquete> colaPaquete = new ArrayDeque<>();
    private final PriorityQueue<Paquete> colaPrioridad = new PriorityQueue<>(Comparators.DESPACHO);
    private final Map<String, List<Paquete>> porMunicipio = new HashMap<>();
    private final Map<String, Repartidor> repartidores = new HashMap<>();
    private final Map<String, Repartidor> asignaciones = new HashMap<>();
    private final ColeccionPropia<Paquete> historial = new ListaEnlazadaPropia<>();




    private static QuindioExpress instancia;

    private QuindioExpress() {
    }

    public static QuindioExpress getInstancia() {
        if (instancia == null) {
            instancia = new QuindioExpress();
        }
        return instancia;
    }

    public void agregarPaquete(Paquete paquete) {
        if (porCodigo.containsKey(paquete.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un paquete con ese codigo" + paquete.getCodigo());
        }
        registro.add(paquete);
        porCodigo.put(paquete.getCodigo(), paquete);
        colaPaquete.offer(paquete);
        colaPrioridad.offer(paquete);
        porMunicipio.computeIfAbsent(paquete.getDestino(), Llave -> new ArrayList<>()).add(paquete);
    }

    public Paquete buscarPaquete(String codigo) {
        return porCodigo.get(codigo);
    }

    //CRUD REPARTIDOR

    public void agregarRepartidor(Repartidor repartidor) {
        if(repartidores.containsKey(repartidor.getIdentificacion())){
            throw new IllegalArgumentException("Ya existe una repartidor con esta identificación" + repartidor.getIdentificacion());
        }
        repartidores.put(repartidor.getIdentificacion(), repartidor);
    }

    public Repartidor buscarRepartidor(String identificacion) {
        return repartidores.get(identificacion);
    }

    public Repartidor eliminarRepartidor(String identificacion) {
        Repartidor repartidor = repartidores.get(identificacion);
        if (repartidor == null) {
            return null;
        }

        if (asignaciones.containsKey(repartidor.getIdentificacion())){
            throw new IllegalStateException("El repartidor tiene un paquetes asignados");
        }
        return repartidores.remove(identificacion);
    }

    //CRUD Municipios

    public Set<String> municipios() {
        Set<String> municipios = new HashSet<>();
        for (Paquete paquete : registro) municipios.add(paquete.getDestino());
        return municipios;
    }

    public Set<String> municipiosOrdenados() {
        return new TreeSet<>(municipios());
    }


    public List<Paquete> porMunicipio(String municipio) {
        List<Paquete> paquetes = porMunicipio.get(municipio);

        if (paquetes == null) {
            return List.of();
        }
        return Collections.unmodifiableList(paquetes);
    }


    //CONSULTAS DE LAS COLAS

    public Paquete siguientePorPrioridad(Paquete paquete) {
        return colaPrioridad.peek();
    }

    public Paquete siguienteOrdenLlegada(Paquete paquete) {
        return colaPaquete.peek();
    }

    public boolean hayPendientes(){
        return !colaPaquete.isEmpty();
    }

    public int paquetesPendientes(){
        return colaPaquete.size();
    }

    public void asignarPaquete(String codigoPaquete, String idRepartidor ) {
        Paquete paquete = buscarPaquete(codigoPaquete);
        Repartidor repartidor = repartidores.get(idRepartidor);

        if( repartidor == null || paquete == null) throw new IllegalArgumentException("No existe.");

        if (!repartidor.isDisponible()) throw new IllegalArgumentException("El repartidor no esta disponible");

        if(!repartidor.getZona().equalsIgnoreCase(paquete.getDestino())) throw new IllegalArgumentException("La zona no coincide con el destino");

        repartidor.marcarOcupado();
        asignaciones.put(repartidor.getIdentificacion(), repartidor);
    }

    public void RegistrarEntrega(String codigoPaquete) {
        Paquete paquete = buscarPaquete(codigoPaquete);
        Repartidor repartidor = asignaciones.remove(codigoPaquete);

        historial.agregarElemento(paquete);

        if (repartidor != null) {
            repartidor.marcarDisponible();
        }
    }
}
