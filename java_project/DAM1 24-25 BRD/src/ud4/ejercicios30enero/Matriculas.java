package ud4.ejercicios30enero;

import java.util.Scanner;

public class Matriculas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de matricula");
        String matricula = sc.nextLine();

        System.out.println("¿Es la matrícula válida? " + esMatriculaValida(matricula));
        if (esMatriculaValida(matricula)) {
            System.out.println("La siguiente matrícula sería: " + siguienteMatricula(matricula));
        }

    }

    static boolean esMatriculaValida(String matricula) {
        char[] matriculaArray = matricula.toCharArray();
        for (int i = 0; i < matriculaArray.length - 3; i++) {
            if (!Character.isDigit(matriculaArray[i])) {
                return false;
            }
        }
        for (int i = 5; i < matriculaArray.length; i++) {
            return esLetraValida(matriculaArray[i]);
        }
        return false;
    }

    static String siguienteMatricula(String matricula) {
        char[] matriculaArray = matricula.toCharArray();
        for (int i = matriculaArray.length; i < 0; i--) {
            if (matriculaArray[i] == '9') {
                matriculaArray[i] = '0';
            } else {
                matriculaArray[i] = (char) (matriculaArray[i] + 1);
            }
        }

        if (matriculaArray[0] == 0 && matriculaArray[1] == 0 && matriculaArray[2] == 0 && matriculaArray[3] == 0) {
            for (int i = matriculaArray.length; i < matriculaArray.length - 3; i--) {
                if (matriculaArray[i] == 'Z') {
                    matriculaArray[i] = 'A';
                } else {
                    matriculaArray[i] = (char) (matriculaArray[i] + 1);
                }
            }
        }

        String siguienteMatricula = matriculaArray.toString();
        return siguienteMatricula;
    }

    static boolean esLetraValida(char letra) {
        return switch (letra) {
            case 'a', 'e', 'i', 'o', 'u', 'ñ', 'q' -> false;
            default -> true;
        };
    }

}
