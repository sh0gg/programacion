package ud7.Ficheros;

// Importamos la clase Scanner para leer datos desde el teclado
import java.util.Scanner;

public class E1001 {

    // Método que solicita un número entero al usuario y valida su entrada
    public static Integer leerEntero() {
        // Creamos un objeto Scanner para leer desde la consola
        Scanner sc = new Scanner(System.in);
        
        // Declaramos la variable que almacenará el número introducido
        Integer numero = null;
        
        // Variable de control para el bucle de validación
        boolean valido = false;

        // Repetimos hasta que el usuario introduzca un número válido
        while (!valido) {
            try {
                System.out.print("Introduce un número entero: ");
                
                // Intentamos leer un número entero del teclado
                numero = sc.nextInt();
                
                // Si no hay excepción, el valor es válido y salimos del bucle
                valido = true;
            } catch (Exception e) {
                // Si el usuario introduce algo que no sea un entero, se lanza una excepción
                System.out.println("Error: Debes introducir un número entero válido.");
                
                // Limpiamos el buffer del scanner para evitar un bucle infinito
                sc.nextLine();
            }
        }

        // Devolvemos el número leído
        return numero;
    }

    // Método principal para probar el método leerEntero()
    public static void main(String[] args) {
        // Llamamos al método y almacenamos el resultado
        int numero = leerEntero();

        // Mostramos el número introducido por el usuario
        System.out.println("Número introducido: " + numero);
    }
}
