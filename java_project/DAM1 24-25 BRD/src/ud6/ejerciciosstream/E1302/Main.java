package ud6.ejerciciosstream.E1302;


import ud6.colecciones.Academico;
import ud6.colecciones.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Saludo<String> stringSaludo = (str) -> "Hola " + str;

        Saludo<Academico> academicoSaludo = (academico) -> "Buenos días " + academico.getNombre();

        System.out.println(stringSaludo.saludar("Pepe"));

        System.out.println(academicoSaludo.saludar(new Academico("Pepe", 1990)));

        // Metodo para saludar grupos (E1302)

        String[] tString = {"Pepe", "María", "Marcos"};
        List<String> saludos = saludar(stringSaludo, tString);
        System.out.println(saludos);

        Academico[] academicos = {new Academico("Pepe", 1990), new Academico("Jose", 1991), new Academico("Maria", 1992)};
        List<String> saluditos = saludar((academico) -> "Que tal, " + academico.getNombre() + "?", academicos);
        System.out.println(saluditos);

        // static max (E1303)

        Cliente[] clientes = {new Cliente("1233123A", "Pepe", "10/01/2002"), new Cliente("1233123B", "Jose", "10/01/1999"), new Cliente("1233123C", "Maria", "10/01/2001")};
        Comparator<Cliente> c = new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o2.edad() - o1.edad();
            };
        };
        System.out.println(max(clientes, c));

    }

    static <T> List<String> saludar(Saludo<T> s, T[] t) {
        List<String> saludos = new ArrayList<>();
        for (T e : t) {
            saludos.add(s.saludar(e));
        }
        return saludos;
    }

    static <T> T max(T[] t, Comparator<T> c) {
        Arrays.sort(t, c);
        return t[t.length - 1];
    }
}
