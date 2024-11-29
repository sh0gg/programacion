package ud2.ejerciciosbucles;

import java.util.Scanner;

public class NumerosEnTextoMillonEntrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entre 1 y 1,000,000: ");
        int numero = scanner.nextInt();

        if (numero < 1 || numero > 1_000_000) {
            System.out.println("El número debe estar entre 1 y 1,000,000.");
        } else {
            System.out.println(numero + ". " + convertirATexto(numero));
        }
        scanner.close();
    }

    public static String convertirATexto(int numero) {
        if (numero == 1_000_000) {
            return "un millón";
        }

        if (numero < 10)
            return unidadATexto(numero);
        if (numero < 20)
            return especialATexto(numero);
        if (numero < 100)
            return decenaATexto(numero);

        int centena = numero / 100;
        int resto = numero % 100;
        if (numero < 1000) {
            return (centena == 1 && resto == 0 ? "cien" : centenaATexto(centena)) +
                    (resto == 0 ? "" : " " + convertirATexto(resto));
        }

        int miles = numero / 1000;
        resto = numero % 1000;
        if (numero < 1_000_000) {
            return (miles == 1 ? "mil" : convertirATexto(miles) + " mil") +
                    (resto == 0 ? "" : " " + convertirATexto(resto));
        }

        return "";
    }

    private static String unidadATexto(int numero) {
        switch (numero) {
            case 1:
                return "uno";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "cuatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "siete";
            case 8:
                return "ocho";
            case 9:
                return "nueve";
            default:
                return "";
        }
    }

    private static String especialATexto(int numero) {
        switch (numero) {
            case 10:
                return "diez";
            case 11:
                return "once";
            case 12:
                return "doce";
            case 13:
                return "trece";
            case 14:
                return "catorce";
            case 15:
                return "quince";
            case 16:
                return "dieciséis";
            case 17:
                return "diecisiete";
            case 18:
                return "dieciocho";
            case 19:
                return "diecinueve";
            default:
                return "";
        }
    }

    private static String decenaATexto(int numero) {
        int decena = numero / 10;
        int unidad = numero % 10;
        String decenaTexto;

        switch (decena) {
            case 1:
                return especialATexto(numero); // Esto cubre del 10 al 19
            case 2:
                decenaTexto = "veinte";
                break;
            case 3:
                decenaTexto = "treinta";
                break;
            case 4:
                decenaTexto = "cuarenta";
                break;
            case 5:
                decenaTexto = "cincuenta";
                break;
            case 6:
                decenaTexto = "sesenta";
                break;
            case 7:
                decenaTexto = "setenta";
                break;
            case 8:
                decenaTexto = "ochenta";
                break;
            case 9:
                decenaTexto = "noventa";
                break;
            default:
                decenaTexto = "";
        }

        return unidad == 0 ? decenaTexto : decenaTexto + " y " + unidadATexto(unidad);
    }

    private static String centenaATexto(int centena) {
        switch (centena) {
            case 1:
                return "ciento";
            case 2:
                return "doscientos";
            case 3:
                return "trescientos";
            case 4:
                return "cuatrocientos";
            case 5:
                return "quinientos";
            case 6:
                return "seiscientos";
            case 7:
                return "setecientos";
            case 8:
                return "ochocientos";
            case 9:
                return "novecientos";
            default:
                return "";
        }
    }
}