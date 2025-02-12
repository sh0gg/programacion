package ud4.DBRexamen;

// Realizado por David Besada Ramilo
// Examen UD04 de Programación

import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.awt.*;
import java.util.Scanner;

public class BuscaTesouro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuanto mide el mapa?");
        System.out.print("Introduce el ancho: ");
        int ancho = sc.nextInt();
        System.out.print("Introduce el alto: ");
        int alto = sc.nextInt();

        int[][] mapa = new int[ancho][alto];
        int posicionXTesoro = (int) (Math.random() * (ancho));
        int posicionYTesoro = (int) (Math.random() * (alto));
        mapa[posicionXTesoro][posicionYTesoro] = 2;

        int intentosMaximos = (ancho * alto) / 10;
        int intentos = 0;
        String direccion = "";

        System.out.println("El capitán pirata ha escondido bien su tesoro en esta zona de " + ancho * alto + " casillas...");
        System.out.println("¡¡Tienes un total de " + intentosMaximos + " intentos, para encontrarlo!!");

        System.out.print("Dame la primera coordenada: ");
        int xIntento = sc.nextInt() - 1;
        while (xIntento > ancho) {
            System.out.print("¡Serás mequetrefe! ¡Eso es fuera del mapa! Intentalo de nuevo: ");
            xIntento = sc.nextInt() - 1;
        }
        System.out.print("Dame la segunda coordenada: ");
        int yIntento = sc.nextInt() - 1;
        while (yIntento > alto) {
            System.out.print("¡Serás mequetrefe! ¡Eso es fuera del mapa! Intentalo de nuevo: ");
            yIntento = sc.nextInt() - 1;
        }

        while ((posicionXTesoro != xIntento && posicionYTesoro != yIntento) || intentos > intentosMaximos) {
            mapa[xIntento][yIntento] = 1;
            ++intentos;

            if (posicionYTesoro > yIntento) {
                direccion = "sur";
                if (posicionXTesoro > xIntento) {
                    direccion = "sureste";
                } else if (posicionXTesoro < xIntento) {
                    direccion = "suroeste";
                }
            } else {
                direccion = "norte";
                if (posicionXTesoro > xIntento) {
                    direccion = "noreste";
                } else if (posicionXTesoro < xIntento) {
                    direccion = "noroeste";
                }
            }

            int d = 0;
            String distancia = "";

            d = ~(((xIntento - posicionXTesoro) ^ 2) + ((yIntento - posicionYTesoro) ^ 2));

            if (d <= 2) {
                distancia = "cerca";
            } else {
                distancia = "lejos";
            }

            System.out.println("¡Buen intento, grumete! Pero el tesoro se encuentra " + distancia + " al " + direccion);

            for (int i = 0; i < ancho; i++) {
                for (int j = 0; j < alto; j++) {
                    if (mapa[i][j] == 1) {
                        System.out.print("O ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println(" ");
            }

            // El mapa sale en el sentido que no debe

            System.out.println("Dame la primera coordenada: ");
            xIntento = sc.nextInt();
            System.out.println("Dame la segunda coordenada: ");
            yIntento = sc.nextInt();


        }

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (mapa[i][j] == 2) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println(" ");
        }

        if (mapa[posicionXTesoro][posicionYTesoro] == mapa[xIntento][yIntento]) {
            System.out.println("¡ENHORABUENA! Has encontrado el tesoro del pirata en " + intentos + " intento(s). Disfruta de tus riquezas mientras puedas, grumete...");
        } else {
            System.out.println("¡Mala suerte, mequetrefe! El tesoro del pirata seguirá escondido por la eternidad.");
        }
    }
}
