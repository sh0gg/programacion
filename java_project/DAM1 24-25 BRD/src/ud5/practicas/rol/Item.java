package ud5.practicas.rol;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String nombre;
    private String tipo; // Ej: "Arma", "Armadura", "Poción", "Accesorio"
    private int bonoFuerza;
    private int bonoAgilidad;
    private int bonoConstitucion;

    public Item(String nombre, String tipo, int bonoFuerza, int bonoAgilidad, int bonoConstitucion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.bonoFuerza = bonoFuerza;
        this.bonoAgilidad = bonoAgilidad;
        this.bonoConstitucion = bonoConstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getBonoFuerza() {
        return bonoFuerza;
    }

    public int getBonoAgilidad() {
        return bonoAgilidad;
    }

    public int getBonoConstitucion() {
        return bonoConstitucion;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Bonos: Fuerza +" + bonoFuerza + ", Agilidad +" + bonoAgilidad + ", Constitución +" + bonoConstitucion;
    }

    public static void guardarItems(List<Item> items) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (FileWriter file = new FileWriter("items.json")) {
        gson.toJson(items, file);
    } catch (IOException e) {
        System.out.println("❌ Error al guardar los ítems.");
    }
}

public static List<Item> cargarItems() {
    List<Item> items = new ArrayList<>();
    Gson gson = new Gson();
    try (FileReader reader = new FileReader("items.json")) {
        Type itemListType = new TypeToken<ArrayList<Item>>() {}.getType();
        items = gson.fromJson(reader, itemListType);
    } catch (IOException e) {
        System.out.println("📂 Archivo de ítems no encontrado. Se creará uno nuevo.");
    } catch (Exception e) {
        System.out.println("⚠️ Error al leer ítems. Inicializando lista vacía.");
    }
    return items != null ? items : new ArrayList<>();
}



}
