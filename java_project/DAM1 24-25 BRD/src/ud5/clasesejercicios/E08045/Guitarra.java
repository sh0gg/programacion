package ud5.clasesejercicios.E08045;

import java.util.Arrays;

public class Guitarra extends Instrumento {

    @Override
    public void interpretar() {
        System.out.println("Guitarra: " + Arrays.toString(melodia));
    }
}
