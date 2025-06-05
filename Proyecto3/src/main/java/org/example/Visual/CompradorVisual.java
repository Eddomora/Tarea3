package org.example.Visual;

import org.example.Logica.Expendedor;
import org.example.Logica.Moneda;
import javax.swing.*;
import java.awt.*;

public class CompradorVisual extends JPanel {
    private Image fondo;
    private JLabel contadorDinero;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private PanelMonedas opciones;

    public CompradorVisual() {
        super(new BorderLayout());
        fondo = new ImageIcon(getClass().getResource("/monedero.png")).getImage();

        contadorDinero = new JLabel("Dinero: $0");

        setBackground(Color.LIGHT_GRAY);

        panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Monedero"));


        panelInferior = new JPanel();
        //panelInferior.add(new JLabel("Elige que monedas sacar"));
        panelInferior.add(contadorDinero, BorderLayout.EAST);
        //panelInferior.add();
        opciones = new PanelMonedas(contadorDinero);

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

    public static void ingresoMoneda(Moneda m){
        ExpendedorVisual.m = m;
        ExpendedorVisual.dineroDisp = m.getValor();
    }
}
