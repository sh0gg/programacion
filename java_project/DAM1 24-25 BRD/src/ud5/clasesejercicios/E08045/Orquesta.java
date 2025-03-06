package ud5.clasesejercicios.E08045;

import ud5.clasesejercicios.E08045.Instrumento.Nota;

public class Orquesta {
    public static void main(String[] args) {
        Piano piano = new Piano();
        piano.add(Nota.DO);
        piano.add(Nota.RE);
        piano.add(Nota.MI);
        piano.add(Nota.FA);
        piano.add(Nota.SOL);
        piano.interpretar();

        Guitarra guitarra = new Guitarra();
        guitarra.add(Nota.LA);
        guitarra.add(Nota.FA);
        guitarra.add(Nota.SOL);
        guitarra.interpretar();

        Trompeta trompeta = new Trompeta();
        trompeta.copiarMelodia(piano);
        trompeta.interpretar();

        Oboe oboe = new Oboe();
        oboe.copiarMelodia(guitarra);
        oboe.interpretar();

        System.out.println("Orquesta");
        Instrumento[] orquesta = {piano, guitarra, trompeta, oboe};
        for (Instrumento instrumento : orquesta) {
            instrumento.interpretar();
        }
    }
    
}
