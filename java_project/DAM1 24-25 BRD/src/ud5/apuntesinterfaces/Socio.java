package ud5.apuntesinterfaces;

import java.util.Arrays;

public class Socio implements Comparable{
    int id;
    String nombre;

    public Socio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id + ". " + nombre;
    }

    public static void main(String[] args) {
        Socio s = new Socio(1, "Jaime");
        Socio s2 = new Socio(2, "Julia");

        if (s.compareTo(s2) == 0) {
            System.out.println(s.nombre + " y " + s2.nombre + " son el/la mismo/a socio/a");
        } else if (s.compareTo(s2) < 0) {
            System.out.println(s.nombre + " lleva mas tiempo registrado que " + s2.nombre);
        } else {
            System.out.println(s2.nombre + " lleva mas tiempo registrado que " + s.nombre);
        }

        System.out.println("Array de socios ordenado");
        Socio[] socios = {
                s,
                s2,
                new Socio(3, "Josefina"),
                new Socio(4, "Chema"),
                new Socio(5, "Juanjo"),
        };

        System.out.println(Arrays.toString(socios));

        Arrays.sort(socios);

        System.out.println(Arrays.toString(socios));

    }

//    @Override
//    public int compareTo(Object o) {
//        int resComparacion = id - ((Socio)o).id;
//        return resComparacion;
//    }

    @Override
    public int compareTo(Object o) {
        Socio otroSocio = (Socio) o;
        return nombre.compareTo(otroSocio.nombre);

    }


}
