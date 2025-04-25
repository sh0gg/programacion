package ud6.festivalmeigas;

import java.util.*;

public class Feitizo {
    protected String nombre;
    protected List<String> ingredientes;
    protected Integer dificultad;

    Feitizo(String nombre, String[] ingredientes, int nivel) {
        this.nombre = nombre;
        this.ingredientes = List.of(ingredientes);
        this.dificultad = nivel;
    }

    public static Feitizo[] crearFeitizosExemplo() {
        String[] ingredientes1 = {"auga de río encantada", "pétalos de rosa silvestre", "fume de lareira"};
        String[] ingredientes2 = {"auga do mar", "salicornia", "berberechos místicos"};
        String[] ingredientes3 = {"raíz de toxo", "auga bendita", "po de estrela fugaz"};
        String[] ingredientes4 = {"auga de río encantada", "raíz de toxo", "pel de serpe"};
        String[] ingredientes5 = {"auga do mar", "po de estrela fugaz", "cinza de bidueiro"};
        String[] ingredientes6 = {"auga bendita", "pétalos de rosa silvestre", "brétema das fragas"};

        Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
        Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
        Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
        Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
        Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
        Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

        return new Feitizo[]{f1, f2, f3, f4, f5, f6};
    }

    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();
        for (Feitizo f : feitizos) {
            for (String i : f.ingredientes) {
                ingredientesUnicos.add(i);
            }
        }

//        for (Feitizo f : feitizos) {
//            ingredientesUnicos.addAll(f.ingredientes);
//        }

        return ingredientesUnicos;
    }

    public static List<Feitizo> feitizosPosibles(Set<String> ingredientes,Collection<Feitizo> feitizos) {
        List<Feitizo> feitizosPosibles = new ArrayList<>();
        for (Feitizo f : feitizos) {
            if (ingredientes.containsAll(f.ingredientes)) {
                feitizosPosibles.add(f);
            }
        }
        return feitizosPosibles;
    }

    public static Map<String, Integer> ingredientesVecesUsados(Collection<Feitizo> feitizos) {
        Map<String, Integer> ingredientesUsados = new HashMap<>();
        for (Feitizo f : feitizos) {
            for (String i : f.ingredientes) {
                if (ingredientesUsados.get(i) == null) {
                    ingredientesUsados.put(i, 1);
                } else{
                    ingredientesUsados.put(i, ingredientesUsados.get(i)+1);
                }
            }
        }
        return ingredientesUsados;
    }

    public boolean addIngrediente(String ingrediente) {
        if (ingredientes.contains(ingrediente)) {
            return false;
        } else {
            ingredientes.add(ingrediente);
        }
        return true;
    }

    public boolean removeIngrediente(String ingrediente) {
        if (!ingredientes.contains(ingrediente)) {
            return false;
        } else {
            ingredientes.remove(ingrediente);
        }
        return true;
    }

    public boolean cambiarIngrediente(String ingredienteViejo, String ingredienteNuevo){
        if (ingredientes.contains(ingredienteNuevo) || !ingredientes.contains(ingredienteViejo)) {
            return false;
        } else {
            ingredientes.remove(ingredienteViejo);
            ingredientes.add(ingredienteNuevo);
        }
        return true;
    }

    public static List<Feitizo> feitizosUsanIngrediente(String ingrediente, Collection<Feitizo> feitizos) {
        List<Feitizo> feitizosUsanIngrediente = new ArrayList<>();
        for (Feitizo f : feitizos) {
            if (f.ingredientes.contains(ingrediente)) {
                feitizosUsanIngrediente.add(f);
            }
        }
        return feitizosUsanIngrediente;
    }
}
