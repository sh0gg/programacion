package ud4.ejercicios5febrero;

import java.util.Scanner;
import java.util.Set;

public class ConjugarVerbos {
    private static final Set<String> CONJUGACIONES = Set.of("ar", "er", "ir");

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Conjugar Verbos");
        System.out.println("Dime que verso quieres conjugar: ");
        String verbo = entrada.nextLine();
        if (verbo == null || verbo.length() <= 2 || CONJUGACIONES.contains(verbo.substring(verbo.length() - 2))) {
            System.out.println("No se puede conjugar");
            return;
        }
        System.out.println("Presente simple de " + verbo);
        for (int i = 0; i < 6; i++) {
            String[] a = conjugarPresente(verbo);
            System.out.println(a[i]);
        }
        System.out.println("Pretérito perfecto simple de " + verbo);
        for (int i = 0; i < 6; i++) {
            String[] a = conjugarPreteritoPerfecto(verbo);
            System.out.println(a[i]);
        }
        System.out.println("Futuro simple de " + verbo);
        for (int i = 0; i < 6; i++) {
            String[] a = conjugarFuturo(verbo);
            System.out.println(a[i]);
        }

    }

    private static String[] conjugarPreteritoPerfecto(String verbo) {
        String[] pasado = new String[6];
        verbo = verbo.toLowerCase();
        String lexema = verbo.substring(0, verbo.length()-2);
        String conjugacion = verbo.substring(verbo.length()-2);
        switch (conjugacion) {
            case "ar":
                pasado[0] = lexema + "é";
                pasado[1] = lexema + "aste";
                pasado[2] = lexema + "ó";
                pasado[3] = lexema + "amos";
                pasado[4] = lexema + "ásteis";
                pasado[5] = lexema + "aron";
                break;
            case "er":
                pasado[0] = lexema + "í";
                pasado[1] = lexema + "iste";
                pasado[2] = lexema + "ió";
                pasado[3] = lexema + "imos";
                pasado[4] = lexema + "ísteis";
                pasado[5] = lexema + "ieron";
                break;
            case "ir":
                pasado[0] = lexema + "í";
                pasado[1] = lexema + "iste";
                pasado[2] = lexema + "ió";
                pasado[3] = lexema + "imos";
                pasado[4] = lexema + "ísteis";
                pasado[5] = lexema + "ieron";
                break;
            default:
                return null;
        }

        return pasado;
    }

    private static String[] conjugarFuturo(String verbo) {
        String[] futuro = new String[6];
        verbo = verbo.toLowerCase();
        String lexema = verbo.substring(0, verbo.length()-2);
        String conjugacion = verbo.substring(verbo.length()-2);
        switch (conjugacion) {
            case "ar":
                futuro[0] = lexema + "aré";
                futuro[1] = lexema + "arás";
                futuro[2] = lexema + "ará";
                futuro[3] = lexema + "emos";
                futuro[4] = lexema + "éis";
                futuro[5] = lexema + "án";
                break;
            case "er":
                futuro[0] = lexema + "eré";
                futuro[1] = lexema + "erás";
                futuro[2] = lexema + "erá";
                futuro[3] = lexema + "eremos";
                futuro[4] = lexema + "eréis";
                futuro[5] = lexema + "erán";
                break;
            case "ir":
                futuro[0] = lexema + "iré";
                futuro[1] = lexema + "irás";
                futuro[2] = lexema + "irá";
                futuro[3] = lexema + "iremos";
                futuro[4] = lexema + "iréis";
                futuro[5] = lexema + "irán";
                break;
            default:
                return null;
        }

        return futuro;
    }

    private static String[] conjugarPresente(String verbo) {
        String[] presente = new String[6];
        verbo = verbo.toLowerCase();
        String lexema = verbo.substring(0, verbo.length()-2);
        String conjugacion = verbo.substring(verbo.length()-2);
        switch (conjugacion) {
            case "ar":
                presente[0] = lexema + "o";
                presente[1] = lexema + "as";
                presente[2] = lexema + "a";
                presente[3] = lexema + "amos";
                presente[4] = lexema + "áis";
                presente[5] = lexema + "an";
                break;
            case "er":
                presente[0] = lexema + "o";
                presente[1] = lexema + "es";
                presente[2] = lexema + "e";
                presente[3] = lexema + "emos";
                presente[4] = lexema + "éis";
                presente[5] = lexema + "en";
                break;
            case "ir":
                presente[0] = lexema + "o";
                presente[1] = lexema + "es";
                presente[2] = lexema + "e";
                presente[3] = lexema + "imos";
                presente[4] = lexema + "ís";
                presente[5] = lexema + "en";
                break;
            default:
                return null;
        }

        return presente;
    }
}
