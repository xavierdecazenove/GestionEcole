package com.company.Model;

import javax.swing.*;
import java.awt.*;

public class ModelButton extends JButton {

    public ModelButton(String text){
        super(text);
        this.setFont(new Font("American Typewriter",Font.BOLD,20));
        this.setForeground(new Color(27,90,69));
    }

    public ModelButton(String text, ImageIcon imageIcon){
        super(text);
        this.setFont(new Font("American Typewriter",Font.BOLD,20));
        this.setForeground(new Color(27,90,69));
        setIcon(resizeIcon(imageIcon, 50, 50));
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
