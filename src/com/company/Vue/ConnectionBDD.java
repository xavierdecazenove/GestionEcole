package com.company.Vue;

import com.company.Controller.Connexion;
import com.company.Model.ModelContainer;
import com.company.Model.ModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ConnectionBDD extends JFrame implements ActionListener{

    private JPanel container = new ModelContainer();

    private JLabel nomBDD = new ModelLabel("Base de donnée");
    private JLabel nomUtilisateur = new ModelLabel("Nom d'utilisateur");
    private JLabel mdp = new ModelLabel("Mots de passe");

    private JTextField nomBDD_tf = new JTextField();
    private JTextField nomUtilisatuer_tf = new JTextField();
    private JPasswordField mdp_tf = new JPasswordField();

    private JButton login = new JButton("Connection");

    private Connexion connexion = new Connexion();

    public ConnectionBDD(){
        this.setTitle("Projet Java");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.container.setLayout(new GridBagLayout());

        // Initialisation : Label nécessaire au formulaire de connexion
        this.initLabelTextField();
        // Initialisation : d'un listener pour lancer la connection à la BDD
        this.login.addActionListener(this);
        // Initialisation : de la grille contenant les champs du formulaire
        this.initGridBagLayout();

        this.setContentPane(this.container);
        this.setVisible(true);
    }

    public void initGridBagLayout(){
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        this.container.add(this.nomBDD,c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.8;
        c.weighty = 1;
        this.container.add(this.nomBDD_tf,c);
        c.gridx = 0;
        c.gridy = 1;
        this.container.add(this.nomUtilisateur,c);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.8;
        c.weighty = 1;
        this.container.add(this.nomUtilisatuer_tf,c);
        c.gridx = 0;
        c.gridy = 2;
        this.container.add(this.mdp,c);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.8;
        c.weighty = 1;
        this.container.add(this.mdp_tf,c);
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.CENTER;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 0;
        this.container.add(this.login,c);
    }

    public void initLabelTextField(){
        this.login.setFont(new Font("American Typewriter",Font.CENTER_BASELINE,20));
        this.nomBDD_tf.setPreferredSize(new Dimension(300,30));
        this.nomUtilisatuer_tf.setPreferredSize(new Dimension(300,30));
        this.mdp_tf.setPreferredSize(new Dimension(300,30));
        this.login.setPreferredSize(new Dimension(200,40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.connexion.connexionBDD("gestionEcole","root","root");
            //Connexion connexion = new Connexion(nomBDD_tf.getText(),nomUtilisatuer_tf.getText(),mdp_tf.getText());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
            Menu menu = new Menu(this.connexion);
            menu.setVisible(true);
            System.out.println("Connexion à la BDD : Sucess");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Connexion à la base de donnée de l'école à échouer");
        }
    }
}
