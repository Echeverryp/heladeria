package controladores.ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controladores.controlladores.ControladorUsuarios;
import controladores.modelos.PerfilUsuario;

public class VentanaRegistro extends JFrame {
    private JTextField txtNuevoUsuario;
    private JPasswordField txtNuevaContrasena;
    private JComboBox<String> cbRoles;
    private JButton btnRegistrar, btnCancelar;

    public VentanaRegistro() {

        setTitle("Registro de Usuario");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Nombre de Usuario
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nombre de Usuario:"), gbc);

        txtNuevoUsuario = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtNuevoUsuario, gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Contraseña:"), gbc);

        txtNuevaContrasena = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtNuevaContrasena, gbc);

        // Rol
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Rol:"), gbc);

        String[] roles = {"Administrador", "Cajero", "Vendedor"};
        cbRoles = new JComboBox<>(roles);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(cbRoles, gbc);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBotones, gbc);

        // Acción del Botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtNuevoUsuario.getText().trim();
                String contrasena = new String(txtNuevaContrasena.getPassword()).trim();
                String rol = (String) cbRoles.getSelectedItem();

                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validación adicional
                if (contrasena.length() < 6) {
                    JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar si el usuario ya existe
                PerfilUsuario existente = ControladorUsuarios.autenticarUsuario(usuario, contrasena);
                if (existente != null) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Registrar el usuario
                try {
                    ControladorUsuarios.registrarUsuario(usuario, contrasena, rol);
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new VentanaLogin();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del Botón Cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VentanaLogin();
            }
        });

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }
}
