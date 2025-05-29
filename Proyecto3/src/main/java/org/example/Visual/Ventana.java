package org.example.Visual;
import javax.swing.JFrame;
import java.awt.*;
//Esto es lo que rescaté de la ayudantía (algunas funciones no se que hacen).
public class Ventana extends JFrame {

    public static final int ANCHO = 1000;
    public static final int ALTO = 800;
    public Ventana instancia;

    public Ventana() {
        setTitle("The Expendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Se cierra al apretar x
        setMinimumSize(new Dimension(1014,816));
        setSize(1014,816); //el mismo que minimunSize
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        Menu_Expendedor me = new Menu_Expendedor();
        add(me, BorderLayout.CENTER);
        setVisible(true);
    }
}
