package controladores.ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controladores.controlladores.ControladorUsuarios;
import controladores.modelos.PerfilUsuario;

public class VentanaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin, btnRegistrar;

    public VentanaLogin() {

        setTitle("Login - Heladería");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Usuario
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Usuario:"), gbc);

        txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtUsuario, gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Contraseña:"), gbc);

        txtContrasena = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtContrasena, gbc);

        // Botones
        btnLogin = new JButton("Iniciar Sesión");
        btnRegistrar = new JButton("Registrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnLogin);
        panelBotones.add(btnRegistrar);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBotones, gbc);

        // Acción del Botón Login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText().trim();
                String contrasena = new String(txtContrasena.getPassword()).trim();

                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                PerfilUsuario usuarioAutenticado = ControladorUsuarios.autenticarUsuario(usuario, contrasena);

                if (usuarioAutenticado != null) {
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + usuarioAutenticado.getNombreUsuario() + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new VentanaMenuGeneral();
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del Botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaRegistro();
                dispose();
            }
        });

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }
}
