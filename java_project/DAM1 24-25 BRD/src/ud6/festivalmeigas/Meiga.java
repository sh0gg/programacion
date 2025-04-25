package ud6.festivalmeigas;

import java.util.*;

public class Meiga {
    protected String nombre;
    protected String alcume;
    protected List<Feitizo> feitizosFavoritos;
    protected Map<String, Integer> inventario;

    Meiga(String nombre, String alcume) {
        this.nombre = nombre;
        this.alcume = alcume;
    }

    Meiga(String nombre, String alcume, Collection<Feitizo> feitizosFavoritos, Map<String, Integer> inventario ) {
        this.nombre = nombre;
        this.alcume = alcume;
        this.feitizosFavoritos = (List<Feitizo>) feitizosFavoritos;
        this.inventario = inventario;
    }

    public boolean agregarFeitizosFavs(Feitizo feitizo) {
        if (!feitizosFavoritos.contains(feitizo)) {
            feitizosFavoritos.add(feitizo);
        } else {
            return false;
        }
        return true;
    }

    public boolean quitarFeitizosFavs(Feitizo feitizo) {
        if (feitizosFavoritos.contains(feitizo)) {
            feitizosFavoritos.remove(feitizo);
        } else {
            return false;
        }
        return true;
    }

    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
        Random rnd = new Random();

        String[] nomes = {"Uxía", "Lúa", "Iria", "Noa"};
        String[] alcumes = {"A das Fraguiñas", "Sombra do Vento", "Luz do Bosque", "Meiga da Brétema"};

        Meiga[] meigas = new Meiga[nomes.length];

        // Obtén todos os feitozos de exemplo e todos os seus ingredientes únicos
        Collection<Feitizo> feitizosExemplo = List.of(Feitizo.crearFeitizosExemplo());
        Collection<String> ingredientesExemplo = Feitizo.ingredientesUnicos(feitizosExemplo);

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String alcume = alcumes[i];
            // Xera unha colección cunha selección aleatoria de feitizos de exemplo para asignar á meiga
            Collection<Feitizo> feitizos = getFeitizosRnd(feitizosExemplo);
            // Xera un mapa cunha selección aleatoria de ingredientes e cantidades de cada un de exemplo para asignar á meiga
            Map<String, Integer> inventario = getIngredientesRnd(ingredientesExemplo, 3);

            // Crea a meiga e a engade ao array
            meigas[i] = new Meiga(nome, alcume, feitizos, inventario);
        }

        return meigas;

    }

    public static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientesExemplo, int i) {
        Map<String, Integer> ingredientesRnd = new HashMap<>();
        Random rnd = new Random();
        Collections.shuffle(List.of(ingredientesExemplo));
        int numIngredientes = rnd.nextInt(ingredientesExemplo.size()+1);

        for (int j = 0; j < numIngredientes; j++) {
            for (String ingrediente : ingredientesExemplo) {
                ingredientesRnd.put(ingrediente, rnd.nextInt(i)+1);
            }
        }

        return ingredientesRnd;
    }

    public static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizosExemplo) {
        Collection<Feitizo> feitizosRnd = new ArrayList<>();
        Random rnd = new Random();
        Collections.shuffle(List.of(feitizosExemplo));

        for (int i = 0; i < feitizosExemplo.size(); i++) {

        }
        return null;
    }

    public void lanzarFeitizo(Feitizo feitizo) {}

    // Getters e Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlcume() {
        return alcume;
    }

    public void setAlcume(String alcume) {
        this.alcume = alcume;
    }

    public List<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public void setFeitizosFavoritos(List<Feitizo> feitizosFavoritos) {
        this.feitizosFavoritos = feitizosFavoritos;
    }
}
