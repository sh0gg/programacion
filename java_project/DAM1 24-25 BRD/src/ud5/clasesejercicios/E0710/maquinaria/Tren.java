package ud5.clasesejercicios.E0710.maquinaria;

import ud5.clasesejercicios.E0710.personal.Maquinista;

import java.util.Arrays;

public class Tren {
    static final byte MAX_VAGONES = 5;
    Locomotora locomotora;
    Vagon[] vagones;
    Maquinista maquinista;

    public Tren(Locomotora locomotora, Maquinista maquinista) {
        this(locomotora, maquinista, 0);
    }

    public Tren(Locomotora locomotora, Maquinista maquinista, int numVagones) {
        if (numVagones > MAX_VAGONES) {
            throw new IllegalArgumentException("El número de vagones introducido es mayor que el máximo de vagones permitidos.");
        }

        this.locomotora = locomotora;
        this.maquinista = maquinista;
        vagones = new Vagon[numVagones];
        for (int i = 0; i < numVagones; i++) {
            vagones[i] = new Vagon(i);
        }
    }

    public boolean addVagon(int id, int cargaMaxima, int cargaActual, String tipoMercancia ) {
        if (vagones.length ==  MAX_VAGONES) return false;
        Vagon vagon = new Vagon(id, cargaMaxima, cargaActual, tipoMercancia);
        // Se hace una copia más larga del array
        vagones = Arrays.copyOf(vagones, vagones.length + 1);
        // Se guarda el vagón creado al final
        vagones[vagones.length - 1] = vagon;

        return true;
    }

    @Override
    public String toString() {
        String str = "Tren:\n";
        str += maquinista + "\n";
        str += locomotora + "\n";
        for (Vagon v : vagones) {
            str += "- " + v + "\n";
        }

        str += "\nCarga actual: " + getCargaActual() + " kilos\n";

        return str;
    }

    public int getNumVagones() {
        return vagones.length;
    }

    public int getCargaActual() {
        int cargaActual = 0;
        for (Vagon v : vagones) {
            cargaActual += v.cargaActual;
        }
        return cargaActual;
    }

    public int getCargaMaxima() {
        int cargaMaxima = 0;
        for (Vagon v : vagones) {
            cargaMaxima += v.cargaMaxima;
        }
        return cargaMaxima;
    }
}
