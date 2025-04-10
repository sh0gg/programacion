package ud5.DBRexamen;

import java.util.Arrays;
import java.util.Objects;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN PROGRAMACIÓN UD5

public class Host implements Comparable{

protected String nombre;
protected String mac;
protected String ip;
protected String mask;
protected String gateway;
protected String dns;

Host(String nombre, String ip, String mac) {
    if (nombre != null) {
        this.nombre = nombre;
    } else throw new IllegalArgumentException("El nombre no puede ser nulo");

    if (ip == null) {
        ip = null; }
    else if (validarIP(ip)) {
        this.ip = ip;
    } else throw new IllegalArgumentException("La dirección IP no es válida");

    if (validarMAC(mac)) {
        this.mac = mac;
    } else throw new IllegalArgumentException("La dirección MAC no es válida");

    mask = "255.255.0.0";
    gateway = "192.168.0.11";
    dns = "192.168.0.9";
}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        String mac1 = mac.toUpperCase().replace("-", ":");
        String mac2 = host.mac.toUpperCase().replace("-", ":");
        boolean resultado = Objects.equals(mac1, mac2);
        return resultado;
    }

    @Override
    public String toString() {
        return nombre + " (" + ip + " / " + mac + ")";
    }

    @Override
    public int compareTo(Object o) {
        Host host = (Host) o;
        int res = nombre.compareTo(host.nombre);
        return res;
    }

    boolean validarIP(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    boolean validarMAC(String mac) {
        return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
    }

    public static void main(String[] args) {
        System.out.println("\nClase Host");
        System.out.println("==========\n");
        Host h100 = new Host("host100", "192.168.117.100", "00:11:22:33:44:55");
        Host h101 = new Host("equipo101", "192.168.117.101", "00:11:22:33:44:55");
        Host h102 = new Host("nodo100", "192.168.117.100", "00-11-22-33-44-AA");
        Host h103 = new Host("host103", "192.168.117.103", "00-11-22-33-44-55");

        Host[] hosts = { h100, h101, h102, h103};
        Arrays.sort(hosts);
        for (Host h : hosts) {
            System.out.println(h);
        }

        System.out.println(h100.nombre + " = " + h101.nombre + "? " + h100.equals(h101)); // true
        System.out.println(h100.nombre + " = " + h102.nombre + "? " + h100.equals(h102)); // false
        System.out.println(h100.nombre + " = " + h103.nombre + "? " + h100.equals(h103)); // true
    }

}
