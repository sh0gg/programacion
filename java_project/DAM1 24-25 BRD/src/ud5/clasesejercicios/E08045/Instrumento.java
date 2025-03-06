package ud5.clasesejercicios.E08045;

import java.util.Arrays;

public abstract class Instrumento {
    enum Nota {DO, RE, MI, FA, SOL, LA, SI}
    Nota[] melodia;

    public Instrumento() {
        this.melodia = new Nota[0];
    }

    public void add(Nota nota) {
        melodia = Arrays.copyOf(melodia, melodia.length+1);
        melodia[melodia.length - 1] = nota;
    }

    public void copiarMelodia(Instrumento instrumento) {
        melodia = Arrays.copyOf(instrumento.melodia, instrumento.melodia.length);
    }

    public abstract void interpretar();

    public static void main(String[] args) {
        // Piano piano = new Piano();
        // piano.add(Nota.DO);
        // piano.add(Nota.RE);
        // piano.add(Nota.MI);
        // piano.add(Nota.FA);
        // piano.add(Nota.SOL);
        // piano.interpretar();

        // Guitarra guitarra = new Guitarra();
        // guitarra.add(Nota.LA);
        // guitarra.add(Nota.FA);
        // guitarra.add(Nota.SOL);
        // guitarra.interpretar();

        // Trompeta trompeta = new Trompeta();
        // trompeta.copiarMelodia(piano);
        // trompeta.interpretar();

        // Oboe oboe = new Oboe();
        // oboe.copiarMelodia(guitarra);
        // oboe.interpretar();


        // System.out.println("Orquesta");
        // Instrumento[] orquesta = {piano, guitarra, trompeta, oboe};
        // for (Instrumento instrumento : orquesta) {
        //     instrumento.interpretar();
        // }

    }

    public void tocar(){
        this.add(Nota.DO);
        this.add(Nota.RE);
        this.add(Nota.FA);

    }
}
