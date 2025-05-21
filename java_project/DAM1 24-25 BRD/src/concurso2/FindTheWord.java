package concurso2;

public class FindTheWord {
    public boolean findTheWord(String word, char[][] letters) {
        char[] clave = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                if (letters[i][j] == clave[1]) {

                    // empezamos a buscar

                    char[] palabra = new char[clave.length];
                    int contador = 0;
                    int k = i;
                    int l = j;

                    // buscar al este

                    for (; k < letters[i].length; k++) {
                        palabra[contador] = letters[k][j];
                        contador++;
                    }

                    if (palabra == clave) {
                        return true;
                    } else {
                        contador = 0;
                        k = i;
                        palabra = new char[clave.length];
                    }

                    // buscar al oeste

                    for (; k < letters[i].length; k--) {
                        palabra[contador] = letters[k][j];
                        contador++;
                    }

                    if (palabra == clave) {
                        return true;
                    } else {
                        contador = 0;
                        k = i;
                        palabra = new char[clave.length];
                    }

                    // buscar al sur

                    for (; l < letters.length; l++) {
                        palabra[contador] = letters[i][l];
                        contador++;
                    }

                    if (palabra == clave) {
                        return true;
                    } else {
                        contador = 0;
                        l = j;
                        palabra = new char[clave.length];
                    }

                    // buscar al norte

                    for (; l < letters.length; l++) {
                        palabra[contador] = letters[i][l];
                        contador++;
                    }

                    if (palabra == clave) {
                        return true;
                    } else {
                        contador = 0;
                        l = j;
                        palabra = new char[clave.length];
                    }

                    // buscar al sureste

                    // buscar al suroeste

                    // buscar al noreste

                    // buscar al noroeste



                }
            }
        }
        return false;
    }


}