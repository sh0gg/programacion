package ud6.apuntesgenericos;

import java.util.Arrays;

public class ContenedorLista<T> implements Pila<T>, Cola<T>{
    T[] elementos;

    public ContenedorLista(T[] t) {
        elementos = t;
    }

    void insertarAlPrincipio(T nuevo) {
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        System.arraycopy(elementos, 0, elementos, 1, elementos.length - 1);
        elementos[0] = nuevo;
    }

    void insertarAlFinal(T nuevo) {
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = nuevo;
    }

    T extraerDelPrincipio() {
        if (elementos.length == 0) return null;
        T primero = elementos[0];
        elementos = Arrays.copyOfRange(elementos, 1, elementos.length);
        return primero;
    }

    T extraerDelFinal() {
        if (elementos.length == 0) return null;
        T ultimo = elementos[elementos.length - 1];
        elementos = Arrays.copyOf(elementos, elementos.length - 1);
        return ultimo;
    }

    void ordenar() {
        if (elementos.length == 0 || !(elementos[0] instanceof Comparable)) {
            System.out.println("Elementos no comparables. No se puede ordenar.");
            return;
        }
        Arrays.sort((T[]) elementos);
    }

    @Override
    public String toString() {
        return Arrays.toString(elementos);
    }

    // Se entiende que persona está en este mismo paquete
    public static void main(String[] args) {
        ContenedorLista<Integer> lista = new ContenedorLista<>(new Integer[0]);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        System.out.println("Antes de ordenar: " + lista);
        lista.ordenar();
        System.out.println("Después de ordenar: " + lista);
        System.out.println("Extraído del principio: " + lista.extraerDelPrincipio());
        System.out.println("Extraído del final: " + lista.extraerDelFinal());
        System.out.println("Lista final: " + lista);

        ContenedorLista<Persona> listaP = new ContenedorLista<>(new Persona[0]);
        listaP.insertarAlFinal(new Persona("Pepe"));
        listaP.insertarAlFinal(new Persona("Maria"));
        listaP.insertarAlFinal(new Persona("Lola"));
        System.out.println("Personas antes de ordenar: " + listaP);
        listaP.ordenar();
        System.out.println("Personas ordenadas: " + listaP);
    }

    @Override
    public void encolar(T e) {
        insertarAlFinal(e);
    }

    @Override
    public T desencolar() {
        return extraerDelPrincipio();
    }

    @Override
    public void apilar(T e) {
        insertarAlFinal(e);
    }

    @Override
    public T desapilar() {
        return extraerDelFinal();
    }
    
    public boolean estaVacia() {
        return elementos.length == 0;
    }
}

