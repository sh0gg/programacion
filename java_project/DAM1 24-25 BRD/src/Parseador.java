import java.util.Arrays;

public class Parseador {
    public boolean checkList (String linea) {
        
        char[] arrayLinea = linea.toCharArray();
        char[] arraySignos = new char[];

        for (char c : arrayLinea) {
            if ( c == '(') {
                arraySignos = Arrays.copyOf(arraySignos, arraySignos.length + 1)
                arraySignos[arraySignos.length - 1] = c;
            }
            if ( c == '[') {
                arraySignos = Arrays.copyOf(arraySignos, arraySignos.length + 1)
                arraySignos[arraySignos.length - 1] = c;
            }
            if ( c == ')') {
                arraySignos = Arrays.copyOf(arraySignos, arraySignos.length + 1)
                arraySignos[arraySignos.length - 1] = c;
            }
            if ( c == ']') {
                arraySignos = Arrays.copyOf(arraySignos, arraySignos.length + 1)
                arraySignos[arraySignos.length - 1] = c;
            }
        }

        for (char c : arraySignos) {
            if (c==')')
        }


    }
    
}
