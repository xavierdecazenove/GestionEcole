package com.company.Model;

import javax.swing.*;
import java.awt.*;

public class ModelLabel extends JLabel {

    public ModelLabel(String text){
        super(text);
        this.setFont(new Font("American Typewriter",Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setForeground(Color.WHITE);
    }
}
