package ud7.DBRexamen.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN PROG UD7 - DAM1
// FECHA: 28/05/2025

public class GeneraWeb {
    public String titulo;
    public String descripcion;
    public String url;
    public String urlText;

    public GeneraWeb(String titulo, String descripcion, String url, String urlText) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.urlText = urlText;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el titulo");
        String titulo = sc.nextLine();
        System.out.println("Introduce el descripcion");
        String descripcion = sc.nextLine();
        System.out.println("Introduce la URL");
        String url = sc.nextLine();
        System.out.println("Introduce el texto de la URL");
        String urlText = sc.nextLine();

        GeneraWeb gen = new GeneraWeb(titulo, descripcion, url, urlText);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(gen.titulo + ".html"))) {
            bw.write("<html>");
            bw.newLine(); // Salto de línea
            bw.write("<head>");
            bw.newLine();
            bw.write("<title>" + titulo + "</title>");
            bw.newLine();
            bw.write("<meta charset=\"utf-8\">");
            bw.newLine();
            bw.write("</head>");
            bw.newLine();
            bw.newLine();
            bw.write("<body>");
            bw.newLine();
            bw.write("<h1>" + titulo + "</h1>");
            bw.newLine();
            bw.newLine();
            bw.write("<p>" + descripcion + ".</p>");
            bw.newLine();
            bw.write("<a href=\"" + url + "\">" + urlText + "</a>");
            bw.newLine();
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
