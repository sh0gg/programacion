package ud5.clasesejercicios.E08045;

import java.util.Arrays;

public class Trompeta extends Instrumento {

    @Override
    public void interpretar() {
        System.out.println("Trompeta: " + Arrays.toString(melodia));
    }
}
