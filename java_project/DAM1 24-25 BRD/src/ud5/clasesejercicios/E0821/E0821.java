package ud5.clasesejercicios.E0821;

public class E0821 {
    static boolean esNumero (Object ob) {
        if (ob instanceof Number) {
            return true;
        } else {
            return false;
        }
    }

    static boolean esCadena (Object ob) {
        if (ob instanceof CharSequence) {
            return true;
        } else {
            return false;
        }
    }

    static boolean sumar (Object a, Object b) {
        if (esNumero(a) && esNumero(b)) {
            Double resultado = ((Number) a).doubleValue() + ((Number) b).doubleValue();
            if (resultado - resultado.longValue() == 0.0) {
                System.out.println("El resultado es: " + resultado.intValue());
            } else {
                System.out.println("El resultado es: " + resultado);
            }
            return true;
        } else if (esCadena(a) && esCadena(b)) {
            System.out.println("La concatenación es: " + a + b);
            return true;
        } else {
            System.out.println(a + " y " + b + " no son sumables");
            return false;
        }
    }
    public static void main(String[] args) {
        String cad1 = "Hola ";
        String cad2 = "Mundo";

        sumar(cad1, cad2);

        int int1 = 12;
        int int2 = 217;
        double double1 = 12.2;
        double double2 = 217.2;

        sumar(int1, int2);

        sumar(double1, double2);

        sumar(int1, double2);

        sumar(int1, cad2);
    }
}
