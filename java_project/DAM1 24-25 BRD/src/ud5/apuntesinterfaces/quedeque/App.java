package ud5.apuntesinterfaces.quedeque;

public class App {
    
        public static void main(String[] args) {

            Coche Golfito = new Coche(1, "Volkswagen", "Golf", "Rojo", 4, 3, "Hatchback", 1599, 4, 115, 1000, "delantera");
            Moto Ducati = new Moto(2, "Ducati", "Monster", "Negro", 800, 2, 200, "Naked");
            Camion Volvo = new Camion(3, "Volvo", "FH16", "Blanco", 9000, 20000, 550, 3, true);
            Avion Boeing = new Avion(4, "Boeing", "747", "Azul", 183500, 30000, 4, "reactor", "despegando");

            System.out.println("\nCoche:");
            Golfito.acelerar();
            Golfito.decelerar();
            Golfito.girarDerecha();
            Golfito.girarIzquierda();

            System.out.println("\nMoto:");
            Ducati.acelerar();
            Ducati.decelerar();
            Ducati.girarDerecha();
            Ducati.girarIzquierda();

            System.out.println("\nCamión:");
            Volvo.acelerar();
            Volvo.decelerar();
            Volvo.girarDerecha();
            Volvo.girarIzquierda();

            System.out.println("\nAvión:");
            Boeing.acelerar();
            Boeing.decelerar();
            Boeing.girarDerecha();
            Boeing.girarIzquierda();
            Boeing.ascender();
            Boeing.descender();
        }
    }

