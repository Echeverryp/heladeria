package controladores.controlladores;



import controladores.modelos.Helado;

import java.util.ArrayList;
import java.util.List;

public class ControladorInventario {
    private static List<Helado> helados= new ArrayList<>();

    private ControladorInventario() {
        helados.add(new Helado("Chocolate", 2.5, 1.0));
        helados.add(new Helado("Vainilla", 2.0, 0.9));
        helados.add(new Helado("Fresa", 2.3, 1.2));
    }

    public static void agregarHelado(Helado helado) {
        for (Helado h : helados) {
            if (h.getNombre().equalsIgnoreCase(helado.getNombre())) {
                throw new RuntimeException("El helado ya existe en el inventario.");
            }
        }
        helados.add(helado);
    }

    public static void eliminarHelado(String nombre) {
        Helado heladoAEliminar = null;
        for (Helado h : helados) {
            if (h.getNombre().equalsIgnoreCase(nombre)) {
                heladoAEliminar = h;
                break;
            }
        }
        if (heladoAEliminar != null) {
            helados.remove(heladoAEliminar);
        } else {
            throw new RuntimeException("Helado no encontrado.");
        }
    }

    public static List<Helado> obtenerInventario() {
        return helados;
    }

    public static void actualizarHelado(String nombre, double nuevoPrecio, double nuevoCosto) {
        Helado heladoAActualizar = null;
        for (Helado h : helados) {
            if (h.getNombre().equalsIgnoreCase(nombre)) {
                heladoAActualizar = h;
                break;
            }
        }
        if (heladoAActualizar != null) {
            heladoAActualizar.setPrecioVenta(nuevoPrecio);
            heladoAActualizar.setCostoProduccion(nuevoCosto);
        } else {
            throw new RuntimeException("Helado no encontrado.");
        }
    }
}
