package controladores.controlladores;

import controladores.modelos.Helado;
import controladores.modelos.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorVentas {
    private List<Venta> ventas;

    public ControladorVentas() {
        ventas = new ArrayList<>();
    }

    public void registrarVenta(Helado helado, int cantidad) {
        ventas.add(new Venta(LocalDate.now(), helado, cantidad));
    }

    public List<Venta> obtenerVentas() {
        return ventas;
    }

    public void eliminarVenta(Venta venta) {
        ventas.remove(venta);
    }
}
