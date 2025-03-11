package ud5.practicas.mulleres;

public class Sindicalista extends MullerTraballadora implements IActivista {
    private String movementoDefendido;

    public Sindicalista(String nome, String apelidos, int anoNacemento, String movementoDefendido) {
        super(nome, apelidos, anoNacemento);
        this.movementoDefendido = movementoDefendido;
    }

    @Override
    public String descricionContribucion() {
        return nome + " " + apelidos + " foi unha sindicalista destacada por: " + movementoDefendido;
    }

    @Override
    public String getCausaDefendida() {
        return movementoDefendido;
    }
}

