package ud4.DBRexamenrec;

public class Sumas {
    static int[] sumas(int t[]) {

        if (t == null) {
            return null;
        }

        int[] resultado = new int[3];
        for (int i = 0; i < t.length; i++) {
            resultado[0] += t[i];
            if (t[i] % 2 == 0) {
                resultado[1] += t[i];
            } else {
                resultado[2] += t[i];
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] array = {7,2,3,4,6,1,8};
        int[] resultado = sumas(array);
        for (int i : resultado) {
            System.out.println(i);
        }
    }
}
