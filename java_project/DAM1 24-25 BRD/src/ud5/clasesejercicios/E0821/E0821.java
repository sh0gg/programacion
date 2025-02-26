package ud5.clasesejercicios.E0821;

public class E0821 {
    static boolean esNumero (Object ob) {
        if (ob instanceof Integer || ob instanceof Double || ob instanceof Float || ob instanceof Long || ob instanceof Short || ob instanceof Byte) {
            return true;
        } else {
            return false;
        }
    }

    static boolean esCadena (Object ob) {
        if (ob instanceof String || ob instanceof Character || ob instanceof Byte || ob instanceof Short || ob instanceof Long) {
            return true;
        } else {
            return false;
        }
    }

    static boolean sumar (Object a, Object b) {
        if (esNumero(a) && esNumero(b)) {
            Double a = Double.valueOf(a);
            Double b = Double.valueOf((Doub b);
            Double resultado = a + b;
            System.out.println(resultado);
            return true;
        } else if (esCadena(a) && esCadena(b)) {
            String resultado;
            String cad1 = a.toString();
            String cad2 = b.toString();
            resultado = cad1+cad2;
            System.out.println(resultado);
            return true;
        } else {
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
