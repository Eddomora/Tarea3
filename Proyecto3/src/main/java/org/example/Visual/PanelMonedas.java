package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {

    public PanelMonedas() {
        super(new FlowLayout());

        setBackground(Color.LIGHT_GRAY);
        JPanel Opciones = new JPanel();
        Opciones.setLayout((new GridLayout(4, 1)));

        // Crear botones y cambiar tamaño
        JButton boton1500 = new JButton("Moneda de 1500");
        JButton boton1000 = new JButton("Moneda de 1000");
        JButton boton500 = new JButton("Moneda de 500");
        JButton boton100 = new JButton("Moneda de 100");

        Dimension tamanoBoton = new Dimension(150, 150);
        boton1500.setPreferredSize(tamanoBoton);
        boton1000.setPreferredSize(tamanoBoton);
        boton500.setPreferredSize(tamanoBoton);
        boton100.setPreferredSize(tamanoBoton);

        Opciones.add(boton1500);
        Opciones.add(boton1000);
        Opciones.add(boton500);
        Opciones.add(boton100);

        add(Opciones);
    }

}