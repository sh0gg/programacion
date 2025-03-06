package ud5.practicas.rol;

import java.util.ArrayList;
import java.util.List;

public class PersonajeEx extends Personaje {
    private int monedas;
    private List<Item> inventario;

    public PersonajeEx(String nombre, String raza, int fuerza, int agilidad, int constitucion,
            int inteligencia, int intuicion, int presencia) throws Exception {
        super(nombre, raza, fuerza, agilidad, constitucion, inteligencia, intuicion, presencia);
        this.monedas = 0;
        this.inventario = new ArrayList<>();
    }

    public boolean addToInventario(Item item) {
        double cargaTotal = inventario.stream().mapToDouble(Item::getPeso).sum();
        double cargaMaxima = 50 + (getConstitucion() * 2);

        if (cargaTotal + item.getPeso() > cargaMaxima) {
            System.out.println("No se puede añadir " + item.getNombre() + ". Excede la carga máxima.");
            return false;
        }
        inventario.add(item);
        return true;
    }

    private Arma itemManoIzq;
    private Arma itemManoDch;
    private Armadura armaduraCabeza;
    private Armadura armaduraCuerpo;

    public boolean equipar(Item item) {
        if (item instanceof Arma) {
            Arma arma = (Arma) item;
            if (arma.esDosManos()) {
                if (itemManoIzq == null && itemManoDch == null) {
                    itemManoIzq = arma;
                    itemManoDch = arma;
                    return true;
                } else {
                    System.out.println("No puedes equipar un arma a dos manos si tienes otra equipada.");
                    return false;
                }
            } else {
                if (itemManoDch == null) {
                    itemManoDch = arma;
                    return true;
                } else if (itemManoIzq == null) {
                    itemManoIzq = arma;
                    return true;
                } else {
                    System.out.println("Ambas manos están ocupadas.");
                    return false;
                }
            }
        } else if (item instanceof Armadura) {
            Armadura armadura = (Armadura) item;
            switch (armadura.getTipo()) {
                case YELMO:
                    if (armaduraCabeza == null) {
                        armaduraCabeza = armadura;
                        return true;
                    }
                    break;
                case ARMADURA:
                    if (armaduraCuerpo == null) {
                        armaduraCuerpo = armadura;
                        return true;
                    }
                    break;
                    case ESCUDO:
                    if (itemManoIzq == null) {
                        itemManoIzq = null;
                        armaduraCabeza = armadura;
                        return true;
                    } else if (itemManoDch == null) {
                        itemManoDch = null;
                        armaduraCuerpo = armadura;
                        return true;
                    }
                    break;
                
            }
        }
        System.out.println("No se pudo equipar " + item.getNombre());
        return false;
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + getNombre() + ":");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i));
        }
        double cargaTotal = inventario.stream().mapToDouble(Item::getPeso).sum();
        System.out.println("Carga total transportada: " + cargaTotal + "/" + (50 + getConstitucion() * 2) + " kilos");
    }
}
