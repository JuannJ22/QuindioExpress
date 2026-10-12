package co.edu.uniquindio.quindioexpress.Estructuras;

public interface ColeccionPropia <T> extends Iterable<T>{

    void agregarElemento(T elemento);
    boolean eliminarElemento(T elemento);
    T obtener(int posicion);
    int tamanio();
    boolean estaVacia();

}
