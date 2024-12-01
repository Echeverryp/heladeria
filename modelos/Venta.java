package controladores.modelos;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private Helado helado;
    private int cantidad;
    private double total;

    public Venta(LocalDate fecha, Helado helado, int cantidad) {
        this.fecha = fecha;
        this.helado = helado;
        this.cantidad = cantidad;
        this.total = helado.getPrecioVenta() * cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Helado getHelado() {
        return helado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Helado: " + helado.getNombre() +
                ", Cantidad: " + cantidad + ", Total: $" + total;
    }
}
