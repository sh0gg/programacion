package ud5.practicas.Inmobiliaria;

import java.util.Arrays;
import java.util.Comparator;


public class Inmobiliaria {
    public static void main(String[] args) {
        // 1.1. Modelo de Clases
// Crea un piso en una 5a planta, de 100 m2, 3 habitaciones y 2 baños en la
       // dirección “Calle Curtidoira”. Establece los precios de alquiler y de Venta.
        Inmueble piso1 = new Piso("Calle Curtidoira", 100, 3, 2, 5);
        piso1.setPrecioAlquiler(500);
        piso1.setPrecioVenta(200000);
// Crea otros dos pisos
        Inmueble piso2 = new Piso("Praza Maior", 80, 2, 2, 3);
        piso2.setPrecioAlquiler(400);
        Inmueble piso3 = new Piso("Calle Rosalía de Castro", 140, 4, 2, 2);
        piso3.setPrecioVenta(250000);
// Crea una casa de 250 m2 construídos, 3000 m2 de terreno, 4 habitaciones y 3
       // baños en la dirección “Carretera de Marín”.
        Inmueble casa1 = new Casa("Carretera de Marín", 250, 4, 3, 3000);
        casa1.setPrecioAlquiler(800);
        casa1.setPrecioVenta(350000);
// Crea otra casa
        Inmueble casa2 = new Casa("Lapaman", 150, 3, 2, 1000);
        casa2.setPrecioVenta(400000);
// Imprimir Inmueble: Piso, Casa
        System.out.println(piso1);
        System.out.println(casa1);
        System.out.println("");
// Mostrar Detalle Inmueble: Piso, Casa
        System.out.println(piso1.detalle());
        System.out.println("");
        System.out.println(piso2.detalle());
        System.out.println("");
        System.out.println(casa2.detalle());

        Inmueble[] arrayInmuebles = new Inmueble[] {
                piso1, piso2, piso3, casa1, casa2
        };

        // 1.2. Lista de inmuebles

        System.out.println("\nTODOS LOS INMUEBLES: ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Inmuebles ordenados por direccion
        Comparator ordenAlfabeticoDireccion = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Inmueble) o1).getDireccion().compareTo(((Inmueble) o2).getDireccion());
            }
        };

        Arrays.sort(arrayInmuebles, ordenAlfabeticoDireccion);
        System.out.println("\nINMUEBLES ORDENADOS ALFABÉTICAMENTE: ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Inmuebles ordenados por metros cuadrados
        Comparator ordenMetrosAsc = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                int metros1 = ((Inmueble) o1).getMetrosCuadrados();
                int metros2 = ((Inmueble) o2).getMetrosCuadrados();

                return metros1 - metros2;
            }
        };

        Arrays.sort(arrayInmuebles, ordenMetrosAsc);
        System.out.println("\nINMUEBLES ORDENADOS POR m2 (ascendente): ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Ordena Inmuebles por m2 (de mayor a menor)

        Inmueble.sortMetrosDesc(arrayInmuebles);
        // Arrays.sort(arrayInmuebles, ordenMetrosAsc.reversed());
        System.out.println("\nINMUEBLES ORDENADOS POR m2 (descendente): ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Ordena Inmuebles por numHabitaciones y luego por m2 (de mayor a menor)

        Inmueble.sortHabMetrosDesc(arrayInmuebles);
        System.out.println("\nINMUEBLES ORDENADOS POR NUM DE HABITACIONES Y m2 (de mayor a menor): ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Ordena Inmuebles por precio de alquiler (de menos a mayor)

        Inmueble.sortPrecioAlquilerAsc(arrayInmuebles);
        System.out.println("\nINMUEBLES ORDENADOS POR PRECIO ALQUILER (MENOR A MAYOR): ");
        Inmueble.mostrarInmuebles(arrayInmuebles);

        // Ordena Inmuebles por precio Venta (de menor a mayor)

        Inmueble.sortPrecioVentaAsc(arrayInmuebles);
        System.out.println("\nINMUEBLES ORDENADOS POR PRECIO VENTA (MENOR A MAYOR): ");
        Inmueble.mostrarInmuebles(arrayInmuebles);





    }

}
