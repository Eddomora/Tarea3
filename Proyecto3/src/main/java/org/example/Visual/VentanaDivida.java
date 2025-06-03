package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaDivida extends JFrame {
    public Ventana instancia;

    public VentanaDivida() {
        setTitle("The Experience Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1214, 716));
        setSize(1214, 716);
        setResizable(false);
        setLocationRelativeTo(null);

        // Crear los dos paneles
        JPanel panelIzquierdo = new CompradorVisual();
        JPanel panelDerecho = new ExpendedorVisual();

        // Crear el JSplitPane (división horizontal: izquierda-derecha)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);

        // Configurar proporción: 0.33 significa 33% izquierda, 67% derecha
        splitPane.setResizeWeight(.5);

        // Opcionales: evita que el usuario mueva la división y quita la línea divisoria si quieres
        splitPane.setDividerSize(4);       // grosor de la línea
        splitPane.setEnabled(false);       // desactiva mover el divisor

        // Usar BorderLayout para agregar el splitPane al centro
        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
