package com.company.Model;

import javax.swing.*;
import java.awt.*;

// Modèle de d'affichage de TEXT : Couleur BLANCE et de TAILLE 20
public class ModelLabel extends JLabel {

    public ModelLabel(String text){
        super(text);
        this.setFont(new Font("American Typewriter",Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setForeground(Color.WHITE);
    }
}
