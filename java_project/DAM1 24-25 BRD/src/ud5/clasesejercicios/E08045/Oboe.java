package ud5.clasesejercicios.E08045;

import java.util.Arrays;

public class Oboe extends Instrumento{

    @Override
    public void interpretar() {
        System.out.println("Oboe: " + Arrays.toString(melodia));
    }
}
