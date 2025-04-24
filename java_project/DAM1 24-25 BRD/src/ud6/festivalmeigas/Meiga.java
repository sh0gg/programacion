package ud6.festivalmeigas;

import java.util.List;

public class Meiga {
    protected String nombre;
    protected String alcume;
    protected List<Feitizo> feitizosFavoritos;

    Meiga(String nombre, String alcume) {
        this.nombre = nombre;
        this.alcume = alcume;
    }

    public boolean agregarFeitizosFavs(Feitizo feitizo) {
        if (!feitizosFavoritos.contains(feitizo)) {
            feitizosFavoritos.add(feitizo);
        } else {
            return false;
        }
        return true;
    }

    public boolean quitarFeitizosFavs(Feitizo feitizo) {
        if (feitizosFavoritos.contains(feitizo)) {
            feitizosFavoritos.remove(feitizo);
        } else {
            return false;
        }
        return true;
    }

    // Getters e Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlcume() {
        return alcume;
    }

    public void setAlcume(String alcume) {
        this.alcume = alcume;
    }

    public List<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public void setFeitizosFavoritos(List<Feitizo> feitizosFavoritos) {
        this.feitizosFavoritos = feitizosFavoritos;
    }
}
