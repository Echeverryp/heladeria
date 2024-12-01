package controladores.ventanas;

import javax.swing.*;
import java.awt.*;

import controladores.controlladores.ControladorInventario;
import controladores.modelos.Helado;

public class VentanaGestionInventario extends JFrame {
    private JTextArea txtInventario;

    public VentanaGestionInventario() {

        setTitle("Gestión de Inventario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lista de inventario
        txtInventario = new JTextArea(15, 40);
        txtInventario.setEditable(false);
        actualizarListaInventario();
        add(new JScrollPane(txtInventario), BorderLayout.CENTER);

        // Panel de acciones
        JPanel panelAcciones = new JPanel(new FlowLayout());
        JButton btnAgregar = new JButton("Agregar Helado");
        JButton btnEliminar = new JButton("Eliminar Helado");
        JButton btnActualizar = new JButton("Actualizar Helado");

        panelAcciones.add(btnAgregar);
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnActualizar);

        add(panelAcciones, BorderLayout.SOUTH);

        // Acciones de botones
        btnAgregar.addActionListener(e -> agregarHelado());
        btnEliminar.addActionListener(e -> eliminarHelado());
        btnActualizar.addActionListener(e -> actualizarHelado());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarListaInventario() {
        txtInventario.setText("Inventario Actual:\n\n");
        for (Helado helado : ControladorInventario.obtenerInventario()) {
            txtInventario.append(helado + "\n");
        }
    }

    private void agregarHelado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del helado:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de venta:"));
        double costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo de producción:"));

        try {
            ControladorInventario.agregarHelado(new Helado(nombre, precio, costo));
            JOptionPane.showMessageDialog(null, "Helado agregado exitosamente.");
            actualizarListaInventario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar helado: " + e.getMessage());
        }
    }

    private void eliminarHelado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del helado a eliminar:");
        try {
            ControladorInventario.eliminarHelado(nombre);
            JOptionPane.showMessageDialog(null, "Helado eliminado exitosamente.");
            actualizarListaInventario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar helado: " + e.getMessage());
        }
    }

    private void actualizarHelado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del helado a actualizar:");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio de venta:"));
        double nuevoCosto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo costo de producción:"));

        try {
            ControladorInventario.actualizarHelado(nombre, nuevoPrecio, nuevoCosto);
            JOptionPane.showMessageDialog(null, "Helado actualizado exitosamente.");
            actualizarListaInventario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar helado: " + e.getMessage());
        }
    }
}
