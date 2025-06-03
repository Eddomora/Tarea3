package org.example.Visual;
import javax.swing.*;
import java.awt.*;

public class Fondos extends JPanel {
    private Image imagenFondo;

    public Fondos(String rutaImagen) {

        ImageIcon imagen = new ImageIcon(getClass().getResource(rutaImagen));
        imagenFondo = imagen.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen en el tamaño del panel
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}