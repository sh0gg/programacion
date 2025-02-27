package ud5.practicas.rol.versionOldModernaNOTOCAR;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class Item {
    private String id;
    private String nombre;
    private String tipo; // Ej: "Arma", "Armadura", "Poción", "Accesorio"
    private int bonoFuerza, bonoAgilidad, bonoConstitucion;

    public Item(String id, String nombre, String tipo, int bonoFuerza, int bonoAgilidad, int bonoConstitucion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.bonoFuerza = bonoFuerza;
        this.bonoAgilidad = bonoAgilidad;
        this.bonoConstitucion = bonoConstitucion;
    }

    public String getId() {
        return id;
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

}

