package ud5.apuntesinterfaces;

import java.util.Comparator;

public class ComparaSociosEdadesDesc implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Socio s1 = (Socio) o1;
        Socio s2 = (Socio) o2;
        return -(s1.fechaNacimiento.compareTo(s2.fechaNacimiento));
    }

}
