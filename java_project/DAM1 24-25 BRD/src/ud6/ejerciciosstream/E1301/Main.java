package ud6.ejerciciosstream.E1301;


import ud6.colecciones.Academico;

public class Main {
    public static void main(String[] args) {

//        Saludo<String> stringSaludo;
//
//        stringSaludo = new Saludo<String>()  {
//            @Override
//            public void saludar(String str) {
//                System.out.println("Hola " + str);
//            }
//        };
//  O podemos hacer

        Saludo<String> stringSaludo = (str) -> {System.out.println("Hola " + str);};

        Saludo<Academico> academicoSaludo = (academico) -> {System.out.println("Buenos días " + academico.getNombre());};

        stringSaludo.saludar("Pepe");

        academicoSaludo.saludar(new Academico("Pepe", 1990));
    }
}
