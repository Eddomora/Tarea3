package org.example.Visual;

import org.example.Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {
    private JButton boton1500;
    private JButton boton1000;
    private JButton boton500;
    private JButton boton100;

    private JLabel contadorDinero;

    Moneda moneda;
    int totalDinero;
    public PanelMonedas(JLabel contador) {
        super(new FlowLayout());

        this.contadorDinero = contador;

        setBackground(Color.LIGHT_GRAY);
        JPanel Opciones = new JPanel();
        Opciones.setLayout((new GridLayout(4, 1)));

        // Crear botones y cambiar tamaño
        boton1500 = new JButton("Moneda de 1500");
        boton1000 = new JButton("Moneda de 1000");
        boton500 = new JButton("Moneda de 500");
        boton100 = new JButton("Moneda de 100");

        Dimension tamanoBoton = new Dimension(150, 150);
        boton1500.setPreferredSize(tamanoBoton);
        boton1000.setPreferredSize(tamanoBoton);
        boton500.setPreferredSize(tamanoBoton);
        boton100.setPreferredSize(tamanoBoton);

        boton1500.addActionListener(e -> agregarDinero(new Moneda1500(3)));
        boton1000.addActionListener(e -> agregarDinero(new Moneda1000(91)));
        boton500.addActionListener(e -> agregarDinero(new Moneda500(23)));
        boton100.addActionListener(e -> agregarDinero(new Moneda100(10)));

        Opciones.add(boton1500);
        Opciones.add(boton1000);
        Opciones.add(boton500);
        Opciones.add(boton100);

        add(Opciones);
    }
    private void agregarDinero(Moneda m) {
        totalDinero += m.getValor();
        contadorDinero.setText("Dinero: $" + totalDinero);
    }
}