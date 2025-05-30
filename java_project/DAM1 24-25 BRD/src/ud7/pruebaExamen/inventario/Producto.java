package ud7.pruebaExamen.inventario;

import java.io.Serializable;

/**
 * @author [Tu Nombre Completo]
 * Clase Producto serializable.
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio;
    }
}
