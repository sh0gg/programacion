package ud6.apuntesgenericos;

import java.util.Arrays;

public class E1201_MetodosGenericos {

    static <U> int numeroDeNulos(U[] tabla) {
        int cont = 0;
        for (U e : tabla)
            if (e == null)
                cont++;
        return cont;
    }

    public static <U> U[] add(U e, U[] t) {
        t = Arrays.copyOf(t, t.length + 1);
        t[t.length - 1] = e;
        return t;
    }

    public static <U> boolean buscar(U e, U[] t) {
        boolean result = false;
        for (int i = 0; i < t.length; i++) {
            if ( (e == null && t[i] == null) || (e.equals(t[i]) && t[i] != null)) {
                result = true;
            }
        }
        return result;
    }

    public static <U> U[] concatenar(U[] t1, U[] t2) {
        U[] t3 = Arrays.copyOf(t1, t1.length + t2.length);
        int j = 0;
        for (int i = t1.length; i < t3.length; i++) {
            t3[i] = t2[j];
            j++;
        }
        return t3;
    }

    public static <U, V> Object[] concatenar2(U[] t1, V[] t2) {
        Object[] t3 = Arrays.copyOf(t1, t1.length + t2.length);
        for (int i = 0; i < t2.length; i++) {
            t3[t1.length + 1] = t2[i];
        }
        return t3;
    }

    public static void main(String[] args) {
        Integer[] numeros = {3, 5, 8, null, 2, null};
        Persona[] personas = {new Persona("Pepe"), null, new Persona("María")};

        System.out.println(numeroDeNulos(numeros));
        System.out.println(numeroDeNulos(personas));

        numeros = add(7, numeros);
        System.out.println(Arrays.toString(numeros));
        personas = add(new Persona("Juancho"), personas);
        System.out.println(Arrays.toString(personas));

        System.out.println("Hay un 8 en números? " + buscar(8, numeros));
        System.out.println("Hay un 6 en números? " + buscar(6, numeros));
        System.out.println("Hay un null en números? " + buscar(null, numeros));

        System.out.println("Está Pepe? " + buscar(new Persona("Pepe"), personas));

        Integer[] numeros2 = {23, 45, 78, 23};
        Integer[] masNumeros = concatenar(numeros, numeros2);
        System.out.println(Arrays.toString(masNumeros));
    }

}
