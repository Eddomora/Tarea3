package org.example.Visual;

import org.example.Logica.Deposito;
import org.example.Logica.Moneda;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la interfaz visual del comprador en una máquina expendedora.
 * Extiende JPanel para proporcionar una interfaz gráfica que muestra el monedero
 * del comprador, incluyendo las monedas disponibles y el dinero total.
 *
 *
 * @author Ignacio Soto
 */

public class CompradorVisual extends JPanel {
    private Image fondo;
    private JLabel contadorDinero;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private PanelMonedas opciones;

    public static Deposito<Moneda> depositoComprador;

/**
 * Constructor de la clase CompradorVisual.
 * Inicializa todos los componentes visuales, configura el layout y
 * establece la imagen de fondo del monedero.
 *
 */

 public CompradorVisual() {
        super(new BorderLayout());
        depositoComprador = new Deposito<Moneda>();
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

    /**
     * Sobrescribe el método paintComponent para dibujar la imagen de fondo.
     * Este método es llamado automáticamente por Swing cuando el componente
     * necesita ser repintado.
     *
     * @param g El contexto gráfico usado para pintar el componente
     *
     * @see JPanel#paintComponent(Graphics)
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void ingresoMoneda(Moneda m){
        ExpendedorVisual.dep_vuelto.addCosa(m);
        //ExpendedorVisual.dineroDisp += m.getValor();
        ExpendedorVisual.actualizarDinero();
    }
}
