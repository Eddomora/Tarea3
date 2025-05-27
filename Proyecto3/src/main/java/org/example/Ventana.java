package org.example;
import javax.swing.JFrame;
import java.awt.*;
//Esto es lo que rescaté de la ayudantía (algunas funciones no se que hacen).
public class Ventana extends JFrame {
    public static final int ANCHO = 1000;
    public static final int ALTO = 800;
    public Ventana instancia;

    private Ventana() {
        setTitle("Titulooo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1014,816));
        setSize(1014,816);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
