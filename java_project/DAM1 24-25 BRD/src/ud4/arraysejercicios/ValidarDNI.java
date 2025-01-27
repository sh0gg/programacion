package ud4.arraysejercicios;

public class ValidarDNI {
    boolean esValidoDNI(int numero, char letra) {
        String letras = "";
        char[] letrasArray = letras.toCharArray();
        return letrasArray[numero % 23] == letra;
    }
    
}
