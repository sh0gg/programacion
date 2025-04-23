package ud6.ejerciciosstream;

import ud6.colecciones.Cliente;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InterfacesFuncionales {
    public static void main(String[] args) {

        // Interfaz PREDICATE

        Predicate<Integer> esPar = new Predicate<>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        };

        esPar.test(10); //true
        esPar.test(11); //false

        Predicate<Integer> esPositivo = x -> x > 0;
        esPositivo.test(10); //true
        esPositivo.test(-10); //false

        esPositivo.negate().test(-10); //true
        esPositivo.and(esPar).test(6); //true
        esPositivo.or(esPar).test(-6); //true

        Predicate<Integer> esPositivoYPar = esPar.and(esPositivo);
        esPositivoYPar.test(10); //true
        esPositivoYPar.test(5); //false
        esPositivoYPar.test(-6); //false

        // Interfaz FUNCTION

        Function<Integer,String> convertirAString = t -> String.valueOf(t);

        String resultado1 = convertirAString.apply(5);
        System.out.println(resultado1);
        String resultado2 = convertirAString.apply(10);
        System.out.println(resultado2);

        Function<Double,Double> cuadrado = x -> x * x;
        Double resultado3 = cuadrado.apply(5.0); // 25.0

        Function<Cliente, Integer> obtenerEdad = c -> c.edad();
        Integer edadPepe = obtenerEdad.apply(new Cliente("1", "Pepe", "20/12/1890"));
        System.out.println("Pepe tiene " + edadPepe + " años");

        // Interfaz CONSUMER

        Consumer<Cliente> saludoClie = c -> System.out.println("Hola " + c.getNombre());
        saludoClie.accept(new Cliente("12345678Z","Pepe","20/10/1999"));

        System.out.println("\nSALUDOS:\n");
        List<Cliente> clientes = Cliente.clientesDeEjemplo();
        clientes.forEach(saludoClie); // Hola Pepe, Hola María, Hola Lola

    }
}
