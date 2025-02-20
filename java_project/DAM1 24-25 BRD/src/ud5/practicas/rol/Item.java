package ud5.practicas.rol;

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

}

