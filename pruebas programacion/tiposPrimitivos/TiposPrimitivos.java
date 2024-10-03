package tiposPrimitivos;

public class TiposPrimitivos {
    public static void main(String[] args) {
        /* Declaración de las variables */
        byte varByte = 120;
        short varShort = 32000;
        int varInt = 123456789;
        long varLong = 1234567890123456789L;
        float varFloat = 3.14f;
        double varDouble = 3.141592653589793;
        char varChar = 'A';
        boolean varBoolean = true;

        /* Print de las variables */
        System.out.println("Tipo      Numbits       Valor");
        System.out.println("-----------------------------");
        System.out.println("byte        8           " + varByte);
        System.out.println("short       16          " + varShort);
        System.out.println("int         32          " + varInt);
        System.out.println("long        64          " + varLong);
        System.out.println("float       32          " + varFloat);
        System.out.println("double      64          " + varDouble);
        System.out.println("char        16          " + varChar);
        System.out.println("boolean     1           " + varBoolean);


    }
}
