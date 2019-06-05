package com.company.Vue;

import com.company.Model.*;
import com.company.Model.Class.Personne;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AjoutPersonne extends JFrame implements ActionListener {

    private ModelTableau model;

    private JPanel container = new ModelContainer();

    private JLabel id = new ModelLabel("Id");
    private JLabel nom = new ModelLabel("Nom");
    private JLabel prenom = new ModelLabel("Prenom");
    private JLabel type = new ModelLabel("Type");

    private JTextField id_tf = new JTextField();
    private JTextField nom_tf = new JTextField();
    private JTextField prenom_tf = new JTextField();

    private JComboBox comboBox;

    private JButton retour = new ModelButton("Retour");
    private JButton ajouter = new ModelButton("Ajouter");

    public AjoutPersonne(ModelTableau model){

        this.model = model;

        this.setTitle("Formulaire Ajout");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.container.setBorder(new EmptyBorder(20,20,20,20));
        this.container.setLayout(new GridLayout(5,2,10,10));

        String[] tab = {"Enseignant", "Eleve"};
        this.comboBox = new JComboBox(tab);
        this.comboBox.setPreferredSize(new Dimension(150, 50));

        this.ajouter.addActionListener(this);
        this.retour.addActionListener(this);

        this.container.add(id);
        this.container.add(id_tf);
        this.container.add(nom);
        this.container.add(nom_tf);
        this.container.add(prenom);
        this.container.add(prenom_tf);
        this.container.add(type);
        this.container.add(comboBox);
        this.container.add(retour);
        this.container.add(ajouter);

        this.setContentPane(this.container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (button.getText().equals("Ajouter")){
            if (id_tf.getText() != null && nom_tf.getText() != null && prenom_tf.getText() != null){
                Personne personne = new Personne(Integer.parseInt(id_tf.getText()),nom_tf.getText(), prenom_tf.getText(),(String) Objects.requireNonNull(comboBox.getSelectedItem()));
                model.addItem(personne);
                dispose();
            }
        }
        if (button.getText().equals("Retour")){
            dispose();
        }

    }
}
