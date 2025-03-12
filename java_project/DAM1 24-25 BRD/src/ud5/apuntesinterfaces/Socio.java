package ud5.apuntesinterfaces;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Socio implements Comparable{
    int id;
    String nombre;
    LocalDate fechaDeAlta;
    LocalDate fechaNacimiento;

    public Socio(int id, String nombre, LocalDate fechaDeAlta, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
        this.fechaNacimiento = fechaNacimiento;
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
    }


    @Override
    public String toString() {
        return id + ". " + nombre + " - Socio desde:" + fechaDeAlta;
    }

    public static void main(String[] args) {
        Socio s = new Socio(1, "Jaime", LocalDate.of(2000, 1, 1), LocalDate.of(1966, 3, 25));
        Socio s2 = new Socio(2, "Julia", LocalDate.of(1990, 3, 25), LocalDate.of(1967, 3, 25));

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
                new Socio(9, "Josefina", LocalDate.of(2010, 3, 25), LocalDate.of(1968, 3, 25)),
                new Socio(4, "Chema", LocalDate.of(2009, 3, 25), LocalDate.of(1969, 3, 25)),
                new Socio(5, "Juanjo", LocalDate.of(2008, 3, 25), LocalDate.of(1982, 3, 25)),
        };

        System.out.println(Arrays.toString(socios));


        // Creando el objeto y llamandolo en el sort
        ComparaSociosFecha ordenFecha = new ComparaSociosFecha();
        Arrays.sort(socios, ordenFecha);

        System.out.println(Arrays.toString(socios));


        // Creando el objeto dentro del sort
        Arrays.sort(socios, new ComparaSociosNombre());
        System.out.println(Arrays.toString(socios));

        // Generando la clase del objeto "al vuelo" en el código
        Comparator compName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Socio) o1).nombre.compareTo(((Socio) o2).nombre);
            }
        };
        Arrays.sort(socios, compName);
        System.out.println(Arrays.toString(socios));



    }

//    @Override
//    public int compareTo(Object o) {
//        int resComparacion = id - ((Socio)o).id;
//        return resComparacion;
//    }

//    @Override
//    public int compareTo(Object o) {
//        Socio otroSocio = (Socio) o;
//        return nombre.compareTo(otroSocio.nombre);
//
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Socio socio = (Socio) obj;
        return id == socio.id && nombre.equals(socio.nombre) && Objects.equals(fechaDeAlta, socio.fechaDeAlta);
    }

    @Override
    public int compareTo(Object o) {
        Socio socio = (Socio) o;
        int res = fechaDeAlta.compareTo(socio.fechaDeAlta);
        if (res == 0) {
            res = this.nombre.compareTo(socio.nombre);
            if (res == 0) {
                res = this.id - socio.id;
            }
        }
        return res;
        }


}
