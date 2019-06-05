package com.company.Model;

import javax.swing.*;
import java.awt.*;

public class ModelButton extends JButton {

    public ModelButton(String text){
        super(text);
        this.setFont(new Font("American Typewriter",Font.BOLD,20));
        this.setForeground(new Color(27,90,69));
    }

}
