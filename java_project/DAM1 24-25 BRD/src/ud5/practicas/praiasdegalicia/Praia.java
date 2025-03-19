package ud5.practicas.praiasdegalicia;

import java.util.Comparator;
import java.util.Arrays;

public class Praia implements Comparable<Praia> {
    private int id;
    private String nome;
    private String concello;
    private String provincia;
    private double lat;
    private double lon;

    public Praia() {
    }

    public Praia(int id) {
        this.id = id;
    }

    public Praia(int id, String nome, String concello, String provincia) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
    }

    public Praia(int id, String nome, String concello, String provincia, double lat, double lon) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Praia{id=" + id + ", nome='" + nome + "', concello='" + concello + 
               "', provincia='" + provincia + "', lat=" + lat + ", lon=" + lon + "}";
    }

    @Override
    public int compareTo(Praia other) {
        return Integer.compare(this.id, other.id);
    }

    public static void imprimirLista(Praia[] praias, int n) {
        for (int i = 0; i < Math.min(n, praias.length); i++) {
            System.out.println(praias[i]);
        }
    }

    public void mostrarDetalles() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Concello: " + concello);
        System.out.println("Provincia: " + provincia);
        System.out.println("Latitud: " + lat);
        System.out.println("Longitud: " + lon);
    }

    public static Praia[] sortLatitudNorteSur(Praia[] p) {
        Praia[] sorted = Arrays.copyOf(p, p.length);
        Arrays.sort(sorted, Comparator.comparingDouble(Praia::getLat).reversed());
        return sorted;
    }

    public static Praia[] sortProvinciaConcelloNome(Praia[] p) {
        Praia[] sorted = Arrays.copyOf(p, p.length);
        Arrays.sort(sorted, Comparator.comparing(Praia::getProvincia)
                .thenComparing(Praia::getConcello)
                .thenComparing(Praia::getNome));
        return sorted;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConcello() {
        return concello;
    }

    public void setConcello(String concello) {
        this.concello = concello;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


}
