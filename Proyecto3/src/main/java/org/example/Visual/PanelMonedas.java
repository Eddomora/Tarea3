package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {

    public PanelMonedas() {
        super(new GridLayout());
        setBackground(Color.LIGHT_GRAY);
        JPanel Opciones = new JPanel();
        Opciones.setLayout((new GridLayout(3, 3)));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));
        Opciones.add(new JButton("Algo"));

        add(Opciones);
    }
}