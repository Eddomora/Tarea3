package org.example.Visual;

import org.example.Logica.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {
    private JButton boton1500;
    private JButton boton1000;
    private JButton boton500;
    private JButton boton100;

    private Random numero;
    private int serie;
    private static JLabel contadorDinero;

    Moneda moneda;
    public static int totalDinero;

    public PanelMonedas(JLabel contador) {
        super(new FlowLayout());

        numero = new Random();

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

        serie = numero.nextInt(1000);
        boton1500.addActionListener(e -> agregarDinero(new Moneda1500(serie)));
        boton1000.addActionListener(e -> agregarDinero(new Moneda1000(serie)));
        boton500.addActionListener(e -> agregarDinero(new Moneda500(serie)));
        boton100.addActionListener(e -> agregarDinero(new Moneda100(serie)));

        Opciones.add(boton1500);
        Opciones.add(boton1000);
        Opciones.add(boton500);
        Opciones.add(boton100);

        add(Opciones);
    }
    private void agregarDinero(Moneda m) {
        try {
            totalDinero += m.getValor();
            CompradorVisual.depositoComprador.addCosa(m);
            contadorDinero.setText("Dinero: $" + totalDinero);
            //CompradorVisual.ingresoMoneda(m);
        } catch (NullPointerException e) {
            e.printStackTrace();  // Muestra la línea exacta del error
        }
        int nuevo = numero.nextInt(1000);
        if (nuevo == serie){
            nuevo = numero.nextInt(1000);
        } else {
            serie = nuevo;
        }
    }
    public static void actualizarDinero() {
        contadorDinero.setText("DINERO: $" + totalDinero);
    }
}