package contornos.ud3.examenContornosUD3DavidBesada;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN CONTORNOS UD3

public class EmailValidator {
    public static boolean isValid(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }
        String[] parts = email.split("@");
        if (parts.length != 2 || parts[0].isEmpty()) {
            return false;
        }
        return parts[1].contains(".");
    }
}
