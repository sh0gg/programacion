package ud6.festivalmeigas;

import java.util.List;
import java.util.Set;

import static ud6.festivalmeigas.Feitizo.*;

public class Main {
    public static void main(String[] args) {
        Feitizo[] feitizos = crearFeitizosExemplo();
        System.out.println(ingredientesUnicos(List.of(feitizos)));

        String[] ingredientes = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira",
                "auga do mar", "salicornia", "berberechos místicos", "po de estrela fugaz", "cinza de bidueiro" };

        System.out.println(feitizosPosibles(Set.of(ingredientes), List.of(crearFeitizosExemplo())));
    }

}
