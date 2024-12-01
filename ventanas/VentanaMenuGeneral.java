package controladores.ventanas;

import controladores.controlladores.ControladorUsuarios;
import controladores.controlladores.ControladorInventario;

import javax.swing.*;
import java.awt.*;

public class VentanaMenuGeneral extends JFrame {
    private JButton btnModoEditor;
    private JButton btnCerrarSesion;

    public VentanaMenuGeneral() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Botones para navegar
        btnModoEditor = new JButton("Entrar en Modo Editor");
        btnCerrarSesion = new JButton("Cerrar Sesión");

        btnModoEditor.addActionListener(e -> entrarModoEditor());
        btnCerrarSesion.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Cerrando sesión...");
            dispose();
            new VentanaLogin();
        });

        add(btnModoEditor);
        add(btnCerrarSesion);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    private void entrarModoEditor() {
        new VentanaEditor(
        );
        dispose();
    }
}
