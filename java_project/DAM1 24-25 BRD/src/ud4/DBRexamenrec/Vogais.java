package ud4.DBRexamenrec;

public class Vogais {
    static String cambiaVogais(String str, char vogal) {
        vogal = Character.toLowerCase(vogal);
        char[] vogaisMin = {'a','e','i','o','u','á','é','í','ó','ú'};
        char[] vogaisMaius = {'A','E','I','O','U','Á','É','Í','Ó','Ú'};
        char[] novaFraseArray = str.toCharArray();

        for (int i = 0; i < novaFraseArray.length; i++) {
            for (int j = 0; j < vogaisMin.length; j++) {
                if (novaFraseArray[i] == vogaisMin[j]) {
                    novaFraseArray[i] = vogal;
                }
            }
            for (int k = 0; k < vogaisMaius.length; k++) {
                if (novaFraseArray[i] == vogaisMaius[k]) {
                    novaFraseArray[i] = Character.toUpperCase(vogal);
                }
            }
        }

        String novaFrase = String.valueOf(novaFraseArray);
        return novaFrase;
    }
    
}
