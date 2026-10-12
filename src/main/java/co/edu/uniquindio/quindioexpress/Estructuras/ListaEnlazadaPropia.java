package co.edu.uniquindio.quindioexpress.Estructuras;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazadaPropia<T> implements ColeccionPropia<T>{

    private static class Nodo<T>{
        T valor;
        Nodo<T> siguiente;
        Nodo(T valor){this.valor = valor;}
    }

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tamanio;


    @Override
    public void agregarElemento(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (inicio == null) {
            inicio = nuevo;
        }
        else { fin.siguiente = nuevo; }

        fin = nuevo;
        tamanio++;
    }

    @Override
    public boolean eliminarElemento(T elemento) {
        if (inicio == null) { return false; }

        if (inicio.valor.equals(elemento)) {
            inicio = inicio.siguiente;
            if (inicio == null) fin = null;
            tamanio--;
            return true;
        }

        Nodo<T> anterior = inicio;
        while (anterior.siguiente != null) {
            if (anterior.siguiente.valor.equals(elemento)) {
                if(anterior.siguiente == fin) fin=anterior;
                anterior.siguiente = anterior.siguiente.siguiente;
                tamanio--;
                return true;
            }
            anterior = anterior.siguiente;
        }
        return false;
    }

    @Override
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("El elemento no existe");
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < posicion; i++) {actual = actual.siguiente;}
        return actual.valor;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public boolean estaVacia() {
        return tamanio == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = inicio;
            @Override
            public boolean hasNext() {
                return actual != null;
            }
            @Override
            public T next() {
                if (actual == null) throw new NoSuchElementException();
                T valor = actual.valor;
                actual = actual.siguiente;
                return valor;
            }
        };
    }
}
