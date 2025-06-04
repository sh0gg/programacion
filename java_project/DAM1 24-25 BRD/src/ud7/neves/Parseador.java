package ud7.neves;

import java.util.ArrayList;
import java.util.List;

public class Parseador {

    public boolean checkLinea(String linea) {
        List<Character> lista = new ArrayList<>();

        for (char c : linea.toCharArray()) {
            if (c == '(' || c == '[') {
                lista.add(c);
            } else if (c == ')' || c == ']') {
                if (lista.isEmpty()) return false;

                char ultimo = lista.get(lista.size() - 1);
                if ((c == ')' && ultimo == '(') || (c == ']' && ultimo == '[')) {
                    lista.remove(lista.size() - 1);
                } else {
                    return false;
                }
            }
        }

        return lista.isEmpty();
    }

    // Pruebas
    public static void main(String[] args) {
        Parseador p = new Parseador();

        System.out.println(p.checkLinea("this.testFunction(array[i])")); // true
        System.out.println(p.checkLinea("this.testFunction(array[i]"));  // false
        System.out.println(p.checkLinea("this.testFunction(array[i))")); // false
        System.out.println(p.checkLinea("(this.testFunction(array[i]))")); // true
        System.out.println(p.checkLinea("(([()]))")); // true
        System.out.println(p.checkLinea("(([([))]))")); // false
    }
}
