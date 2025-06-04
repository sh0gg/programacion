package ud7.neves;

public class FindTheWord {

    public boolean findTheWord(String word, char[][] letters) {
        int rows = letters.length;

        for (int i = 0; i < rows; i++) {
            int cols = letters[i].length;
            for (int j = 0; j < cols; j++) {
                if (letters[i][j] != word.charAt(0)) continue;

                // Dirección: derecha
                if (j + word.length() <= cols) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (letters[i][j + k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: izquierda
                if (j - word.length() >= -1) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (letters[i][j - k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: abajo
                if (i + word.length() <= rows) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i + k >= letters.length || j >= letters[i + k].length || letters[i + k][j] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: arriba
                if (i - word.length() >= -1) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i - k < 0 || j >= letters[i - k].length || letters[i - k][j] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: diagonal abajo derecha
                if (i + word.length() <= rows && j + word.length() <= cols) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i + k >= letters.length || j + k >= letters[i + k].length || letters[i + k][j + k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: diagonal abajo izquierda
                if (i + word.length() <= rows && j - word.length() >= -1) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i + k >= letters.length || j - k < 0 || letters[i + k][j - k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: diagonal arriba derecha
                if (i - word.length() >= -1 && j + word.length() <= cols) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i - k < 0 || j + k >= letters[i - k].length || letters[i - k][j + k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }

                // Dirección: diagonal arriba izquierda
                if (i - word.length() >= -1 && j - word.length() >= -1) {
                    int k;
                    for (k = 0; k < word.length(); k++) {
                        if (i - k < 0 || j - k < 0 || letters[i - k][j - k] != word.charAt(k)) break;
                    }
                    if (k == word.length()) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] sopa = {
            {'s','o','z','h','i'},
            {'e','q','u','s','t'},
            {'p','a','v','h','a'},
            {'o','z','e','n','n'},
            {'n','e','v','e','s'}
        };

        FindTheWord finder = new FindTheWord();
        System.out.println(finder.findTheWord("neves", sopa)); // true
    }
}

