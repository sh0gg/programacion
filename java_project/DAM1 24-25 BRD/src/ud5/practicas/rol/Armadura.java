package ud5.practicas.rol;

public class Armadura extends Item {
    public enum Tipo { YELMO, ARMADURA, ESCUDO }

    private int defensa;
    private Tipo tipo;

    public Armadura(String nombre, double peso, int precioBase, int defensa, Tipo tipo) {
        super(nombre, peso, precioBase);
        this.defensa = defensa;
        this.tipo = tipo;
    }

    public int getDefensa() { return defensa; }
    public Tipo getTipo() { return tipo; }

    @Override
    public String toString() {
        return super.toString() + ", Defensa: " + defensa + " (" + tipo + ")";
    }
}
