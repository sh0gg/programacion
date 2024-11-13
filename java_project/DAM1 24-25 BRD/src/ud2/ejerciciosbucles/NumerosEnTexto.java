package ud2.ejerciciosbucles;

public class NumerosEnTexto {
    public static void main(String[] args) {
        for (int i = 1; i <= 99; i++) {
            System.out.println(i + ". " + convertirATexto(i));
        }
    }
    
    public static String convertirATexto(int numero) {
        String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        
        if (numero < 10) return unidades[numero];
        if (numero < 20) return new String[]{"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"}[numero - 10];
        
        int decena = numero / 10;
        int unidad = numero % 10;
        return unidad == 0 ? decenas[decena] : decenas[decena] + " y " + unidades[unidad];
    }
}

