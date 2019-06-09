package com.company.Model;

import com.company.Controller.Connexion;
import com.company.Vue.Graphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


// Modèle de la bar de menu du Haut : MENU, STATISTIQUE, QUITTER
public class BarMenu extends JPanel implements ActionListener{

    private JFrame jFrame;
    private Connexion connexion;

    private JButton button1 = new ModelButton("Menu");
    private JButton button2 = new ModelButton("Statistique",new ImageIcon("asset/statistique.png"));
    private JButton button3 = new ModelButton("Quitter",new ImageIcon("asset/quitter.png"));

    public BarMenu(JFrame jFrame, Connexion connexion){

        this.jFrame = jFrame;
        this.connexion = connexion;

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Menu")){
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.dispose();
            com.company.Vue.Menu menu = new com.company.Vue.Menu(this.connexion);
            menu.setVisible(true);
        }

        if (button.getText().equals("Statistique")){
            try{
                Graphique graphique = new Graphique(connexion);
                graphique.setVisible(true);
            }catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if(button.getText().equals("Quitter")){
            jFrame.dispose();
        }

    }
}
