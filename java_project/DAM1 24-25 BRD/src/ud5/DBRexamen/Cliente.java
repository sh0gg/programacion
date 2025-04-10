package ud5.DBRexamen;

import java.util.Arrays;
import java.util.Comparator;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN PROGRAMACIÓN UD5

public class Cliente extends Host implements Comparable{
    protected enum SO {WINDOWS, LINUX, MAC, ANDROID, IOS}
    protected SO so;
    protected String resolucion;

    public Cliente(String nombre, String ip, String mac, SO so, String resolucion) {
        super(nombre, ip, mac);
        this.so = so;
        this.resolucion = resolucion;
    }

    @Override
    public String toString() {
        return nombre + " (" + so.toString().substring(0, 1) + so.toString().toLowerCase().substring(1, so.toString().length()) + " " + resolucion + ")";
    }

    @Override
    public int compareTo(Object o) {
        Cliente c = (Cliente) o;
        return nombre.compareTo(c.nombre);
    }

    public static void main(String[] args) {
        System.out.println("\nClase Cliente");
        System.out.println("=============\n");        
        Cliente cWin1 = new Cliente("Cliente1", "192.168.1.2", "02:1A:2B:3C:4D:5E", SO.WINDOWS, "1920x1080");
        Cliente cLin2 = new Cliente("Cliente2", "192.168.1.3", "01:1A:2B:3C:4D:5F", SO.LINUX, "1366x768");
        Cliente cMac3 = new Cliente("Cliente3", "192.168.1.4", "04:1A:2B:3C:4D:60", SO.MAC, "2560x1440");
        Cliente cAnd4 = new Cliente("Cliente4", "192.168.1.5", "03:1A:2B:3C:4D:61", SO.ANDROID, "1080x2340");
        Cliente cIos5 = new Cliente("Cliente5", "192.168.1.6", "05:1A:2B:3C:4D:62", SO.IOS, "1170x2532");

        Cliente[] clientes = { cWin1, cLin2, cMac3, cAnd4, cIos5 };
        Arrays.sort(clientes);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\nClientes ordenados por SO");
        System.out.println("============================\n");
        Comparator compName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;
                String nombreSo1 = c1.so.toString();
                String nombreSo2 = c2.so.toString();
                return nombreSo1.compareTo(nombreSo2);
            }
        };
        Arrays.sort(clientes, compName);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\nClientes ordenados por resolucion");
        System.out.println("============================\n");
        Comparator compName2 = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Cliente c1 = (Cliente) o1;
                Cliente c2 = (Cliente) o2;

                String[] arrayResCombinada1 = c1.resolucion.toString().split("x");
                String[] arrayResCombinada2 = c2.resolucion.toString().split("x");

                Integer resCombinada1 = Integer.valueOf(arrayResCombinada1[0]) * Integer.valueOf(arrayResCombinada1[1]);
                Integer resCombinada2 = Integer.valueOf(arrayResCombinada2[0]) * Integer.valueOf(arrayResCombinada2[1]);

                return resCombinada2 - resC0ombinada1;
            }
        };
        Arrays.sort(clientes, compName2);
        for (Cliente c : clientes) {
            System.out.println(c);
        }
 

    }
    
}
