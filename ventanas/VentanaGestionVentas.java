package controladores.ventanas;

import javax.swing.*;
import java.awt.*;

import controladores.controlladores.ControladorInventario;
import controladores.controlladores.ControladorUsuarios;
import controladores.modelos.Helado;
import controladores.modelos.Venta;

public class VentanaGestionVentas extends JFrame {

    private JTextArea txtVentas;

    public VentanaGestionVentas() {

        setTitle("Gestión de Ventas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Visualización de ventas
        txtVentas = new JTextArea(15, 40);
        txtVentas.setEditable(false);
        actualizarListaVentas();
        add(new JScrollPane(txtVentas), BorderLayout.CENTER);

        // Panel de acciones
        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnAgregar = new JButton("Registrar Venta");
        JButton btnEliminar = new JButton("Eliminar Venta");

        panelAcciones.add(btnAgregar);
        panelAcciones.add(btnEliminar);

        add(panelAcciones, BorderLayout.SOUTH);

        // Acción de botones
        btnAgregar.addActionListener(e -> registrarVenta());
        btnEliminar.addActionListener(e -> eliminarVenta());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarListaVentas() {
        txtVentas.setText("Ventas Realizadas:\n\n");
        for (Venta venta : controladorVentas.obtenerVentas()) {
            txtVentas.append(venta + "\n");
        }
    }

    private void registrarVenta() {
        String nombreHelado = JOptionPane.showInputDialog("Ingrese el nombre del helado:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));

        Helado helado = controladorInventario.obtenerInventario().stream()
                .filter(h -> h.getNombre().equalsIgnoreCase(nombreHelado))
                .findFirst()
                .orElse(null);

        if (helado != null) {
            controladorVentas.registrarVenta(helado, cantidad);
            JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.");
            actualizarListaVentas();
        } else {
            JOptionPane.showMessageDialog(null, "Helado no encontrado.");
        }
    }

    private void eliminarVenta() {
        String indexStr = JOptionPane.showInputDialog("Ingrese el número de venta a eliminar:");
        int index = Integer.parseInt(indexStr);

        try {
            Venta venta = controladorVentas.obtenerVentas().get(index);
            controladorVentas.eliminarVenta(venta);
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente.");
            actualizarListaVentas();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Índice de venta no válido.");
        }
    }
}
