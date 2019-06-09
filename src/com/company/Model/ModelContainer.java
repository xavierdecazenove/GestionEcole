package com.company.Model;

import javax.swing.*;
import java.awt.*;

// Model de couleur de fond d'une fenêtre classique de l'app
public class ModelContainer extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon m = new ImageIcon("asset/tableau.jpg");
        Image image = m.getImage();

        if (image != null) {
            final double width;
            final double height;
            if (image.getWidth(null) > image.getHeight(null)) {
                final double scale = (getWidth() * 1f) / image.getWidth(null);
                width = getWidth();
                height = image.getHeight(null) * scale;
            } else {
                final double scale = (getHeight() * 1f) / image.getHeight(null);
                height = getHeight();
                width = image.getWidth(null) * scale;
            }
            final double x = (getWidth() - width) / 2;
            final double y = (getHeight() - height) / 2;
            g.drawImage(image, (int) x, (int) y, (int) width, (int) height, this);
        }
    }
}
