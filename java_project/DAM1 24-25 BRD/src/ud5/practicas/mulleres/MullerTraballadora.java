package ud5.practicas.mulleres;

public abstract class MullerTraballadora {
    protected String nome;
    protected String apelidos;
    protected int anoNacemento;

    public abstract String descricionContribucion();

    public int getIdade(int anoActual) {
        int idade = anoActual - getAnoNacemento();
        return idade;
    }

    // CONSTRUCTORES

    public MullerTraballadora(String nome, String apelidos, int anoNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNacemento = anoNacemento;
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nome;
    }

    public void setNombre(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public int getAnoNacemento() {
        return anoNacemento;
    }

    public void setAnoNacemento(int anoNacemento) {
        this.anoNacemento = anoNacemento;
    }

    public static void main(String[] args) {
        // Instanciación de mulleres destacadas
        Cientifica marieCurie = new Cientifica("Marie", "Curie", 1867, "Descubriu o radio e o polonio");
        Artista fridaKahlo = new Artista("Frida", "Kahlo", 1907, "Surrealismo e pintura autobiográfica");
        Politica rosaParks = new Politica("Rosa", "Parks", 1913, "Loita polos dereitos civís e contra a segregación racial");
        Cientifica adaLovelace = new Cientifica("Ada", "Lovelace", 1815, "Primeira programadora da historia");
        Escritora virginiaWoolf = new Escritora("Virginia", "Woolf", 1882, "Orlando e Un cuarto de seu");
        Deportista serenaWilliams = new Deportista("Serena", "Williams", 1981, "Ser a tenista con máis títulos de Grand Slam na era aberta");
        Sindicalista claraCampoamor = new Sindicalista("Clara", "Campoamor", 1888, "Conseguíu o sufraxio feminino en España en 1931");

        MullerTraballadora[] mulleres = {marieCurie, fridaKahlo, rosaParks, adaLovelace, virginiaWoolf, serenaWilliams, claraCampoamor};

        // Mostrando as contribucións
        System.out.println("=== Mulleres Traballadoras Destacadas ===");
        for (MullerTraballadora muller : mulleres) {
            System.out.println(muller.descricionContribucion());
        }

        // Mostrando os aportes específicos segundo a súa interface
        System.out.println("\n=== Detalles Específicos ===");
        for (MullerTraballadora muller : mulleres) {
            if (muller instanceof IPioneira) {
                System.out.println(muller.nome + " foi pioneira en: " + ((IPioneira) muller).getDescubrimentoOuAporte());
            }
            if (muller instanceof IActivista) {
                System.out.println(muller.nome + " defendeu a causa: " + ((IActivista) muller).getCausaDefendida());
            }
        }
    }
}


