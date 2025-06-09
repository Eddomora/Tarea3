package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class VentanaDivida extends JFrame {

    public VentanaDivida() {
        setTitle("The Experience Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1214, 716));
        setSize(1214, 716);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelIzquierdo = new CompradorVisual();
        JPanel panelDerecho = new ExpendedorVisual();

        // Esto divide la pantalla en 2
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);

        // Proporción de division
        splitPane.setResizeWeight(.5);

        //Linea divisora
        splitPane.setDividerSize(4);
        splitPane.setEnabled(false);

        // Usar BorderLayout para agregar el splitPane al centro
        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
