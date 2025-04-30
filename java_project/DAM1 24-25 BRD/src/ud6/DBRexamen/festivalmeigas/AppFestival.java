package ud6.DBRexamen.festivalmeigas;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN UD6 PROGRAMACIÓN

import java.util.*;

public class AppFestival {

    public static void main(String[] args) {
        System.out.println("\nFESTIVAL DE MEIGAS");
        System.out.println("==================\n");
        // Crea un array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());

        // DONE: Ordena as Meigas de menor a maior número de feitizos
        Arrays.sort(meigasExemplo, (o1, o2) -> o2.getFeitizos().size() - o1.getFeitizos().size());

        // Para cada meiga do festival, imprime os seus datos, lanza os
        // feitizos posibles, e imprime os puntos obtidos.
        Map<Meiga, Integer> puntuacion = new HashMap<>();

        for (Meiga meiga : meigasExemplo) {
            System.out.println("MEIGA: ");
            System.out.println(meiga);
            int puntos = meiga.lanzarFeitizos();
            System.out.println("TOTAL PUNTOS: " + puntos + "\n\n");
            puntuacion.put(meiga, puntos);
        }

        // Amosa a clasificación final do festival
        System.out.println("Clasificación Final do Festival: ");
        for (Meiga meiga : puntuacion.keySet()) {
            System.out.println(meiga.getNome() + " (" + meiga.getAlcume() + ") con " + puntuacion.get(meiga) + " puntos." );
        }

        System.out.println("\nFIN DO FESTIVAL DE MEIGAS\n");
    }

}
