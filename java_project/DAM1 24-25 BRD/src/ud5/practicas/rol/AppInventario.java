package ud5.practicas.rol;

public class AppInventario {
    public static void main(String[] args) throws Exception {
        PersonajeEx arturo = new PersonajeEx("Arturo", "HUMANO", 50, 50, 50, 50, 50, 50);
        Item espada = new Arma("Espada Larga", 3.0, 10000, 60, false);
        Item escudo = new Armadura("Escudo de Hierro", 5.0, 2000, 10, Armadura.Tipo.ESCUDO);

        arturo.addToInventario(espada);
        arturo.addToInventario(escudo);
        arturo.mostrarInventario();

        arturo.equipar(espada);
        arturo.equipar(escudo);
    }
}
