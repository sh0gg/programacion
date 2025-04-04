package ud5.DBRexamen;

import java.util.Arrays;
import java.util.Comparator;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN PROGRAMACIÓN UD5

public class Servidor extends Host{
    
    protected String[] listaServicios;

    public Servidor(String nombre, String ip, String mac) {
        super(nombre, ip, mac);
        listaServicios = new String[0];
    }

    public boolean addServicio(String servicio, int puerto, String protocolo) {
        for (int i = 0; i < listaServicios.length; i++) {
           String[] datosServicio = listaServicios[i].split(" ");
           if (datosServicio[1].equals("(" + puerto + "/"+ protocolo + ")")) {
               throw new IllegalArgumentException("Este puerto y este protocolo ya están en uso");
           } else {
               Arrays.copyOf(listaServicios, listaServicios.length + 1);
               listaServicios[listaServicios.length - 1] = servicio + "(" + puerto + "/"+ protocolo + ")";
           }
        }
        return true;
    }

    @Override
    public String toString() {
            return nombre + " (" + ip + ")\n" + "*" + Arrays.toString(listaServicios);
    }

    public static void main(String[] args) {
        System.out.println("\nClase Servidor");
        System.out.println("==============\n");
        Servidor s1 = new Servidor("dam1", "192.168.0.117", "CC-11-22-33-44-AA");
        s1.addServicio("MySQL", 3306, "TCP");
        Servidor s2 = new Servidor("seixo", "192.168.0.11", "BB:11:22:33:44:55");
        s2.addServicio("HTTP", 80, "TCP");
        s2.addServicio("Proxy", 3128, "TCP");
        Servidor s3 = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        s3.addServicio("HTTP", 80, "TCP");
        s3.addServicio("Web", 80, "TCP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("FTP", 21, "TCP");
        s3.addServicio("SSH", 22, "TCP");        

        Servidor[] servidores = { s1, s2, s3 };
        for (Servidor s : servidores) {
            System.out.println(s);
        }

        System.out.println("\nServidores ordenados descendentemente por número de servicios");
        System.out.println("===============================================================\n");
        Comparator compName = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Servidor s1 = (Servidor) o1;
                Servidor s2 = (Servidor) o2;

                int numServ1 = s1.listaServicios.length;
                int numServ2 = s2.listaServicios.length;

                return numServ1 - numServ2;
            }
        };
        Arrays.sort(servidores, compName);
        System.out.println(Arrays.toString(servidores));

    }
}
