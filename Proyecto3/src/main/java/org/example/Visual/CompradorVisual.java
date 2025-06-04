package org.example.Visual;

import javax.swing.*;
import java.awt.*;

public class CompradorVisual extends JPanel {
    private Image fondo;
    private JLabel contadorDinero;

    public CompradorVisual() {
        super(new BorderLayout());

        //fondo = new ImageIcon(getClass().getResource("/monedero.png")).getImage();
        contadorDinero = new JLabel("Dinero: $0");

        setBackground(Color.LIGHT_GRAY);

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Monedero"));

        JPanel panelInferior = new JPanel();
        //panelInferior.add(new JLabel("Elige que monedas sacar"));
        panelInferior.add(contadorDinero, BorderLayout.EAST);
        PanelMonedas opciones = new PanelMonedas(contadorDinero);

        opciones.setOpaque(false);

        add(panelSuperior, BorderLayout.NORTH);
        add(opciones, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
