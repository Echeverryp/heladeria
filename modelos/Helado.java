package controladores.modelos;

public class Helado {
    private String nombre;
    private double precioVenta;
    private double costoProduccion;

    public Helado(String nombre, double precioVenta, double costoProduccion) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.costoProduccion = costoProduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    @Override
    public String toString() {
        return "Helado: " + nombre + ", Precio Venta: $" + precioVenta + ", Costo Producción: $" + costoProduccion;
    }
}
