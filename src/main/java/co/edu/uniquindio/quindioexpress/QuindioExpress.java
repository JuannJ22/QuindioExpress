package co.edu.uniquindio.quindioexpress;

import co.edu.uniquindio.quindioexpress.Estructuras.ColeccionPropia;
import co.edu.uniquindio.quindioexpress.Estructuras.ListaEnlazadaPropia;
import co.edu.uniquindio.quindioexpress.algoritmos.Binaria;
import co.edu.uniquindio.quindioexpress.algoritmos.DivideYVenceras;
import co.edu.uniquindio.quindioexpress.algoritmos.Recursividad;

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
        Paquete paquete = porCodigo.get(codigo);
        if (paquete == null) throw new IllegalArgumentException("No existe un paquete con ese codigo" + codigo);
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

        if (asignaciones.containsValue(repartidor)){
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

    public Paquete siguientePorPrioridad() {
        return colaPrioridad.peek();
    }

    public Paquete siguienteOrdenLlegada() {
        return colaPaquete.peek();
    }

    public boolean hayPendientes(){
        return !colaPaquete.isEmpty();
    }

    public int paquetesPendientes(){
        return colaPaquete.size();
    }

    public void asignarPaquete(String codigoPaquete, String idRepartidor) {
        Paquete paquete = buscarPaquete(codigoPaquete);
        Repartidor repartidor = buscarRepartidor(idRepartidor);

        if (repartidor == null) {
            throw new IllegalArgumentException("El repartidor no existe");
        }

        if (!colaPaquete.contains(paquete)) {
            throw new IllegalStateException("El paquete ya fue asignado");
        }

        if (!repartidor.isDisponible()) {
            throw new IllegalStateException("El repartidor no esta disponible");
        }

        if (!repartidor.getZona().equalsIgnoreCase(paquete.getDestino())) {
            throw new IllegalArgumentException("La zona no coincide con el destino");
        }

        repartidor.marcarOcupado();
        asignaciones.put(codigoPaquete, repartidor);

        colaPaquete.remove(paquete);
        colaPrioridad.remove(paquete);
    }


    public void RegistrarEntrega(String codigoPaquete) {
        Paquete paquete = buscarPaquete(codigoPaquete);
        Repartidor repartidor = asignaciones.get(codigoPaquete);

        if (repartidor == null) {
            throw new IllegalStateException("El paquete no tiene una asignación activa");
        }

        historial.agregarElemento(paquete);
        asignaciones.remove(codigoPaquete);
        repartidor.marcarDisponible();
    }


    public double pesoTotalMunicipio(String municipio) {
        return Recursividad.pesoTotal(registro, municipio);
    }

    public int contarConPrioridadMinima(int minima) {
        return Recursividad.contarPrioridad(registro, minima);
    }

    public Paquete buscarBinario(String codigo) {
        List<Paquete> ordenada = new ArrayList<>(registro);
        Collections.sort(ordenada);
        int pos = Binaria.buscar(ordenada, codigo);
        if (pos == -1) {
            return null;
        } else {
            return ordenada.get(pos);
        }
    }

    public Paquete paqueteMasPesado() {
        return DivideYVenceras.masPesado(registro);
    }
}
