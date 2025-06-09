package org.example.Visual;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un panel con imagen de fondo personalizada.
 * Extiende JPanel para proporcionar la funcionalidad de mostrar una imagen
 * como fondo que se ajusta automáticamente al tamaño del panel.
 */

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