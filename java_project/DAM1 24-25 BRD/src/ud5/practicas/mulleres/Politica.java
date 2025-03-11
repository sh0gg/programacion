package ud5.practicas.mulleres;

public class Politica extends MullerTraballadora implements IActivista {
    private String causa;

    public Politica(String nome, String apelidos, int anoNacemento, String causa) {
        super(nome, apelidos, anoNacemento);
        this.causa = causa;
    }

    @Override
    public String descricionContribucion() {
        return nome + " " + apelidos + " foi unha política e activista destacada por: " + causa;
    }

    @Override
    public String getCausaDefendida() {
        return causa;
    }
}