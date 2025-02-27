package ud5.clasesejercicios.E0822;

import java.util.Scanner;

public class E0822 {

    static int objetosDestruidos = 0;

    @Override
    protected void finalize() throws Throwable {
        objetosDestruidos++;
        System.out.println("Objeto número " + objetosDestruidos + " esta destruido");
        super.finalize();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            E0822 objeto = new E0822();
        }

        // System.gc();

        System.out.println("Pulsa [ENTER] para finalizar");
        new Scanner(System.in).nextLine();
    }
}
