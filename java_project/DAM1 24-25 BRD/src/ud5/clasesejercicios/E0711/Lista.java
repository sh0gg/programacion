package ud5.clasesejercicios.E0711;

import java.util.ArrayList;

public class Lista {
    private final ArrayList<Integer> lista;

    // 1. Constructor que inicializa la tabla con tamaño 0
    public Lista() {
        this.lista = new ArrayList<>();
    }

    // 2. Obtener el número de elementos insertados en la lista
    public int obtenerNumeroElementos() {
        return lista.size();
    }

    // 3. Insertar un número al final de la lista
    public void insertarFinal(int numero) {
        lista.add(numero);
    }

    // 4. Insertar un número al principio de la lista
    public void insertarInicio(int numero) {
        lista.addFirst(numero);
    }

    // 5. Insertar un número en un lugar específico de la lista
    public void insertarEnIndice(int indice, int numero) {
        if (indice >= 0 && indice <= lista.size()) {
            lista.add(indice, numero);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // 6. Añadir al final de la lista los elementos de otra lista
    public void añadirLista(Lista otraLista) {
        lista.addAll(otraLista.lista);
    }

    // 7. Eliminar un elemento según su índice
    public void eliminarPorIndice(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // 8. Obtener un elemento según su índice
    public Integer obtenerPorIndice(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        System.out.println("Índice fuera de rango.");
        return null;
    }

    // 9. Buscar un número en la lista y devolver su índice (o -1 si no existe)
    public int buscarNumero(int numero) {
        return lista.indexOf(numero);
    }

    // 10. Mostrar los elementos de la lista por consola
    public void mostrarLista() {
        System.out.println(lista);
    }

    public static void main(String[] args) {
        Lista miLista = new Lista();
        Lista miLista2 = new Lista();

        // Agregamos elementos a miLista
        miLista.insertarFinal(5);
        miLista.insertarFinal(10);
        miLista.insertarInicio(3);
        miLista.insertarEnIndice(1, 7);

        miLista.mostrarLista(); // [3, 7, 5, 10]

        System.out.println("Número de elementos: " + miLista.obtenerNumeroElementos());

        System.out.println("Índice de 10: " + miLista.buscarNumero(10));

        miLista.eliminarPorIndice(2);
        miLista.mostrarLista(); // [3, 7, 10]

        // Agregamos elementos a miLista2
        miLista2.insertarFinal(20);
        miLista2.insertarFinal(30);
        miLista2.insertarFinal(40);

        System.out.println("Lista 2 antes de añadir a la lista 1:");
        miLista2.mostrarLista(); // [20, 30, 40]

        // Añadir miLista2 a miLista
        miLista.añadirLista(miLista2);

        System.out.println("Lista 1 después de añadir Lista 2:");
        miLista.mostrarLista(); // [3, 7, 10, 20, 30, 40]

        // Obtener un elemento por su índice
        int indiceBuscado = 2;
        Integer elemento = miLista.obtenerPorIndice(indiceBuscado);
        if (elemento != null) {
            System.out.println("Elemento en el índice " + indiceBuscado + ": " + elemento);
        }
    }


}
