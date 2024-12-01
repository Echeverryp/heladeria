package controladores.controlladores;
import controladores.modelos.Helado;
import controladores.modelos.PerfilUsuario;
import controladores.modelos.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarios {
    private static List<PerfilUsuario> usuarios=new ArrayList<>();

    private ControladorUsuarios() {
        usuarios.add(new PerfilUsuario("admin", "admin", "Administrador"));
    }

    public static void registrarUsuario(String nombreUsuario, String contrasena, String rol) {
        for (PerfilUsuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                throw new RuntimeException("El nombre de usuario ya existe.");
            }
        }
        usuarios.add(new PerfilUsuario(nombreUsuario, contrasena, rol));
    }

    public static PerfilUsuario autenticarUsuario(String nombreUsuario, String contrasena) {
        for (PerfilUsuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }

    public static List<PerfilUsuario> obtenerUsuarios() {
        return usuarios;
    }

    public static void eliminarUsuario(String nombre) {
    }

    public static void actualizarUsuario(String nombre, String nuevaContrasena, String nuevoRol) {
    }

    public static class ControladorVentas {
        private List<Venta> ventas;

        public ControladorVentas() {
            ventas = new ArrayList<>();
        }

        public void registrarVenta(Helado helado, int cantidad) {
            ventas.add(new Venta(LocalDate.now(), helado, cantidad));
        }

        public List<Venta> obtenerVentas() {
            return new ArrayList<>(ventas);
        }

        public void eliminarVenta(Venta venta) {
            ventas.remove(venta);
        }
    }
}
