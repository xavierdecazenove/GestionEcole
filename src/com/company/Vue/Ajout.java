package com.company.Vue;

import com.company.Model.Class.Ecole;
import com.company.Model.Class.Personne;
import com.company.Model.ModelButton;
import com.company.Model.ModelContainer;
import com.company.Model.ModelTableau;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Ajout  extends JFrame implements ActionListener {

    private ModelTableau model;

    private JPanel container = new ModelContainer();

    private JButton retour = new ModelButton("Retour");
    private JButton ajouter = new ModelButton("Ajouter");

    private ArrayList<JLabel> labels;
    private ArrayList<JTextField> textFields;
    private ArrayList<JComboBox> comboBoxes;

    private String table;

    public Ajout(ModelTableau model, String table, ArrayList<JLabel> labels, ArrayList<JTextField> textFields, ArrayList<JComboBox> comboBoxes, int numberComboBox){

        this.model = model;
        this.labels = labels;
        this.textFields = textFields;
        this.comboBoxes = comboBoxes;
        this.table = table;

        this.setTitle("Formulaire Ajout");
        this.setSize(420, 280);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.container.setBorder(new EmptyBorder(20,20,20,20));
        this.container.setLayout(new GridLayout(this.labels.size()+1,2,10,10));

        this.ajouter.addActionListener(this);
        this.retour.addActionListener(this);

        // Initialisation : du nombre de labels et textfield nécessairent pour un CERTAINS Ajout
        for (int i=0; i<(this.labels.size()-numberComboBox); i++){
            this.container.add(this.labels.get(i));
            this.container.add(this.textFields.get(i));
        }
        // Initialisation : des comboBox nécessaires
        if (this.comboBoxes != null){
            for (int i=0; i<numberComboBox; i++){
                this.container.add(this.labels.get(i + this.labels.size() - numberComboBox));
                this.container.add(this.comboBoxes.get(i));
            }
        }

        this.container.add(retour);
        this.container.add(ajouter);

        this.setContentPane(this.container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getText().equals("Ajouter")){
            // Action : check si les textfields sont remplient
            boolean ok = true;
            for (int i=0; i<this.textFields.size(); i++){
                if (this.textFields.get(i).getText() == null){
                    ok = false;
                }
            }
            // Action : rajoute un item au tableau en fonction du Type
            if (ok){
                if (table.equals("Personne")){
                    Personne personne = new Personne(Integer.parseInt(textFields.get(0).getText()),textFields.get(1).getText(), textFields.get(2).getText(),(String) Objects.requireNonNull(this.comboBoxes.get(0).getSelectedItem()));
                    model.addItem(personne);
                    dispose();
                }
                if (table.equals("Ecole")){
                    Ecole ecole = new Ecole(Integer.parseInt(textFields.get(0).getText()),textFields.get(1).getText());
                    model.addItem(ecole);
                    dispose();
                }
                dispose();
            }
        }
        // Action : cancel l'ajout d'élément
        if (button.getText().equals("Retour")){
            dispose();
        }
    }
}