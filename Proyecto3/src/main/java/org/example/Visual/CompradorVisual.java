package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class CompradorVisual extends JPanel {

    public CompradorVisual() {
        super(new BorderLayout()); // Usamos BorderLayout en el panel principal

        setBackground(Color.LIGHT_GRAY);

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Panel Superior"));

        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.add(new JLabel("Panel Inferior"));

        // Panel central con GridLayout
        PanelMonedas opciones = new PanelMonedas();

        // Agregamos los paneles al BorderLayout
        add(panelSuperior, BorderLayout.NORTH);
        add(opciones, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
}
