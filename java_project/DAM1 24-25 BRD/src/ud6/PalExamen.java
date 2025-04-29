package ud6;

import java.util.*;
import java.util.stream.Collectors;

public class PalExamen {

    public static void main(String[] args) {

        // === Collection - ArrayList ===
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("María");
        System.out.println("Contenido de nombres: " + nombres);

        nombres.remove("Pedro");
        System.out.println("Contenido después de eliminar Pedro: " + nombres);

        System.out.println("¿Está Ana? " + nombres.contains("Ana"));
        System.out.println("¿La colección está vacía? " + nombres.isEmpty());
        System.out.println("Tamaño de la colección: " + nombres.size());

        nombres.add(1, "Carlos");
        System.out.println("Lista con Carlos insertado en la posición 1: " + nombres);

        String segundoNombre = nombres.get(1);
        System.out.println("Elemento en posición 1: " + segundoNombre);

        // === Set - HashSet ===
        Set<String> frutas = new HashSet<>();
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Manzana"); // Ignorado
        System.out.println("Contenido del conjunto frutas: " + frutas);

        // === Map - HashMap ===
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Pedro", 30);
        edades.put("María", 28);

        System.out.println("Mapa de edades: " + edades);

        int edadAna = edades.get("Ana");
        System.out.println("Edad de Ana: " + edadAna);

        edades.remove("Pedro");
        System.out.println("Mapa después de eliminar Pedro: " + edades);

        boolean contieneMaria = edades.containsKey("María");
        System.out.println("¿Está María en el mapa? " + contieneMaria);

        // === Iteradores ===
        Iterator<String> it = nombres.iterator();
        while (it.hasNext()) {
            System.out.println("Iterador: " + it.next());
        }

        // === Collections utilidades ===
        Collections.sort(nombres);
        Collections.shuffle(nombres);
        Collections.reverse(nombres);
        System.out.println("Max: " + Collections.max(nombres));
        System.out.println("Min: " + Collections.min(nombres));

        // === Comparator y Lambda ===
        nombres.sort((a, b) -> a.length() - b.length());
        nombres.sort(Comparator.comparingInt(String::length));

        // === Streams ===
        List<String> procesado = nombres.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Procesado con Stream: " + procesado);

        long cuenta = nombres.stream().filter(n -> n.startsWith("A")).count();
        System.out.println("Empiezan por A: " + cuenta);

        String resultadoReducido = nombres.stream().reduce("", (a, b) -> a + b);
        System.out.println("Reducido: " + resultadoReducido);

        // === Genéricos: uso de métodos genéricos ===
        String[] array = {"uno", "dos", "tres"};
        System.out.println("¿Contiene 'dos'? " + contiene("dos", array));

        Integer[] nums = {1, 2, 3};
        Integer[] nuevoArray = agregarAlFinal(4, nums);
        System.out.println("Array con nuevo valor: " + Arrays.toString(nuevoArray));

        // === Interfaz funcional personalizada ===
        Operacion<Integer> suma = Calculos::sumar;
        System.out.println("Suma con referencia a método: " + suma.aplicar(2, 3));
    }

    // === Métodos Genéricos ===
    public static <U> boolean contiene(U elemento, U[] array) {
        for (U e : array)
            if (e.equals(elemento))
                return true;
        return false;
    }

    public static <U> U[] agregarAlFinal(U e, U[] t) {
        U[] nuevo = Arrays.copyOf(t, t.length + 1);
        nuevo[nuevo.length - 1] = e;
        return nuevo;
    }

    public static <U> U[] concatenar(U[] t1, U[] t2) {
        U[] resultado = Arrays.copyOf(t1, t1.length + t2.length);
        System.arraycopy(t2, 0, resultado, t1.length, t2.length);
        return resultado;
    }
}

// === Clases y interfaces auxiliares fuera de main ===

class Caja<T> {
    private T contenido;
    public void guardar(T valor) { contenido = valor; }
    public T sacar() { return contenido; }
}

