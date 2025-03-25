package ud6.apuntesgenericos;

import java.util.Arrays;

public class ContenedorLista<T> {
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
        return null;
    }

    T extraerAlFinal() {
        return null;
    }

    void ordenar() {

    }

    @Override
    public String toString() {
        return Arrays.toString(elementos);
    }

    public static void main(String[] args) {
        ContenedorLista<Integer> lista = new ContenedorLista<>(new Integer[0]);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);
        System.out.println(lista);

        ContenedorLista<Persona> listaP = new ContenedorLista<Persona>(new Persona[0]);
        listaP.insertarAlFinal(new Persona("Pepe"));
        listaP.insertarAlFinal(new Persona("Maria"));
        listaP.insertarAlFinal(new Persona("Lola"));
        System.out.println(listaP);

    }

}

