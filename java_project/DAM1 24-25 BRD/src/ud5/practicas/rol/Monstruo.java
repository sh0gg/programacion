package ud5.practicas.rol;

import java.util.Random;

public class Monstruo extends Personaje {
    private int ataque, defensa, velocidad;

    private static final Random rand = new Random();

    public Monstruo(String nombre, int ataque, int defensa, int velocidad, int puntosVida) {
        super(nombre, ataque, defensa, velocidad);
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        setPuntosVida(puntosVida);
    }

    @Override
    public int atacar(Personaje enemigo) {
        int ataqueTotal = ataque + rand.nextInt(100) + 1;
        int defensaTotal = enemigo.getAgilidad() + rand.nextInt(100) + 1;

        int dano = Math.max(0, ataqueTotal - defensaTotal);
        if (dano > enemigo.getPuntosVida())
            dano = enemigo.getPuntosVida();
        enemigo.perderVida(dano);

        return dano;
    }

    @Override
    public void mostrar() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return getNombre() + " - " + getClass().getSimpleName() + " (" + getPuntosVida() + "/" + getMaxPuntosVida() + ")";
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public static Random getRand() {
        return rand;
    }

}
