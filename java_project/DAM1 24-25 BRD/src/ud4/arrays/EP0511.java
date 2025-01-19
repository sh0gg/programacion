package ud4.arrays;

public class EP0511 {


public static int[] buscarTodos(int[] t, int clave) {
    int count = 0;
    for (int num : t) {
        if (num == clave) count++;
    }
    int[] indices = new int[count];
    int j = 0;
    for (int i = 0; i < t.length; i++) {
        if (t[i] == clave) {
            indices[j++] = i;
        }
    }
    return indices;
}

}
