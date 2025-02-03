package ud4.ejercicios30enero;

import java.util.Scanner;

public class Matriculas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de matricula: ");
        String matricula = sc.nextLine();

        System.out.println("¿Es la matrícula válida? " + esMatriculaValida(matricula));
        if (esMatriculaValida(matricula)) {
            System.out.println("La siguiente matrícula sería: " + siguienteMatricula(matricula));
        }
        System.out.print("Introduce otra matrícula: ");
        String matricula2 = sc.nextLine();

        sc.close();

        System.out.println(comparaMatriculas(matricula, matricula2));

    }

    static boolean esMatriculaValida(String matricula) {
        if (matricula == null || matricula.length() != 7)
            return false;

        try {
            Integer.valueOf(matricula.substring(0, 4));
        } catch (NumberFormatException e) {
            return false;
        }

        for (int i = 4; i < matricula.length(); i++) {
            if ("BCDFGHJKLMNPRSTVWXYZ".indexOf(Character.toUpperCase(matricula.charAt(i))) == -1)
                return false;
        }

        return true;
    }

    static String siguienteMatricula(String matricula) {
        boolean meLlevoUno = false;
        Integer nuevoNum = Integer.valueOf(matricula.substring(0, 4)) + 1;
        if (nuevoNum == 10000) {
            nuevoNum = 0000;
            meLlevoUno = true;
        }
        String numeros = String.format("%04d", nuevoNum);

        char[] letras = matricula.substring(4, 7).toUpperCase().toCharArray();

        for (int i = 2; i >= 0; i--) {
            if (meLlevoUno) {
                String letrasValidas = "BCDFGHJKLMNPRSTVWXYZ";
                // incremento la letra
                if (letras[i] == 'Z') {
                    letras[i] = 'B';
                    meLlevoUno = true;
                } else {
                    letras[i] = letrasValidas.charAt(letrasValidas.indexOf(letras[i]) + 1);
                    meLlevoUno = false;
                }
            }
        }

        return numeros + String.valueOf(letras);

    }

    static boolean esLetraValida(char letra) {
        letra = Character.toUpperCase(letra);
        return "BCDFGHJKLMNPRSTVWXYZ".indexOf(letra) != -1;
    }

    static String comparaMatriculas(String m1, String m2) {
        m1 = m1.toUpperCase();
        m2 = m2.toUpperCase();
        int compararLetras = m1.substring(4, 7).compareTo(m2.substring(4, 7));
        if (compararLetras < 0) { // m1 es más antigua
            return m1 + " es más antigua que " + m2;
        } else if (compararLetras > 0) { // m2 es más antigua
            return m2 + " es más antigua que " + m1;
        } else {
            // letras iguales => desempatamos con los números
            int compararNumeros = m1.substring(0, 4).compareTo(m2.substring(0, 4));
            if (compararNumeros < 0) { // m1 es más antigua
                return m1 + " es más antigua que " + m2;
            } else if (compararNumeros > 0) { // m2 es más antigua
                return m2 + " es más antigua que " + m1;
            } else {
                return "¡Son la misma matrícula!";
            }
        }

    }

}
