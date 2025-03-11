package ud5.practicas.mulleres;

public class Escritora extends MullerTraballadora implements IPioneira {
    private String obraMestra;

    public Escritora(String nome, String apelidos, int anoNacemento, String obraMestra) {
        super(nome, apelidos, anoNacemento);
        this.obraMestra = obraMestra;
    }

    @Override
    public String descricionContribucion() {
        return nome + " " + apelidos + " foi unha escritora pioneira coa obra mestra: " + obraMestra;
    }

    @Override
    public String getDescubrimentoOuAporte() {
        return obraMestra;
    }
}