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

    Meiga(String nombre, String alcume, Collection<Feitizo> feitizosFavoritos, Map<String, Integer> inventario) {
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

        String[] nomes = { "Uxía", "Lúa", "Iria", "Noa" };
        String[] alcumes = { "A das Fraguiñas", "Sombra do Vento", "Luz do Bosque", "Meiga da Brétema" };

        Meiga[] meigas = new Meiga[nomes.length];

        // Obtén todos os feitozos de exemplo e todos os seus ingredientes únicos
        Collection<Feitizo> feitizosExemplo = List.of(Feitizo.crearFeitizosExemplo());
        Collection<String> ingredientesExemplo = Feitizo.ingredientesUnicos(feitizosExemplo);

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String alcume = alcumes[i];
            // Xera unha colección cunha selección aleatoria de feitizos de exemplo para
            // asignar á meiga
            Collection<Feitizo> feitizos = getFeitizosRnd(feitizosExemplo);
            // Xera un mapa cunha selección aleatoria de ingredientes e cantidades de cada
            // un de exemplo para asignar á meiga
            Map<String, Integer> inventario = getIngredientesRnd(ingredientesExemplo, 3);

            // Crea a meiga e a engade ao array
            meigas[i] = new Meiga(nome, alcume, feitizos, inventario);
        }

        return meigas;

    }

    public static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientesExemplo, int i) {
        Map<String, Integer> ingredientesRnd = new HashMap<>();
        List<String> lista = new ArrayList<>(ingredientesExemplo);
        Collections.shuffle(lista);
        Random rnd = new Random();

        int numIngredientes = rnd.nextInt(lista.size()) + 1; // mínimo 1 ingrediente

        for (int i = 0; i < numIngredientes; i++) {
            String ingrediente = lista.get(i);
            int cantidad = rnd.nextInt(maxUnidades) + 1; // entre 1 e maxUnidades
            ingredientesRnd.put(ingrediente, cantidad);
        }

        return ingredientesRnd;
    }

    public static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizosExemplo) {
        List<Feitizo> lista = new ArrayList<>(feitizosExemplo);
        Collections.shuffle(lista);
        return lista.subList(0, Math.min(lista.size()));
    }

    public void lanzarFeitizo(Feitizo feitizo) {
        // Comprobamos se hai suficientes ingredientes
        for (String ingrediente : feitizo.ingredientes) {
            if (!inventario.containsKey(ingrediente) || inventario.get(ingrediente) <= 0) {
                System.out.println("A meiga " + nombre + " non pode lanzar o feitizo \"" + feitizo.nombre
                        + "\". Faltan ingredientes.");
                return;
            }
        }

        // Hai ingredientes: restamos un de cada un
        for (String ingrediente : feitizo.ingredientes) {
            inventario.put(ingrediente, inventario.get(ingrediente) - 1);
        }

        // Borrar o ingrediente do mapa cando se esgota
        if (inventario.get(ingrediente) == 0) {
            inventario.remove(ingrediente);
        }

        System.out.println("A meiga " + nombre + " lanzou o feitizo \"" + feitizo.nombre + "\"!");

    }

    public static List<Meiga> meigasQueCompartenIngrediente(String ingrediente, Collection<Meiga> meigas) {
        List<Meiga> resultado = new ArrayList<>();
        for (Meiga m : meigas) {
            for (Feitizo f : m.feitizosFavoritos) {
                if (f.ingredientes.contains(ingrediente)) {
                    resultado.add(m);
                    break;
                }
            }
        }
        return resultado;
    }

    
    public static Map<Meiga, Feitizo> recomendarFeitizo(String ingrediente, Collection<Feitizo> feitizos, Collection<Meiga> meigas) {
        Map<Meiga, Feitizo> recomendacions = new HashMap<>();
    
        for (Meiga m : meigas) {
            for (Feitizo f : feitizos) {
                if (f.ingredientes.contains(ingrediente) && !m.feitizosFavoritos.contains(f)) {
                    recomendacions.put(m, f);
                    break;
                }
            }
        }
    
        return recomendacions;
    }

    
    public static List<Meiga> ordenarMeigasPorNome(Collection<Meiga> meigas) {
        List<Meiga> lista = new ArrayList<>(meigas);
        lista.sort(Comparator.comparing(Meiga::getNombre));
        return lista;
    }
    
    public static List<Meiga> ordenarMeigasPorNumFeitizos(Collection<Meiga> meigas) {
        List<Meiga> lista = new ArrayList<>(meigas);
        lista.sort(Comparator.comparingInt(m -> m.feitizosFavoritos.size()));
        return lista;
    }
    

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
