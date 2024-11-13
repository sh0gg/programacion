package proyectos.compartircoche;

import java.util.Scanner;

import proyectos.compartircoche.bd.UsuariosBD;
import proyectos.compartircoche.bd.ViajesBD;

public class AppCompartirCoche {
    static Scanner sc = new Scanner(System.in);;

    public static void main(String[] args) {
        System.out.println("*************************");
        System.out.println("* COMPARTIR COCHE v.0.1 *");
        System.out.println("*************************");
        // Iniciar sesión
        String usuario = UsuariosBD.iniciarSesion();

        // Menú principal
        int opcionUsuario;
        do {
            System.out.println("*******************");
            System.out.println("* COMPARTIR COCHE *");
            System.out.println("*******************");
            System.out.println("Usuario: " + usuario + "\n");
            System.out.println("1. Publicar Viaje");
            System.out.println("2. Solicitar asiento");
            System.out.println("0. SALIR");
            opcionUsuario = sc.nextInt(); sc.nextLine();

            switch (opcionUsuario) {
                case 1:
                    publicarViaje(usuario);
                    break;
                case 2:
                    solicitarAsiento(usuario);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcionUsuario != 0);

        System.out.println("Fin del programa");
        sc.close();
    }

    private static void publicarViaje(String usuario) {
        System.out.print("Escribe la fecha y hora del viaje (AAAA-MM-DD HH:MM): ");
        String fechaHora = sc.nextLine();
        System.out.print("Lugar de origen: ");
        String origen = sc.nextLine();
        System.out.print("Lugar de destino: ");
        String destino = sc.nextLine();
        System.out.print("Número de plazas libres: ");
        int plazas = sc.nextInt(); sc.nextLine();

        if (ViajesBD.crearViaje(usuario, fechaHora, origen, destino, plazas)) {
            System.out.println("Viaje creado");
        } else {
            System.out.println("Error al crear el viaje");
        }
    }

    private static void solicitarAsiento(String usuario) {
        int numViajesProximos = ViajesBD.listarProximosViajesConPlazas();
        if (numViajesProximos > 0) {
            System.out.print("Indica el ID del viaje que quieres solicitar: ");
            int numViaje = sc.nextInt(); sc.nextLine();
            if (ViajesBD.anhadirPasajero(numViaje, usuario)) {
                System.out.println("Asiento solicitado");
            } else {
                System.out.println("Error al solicitar el asiento");
            }
        } else {
            System.out.println("No hay viajes próximos con plazas libres");
        }
    }
}
