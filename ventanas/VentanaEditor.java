package controladores.ventanas;

import javax.swing.*;
import java.awt.*;

import controladores.controlladores.ControladorUsuarios;
import controladores.controlladores.ControladorInventario;

public class VentanaEditor extends JFrame {

    public VentanaEditor() {

        setTitle("Modo Editor - Gestión de Heladería");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Botones para cada sección
        JButton btnGestionUsuarios = new JButton("Gestión de Usuarios");
        JButton btnGestionInventario = new JButton("Gestión de Inventario");
        JButton btnGestionVentas = new JButton("Gestión de Ventas");
        JButton btnSalir = new JButton("Salir del Modo Editor");

        // Acciones para cada botón
        btnGestionUsuarios.addActionListener(e -> new VentanaGestionUsuarios());
        btnGestionInventario.addActionListener(e -> new VentanaGestionInventario());
        btnGestionVentas.addActionListener(e -> new VentanaGestionVentas());
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Saliendo del Modo Editor.");
            dispose();
            new VentanaLogin();
        });

        // Añadir botones a la ventana
        add(btnGestionUsuarios);
        add(btnGestionInventario);
        add(btnGestionVentas);
        add(btnSalir);

        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }
}
