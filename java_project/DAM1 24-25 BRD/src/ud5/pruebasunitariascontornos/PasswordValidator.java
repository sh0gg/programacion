package ud5.pruebasunitariascontornos;

// POR CARLOS DE LA TORRE Y DAVID BESADA

public class PasswordValidator {

    public static boolean isValid(String password) {
        // 1 INICIO
        if (password.length() < 8) { // 2 ERROR: D
            return false;
        }
        boolean hasUpperCase = false; // 3
        boolean hasDigit = false; // 3
        for (char c : password.toCharArray()) { // 4
            if (Character.isUpperCase(c)) { // 5 --> ERROR: TIENE QUE SER IS UPPER CASE
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) { // 6
                hasDigit = true; // ERROR: TIENE QUE SER TRUE
            }
        }
        return hasUpperCase && hasDigit; // 7 ERROR: HAY QUE CAMBIAR EL || POR &&
    }
    // 8 FIN
}
