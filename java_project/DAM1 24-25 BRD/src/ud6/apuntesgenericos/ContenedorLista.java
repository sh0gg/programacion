package ud6.apuntesgenericos;

import java.util.Arrays;
import java.util.Comparator;

public class ContenedorLista<T> implements Pila<T>, Cola<T>{
    T[] elementos;

    public ContenedorLista(T[] t) {
        elementos = t;
    }

    void insertarAlPrincipio(T nuevo) {
        T[] elementosProv = Arrays.copyOf(elementos, elementos.length + 1);
        elementosProv[0] = nuevo;
        for (int i = 0; i < elementos.length; i++) {
            elementosProv[i + 1] = elementos[i];
        }
        elementos = elementosProv;
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

    T get (int indice) {
        return elementos[indice];
    }

    void ordenar (Comparator<T> c) {
        Arrays.sort(elementos, c);
    }

    T extract (int indice) {
        T elemento = null;
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == elementos[indice]) {}
            elemento = elementos[i];
        }
        return elemento;
    }

    int[] buscarTodos (Object e) {
        int[] resultado = new int[0];
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == e) {
                // resultado.insertarAlFinal(elementos[i]); NO PUEDO LLAMAR AL METODO, NO ES UN ELEMENTO SINO UN ARRAY DE INTS
                resultado = Arrays.copyOf(resultado, resultado.length + 1);
                resultado[resultado.length - 1] = (int) elementos[i];
            }
        }
        return resultado;
    }

    boolean eliminarTodos (Object e) {
        int[] aBorrar = buscarTodos(e);

        T[] elementosProv = Arrays.copyOf(elementos, elementos.length - aBorrar.length);

        try {
            for (int i = 0; i < aBorrar.length; i++) {
                for (int j = i + 1; j < elementos.length; j++) {
                    int k = 0;
                    if (j != aBorrar[i]) {
                        elementosProv[k] = elementos[j];
                    }
                }
            }
            elementos = elementosProv;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("La lista no se ha alterado");
        }
        return true;
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
        System.out.println("Insertamos 4 al principio:");
        lista.insertarAlPrincipio(4);
        System.out.println(lista);
        System.out.println("Insertamos 5 al principio:");
        lista.insertarAlPrincipio(5);
        System.out.println(lista);
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

