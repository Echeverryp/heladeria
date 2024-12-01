package controladores.ventanas;

import javax.swing.*;
import java.awt.*;

import controladores.controlladores.ControladorUsuarios;
import controladores.modelos.PerfilUsuario;

public class VentanaGestionUsuarios extends JFrame {
    private JTextArea txtUsuarios;

    public VentanaGestionUsuarios() {
        setTitle("Gestión de Usuarios");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lista de usuarios
        txtUsuarios = new JTextArea(15, 40);
        txtUsuarios.setEditable(false);
        actualizarListaUsuarios();
        add(new JScrollPane(txtUsuarios), BorderLayout.CENTER);

        // Panel de acciones
        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnAgregar = new JButton("Agregar Usuario");
        JButton btnEliminar = new JButton("Eliminar Usuario");
        JButton btnActualizar = new JButton("Actualizar Usuario");

        panelAcciones.add(btnAgregar);
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnActualizar);

        add(panelAcciones, BorderLayout.SOUTH);

        // Acciones de botones
        btnAgregar.addActionListener(e -> agregarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        btnActualizar.addActionListener(e -> actualizarUsuario());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarListaUsuarios() {
        txtUsuarios.setText("Usuarios del Sistema:\n\n");
        for (PerfilUsuario usuario : ControladorUsuarios.obtenerUsuarios()) {
            txtUsuarios.append(usuario + "\n");
        }
    }

    private void agregarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo usuario:");
        String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
        String rol = JOptionPane.showInputDialog("Ingrese el rol (Administrador/Cajero/Vendedor):");

        try {
            ControladorUsuarios.registrarUsuario(nombre, contrasena, rol);
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente.");
            actualizarListaUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + e.getMessage());
        }
    }

    private void eliminarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario a eliminar:");
        try {
            ControladorUsuarios.eliminarUsuario(nombre);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            actualizarListaUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
    }

    private void actualizarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario a actualizar:");
        String nuevaContrasena = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
        String nuevoRol = JOptionPane.showInputDialog("Ingrese el nuevo rol (Administrador/Cajero/Vendedor):");

        try {
            ControladorUsuarios.actualizarUsuario(nombre, nuevaContrasena, nuevoRol);
            JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente.");
            actualizarListaUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
        }
    }
}