@FunctionalInterface
interface Operacion<T> {
    T aplicar(T a, T b);
}

class Calculos {
    public static Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}

interface Pila<T> {
    void apilar(T e);
    T desapilar();
}

interface Cola<T> {
    void encolar(T e);
    T desencolar();
}

class ContenedorLista<T> implements Pila<T>, Cola<T> {
    private List<T> lista = new ArrayList<>();

    public void apilar(T e) { lista.add(e); }
    public T desapilar() { return lista.remove(lista.size() - 1); }

    public void encolar(T e) { lista.add(e); }
    public T desencolar() { return lista.remove(0); }
}

/*
=====================================
📚 ANEXO CHULETA JAVA - Colecciones, Genéricos, Streams
Archivo: PalExamen.java
=====================================

--- GENÉRICOS ---
- Una clase genérica se define como: class Nombre<T> { ... }
- Un método genérico se define como: public static <T> T metodo(T parametro) { ... }
- Puedes limitar tipos genéricos con extends: <T extends Number>.

--- COLLECTION, LIST, SET, MAP ---
- Collection<E> → Métodos comunes: add(), remove(), contains(), size(), isEmpty(), clear().
- List<E> (ArrayList, LinkedList):
    * Permite duplicados.
    * Mantiene el orden de inserción.
    * Acceso por índice: get(), set(), add(index, element).
- Set<E> (HashSet, TreeSet):
    * No permite duplicados.
    * El orden depende del tipo de Set.
- Map<K, V> (HashMap, TreeMap):
    * Pares clave-valor únicos (no se repiten claves).
    * get(), put(), remove(), containsKey(), keySet(), values().

--- ITERADORES ---
- Se usa iterator() para recorrer colecciones:
    Iterator<E> it = coleccion.iterator();
    while(it.hasNext()) { it.next(); }
- Para eliminar mientras recorres: it.remove().

--- CLASE COLLECTIONS ---
- sort(list) → Ordenar.
- shuffle(list) → Mezclar aleatoriamente.
- reverse(list) → Invertir orden.
- max(list), min(list) → Máximo/mínimo.

--- STREAMS (Java 8+) ---
- Crear Stream: lista.stream()
- Operaciones intermedias:
    * filter() → filtrar elementos.
    * map() → transformar elementos.
    * sorted() → ordenar.
    * distinct() → eliminar duplicados.
- Operaciones terminales:
    * forEach() → recorrer.
    * collect() → recoger resultado en una lista/conjunto/etc.
    * count() → contar elementos.
    * reduce() → reducción a un solo valor.
- Crear Stream a partir de Arrays: Arrays.stream(array).

--- EXPRESIONES LAMBDA ---
- Sintaxis: (param1, param2) -> { cuerpo }
- Ejemplo: lista.sort((a, b) -> a.length() - b.length());
- Se usan para implementar interfaces funcionales como Comparator, Predicate, Function, Consumer.

--- REFERENCIAS A MÉTODOS ---
- Para métodos estáticos: Clase::metodo
- Para métodos de instancia: objeto::metodo
- Para constructores: Clase::new

--- INTERFACES FUNCIONALES COMUNES ---
- Predicate<T> → boolean test(T t)
- Function<T,R> → R apply(T t)
- Consumer<T> → void accept(T t)
- Supplier<T> → T get()

--- RECORDATORIOS RÁPIDOS ---
- List → ordenados y duplicados permitidos.
- Set → sin duplicados, orden no garantizado.
- Map → clave-valor, claves únicas.
- Stream → procesamiento funcional de datos.
- <> → operador diamante para inferencia de tipos.
- ? → comodín genérico (Wildcard).

--- TRUCOS EXTRA ---
- No puedes hacer: new T[10] en clases genéricas.
- Para eliminar mientras recorres usa Iterator, no for-each.
- Para ordenar elementos personalizados, usa Comparator o implementa Comparable.

=====================================
FIN DEL ANEXO
=====================================
*/
