package ud5.clasesejercicios.E08045;

import java.util.Arrays;

public class Piano extends Instrumento {

    @Override
    public void interpretar() {
        System.out.println("Piano: " + Arrays.toString(melodia));
    }

    
}
