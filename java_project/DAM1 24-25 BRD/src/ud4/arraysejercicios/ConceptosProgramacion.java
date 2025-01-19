package ud4.arraysejercicios;

import java.util.Random;

public class ConceptosProgramacion {
    public static void main(String[] args) {
        String[] t = { "Algoritmo", "Lenguaje de programación", "Entorno de desarrollo", "Compilación", "Ejecución", "Código fuente", "Bytecode", "Código objeto"}; 
    
        System.out.println("Vamos a mostrar un concepto aleatorio por pantalla:");
        System.out.println(fraseAleatoria(t));

        
    }
    static String fraseAleatoria(String[] t) {
        Random rand = new Random();
        int i = rand.nextInt(t.length);
        return t[i];
    }


}
