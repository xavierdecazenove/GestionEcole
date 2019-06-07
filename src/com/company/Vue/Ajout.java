package com.company.Vue;

import com.company.Controller.Connexion;
import com.company.Model.Class.*;
import com.company.Model.ModelButton;
import com.company.Model.ModelContainer;
import com.company.Model.ModelTableau;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private Connexion connexion = new Connexion();

    public Ajout(ModelTableau model, String table, ArrayList<JLabel> labels, ArrayList<JTextField> textFields, ArrayList<JComboBox> comboBoxes, int numberComboBox) throws SQLException, ClassNotFoundException {

        this.connexion.connexionBDD("gestionEcole","root","root");
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
                    Personne personne = new Personne(Integer.parseInt(textFields.get(0).getText()),textFields.get(1).getText(), textFields.get(2).getText(),(String) this.comboBoxes.get(0).getSelectedItem());
                    model.addItem(personne);
                    dispose();
                }
                if (table.equals("Ecole")){
                    System.out.println(Integer.parseInt(textFields.get(0).getText())+"|"+textFields.get(1).getText());
                    Ecole ecole = new Ecole(Integer.parseInt(textFields.get(0).getText()),textFields.get(1).getText());
                    model.addItem(ecole);
                    dispose();
                }
                if (table.equals("Niveau")){
                    Niveau niveau = new Niveau(Integer.parseInt(textFields.get(0).getText()),textFields.get(1).getText());
                    model.addItem(niveau);
                    dispose();
                }
                if (table.equals("Classe")){
                    Classe classe = new Classe(Integer.parseInt(textFields.get(0).getText()),new Ecole(Integer.parseInt((String) comboBoxes.get(0).getSelectedItem()),""),new AnneeScolaire(Integer.parseInt((String) comboBoxes.get(1).getSelectedItem())),new Niveau(Integer.parseInt((String) comboBoxes.get(2).getSelectedItem()),""),textFields.get(1).getText());
                    model.addItem(classe);
                    dispose();
                }
                if (table.equals("Inscription")){
                    try {
                        ArrayList<Personne> personnes = this.connexion.remplirChampsRequete("SELECT * FROM Personne WHERE Personne.Nom = "+comboBoxes.get(0).getSelectedItem(),"Personne");
                        Inscription inscription = new Inscription(Integer.parseInt(textFields.get(0).getText()),new Classe(Integer.parseInt((String) comboBoxes.get(0).getSelectedItem()),null, null, null,""),new Personne(personnes.get(0).getId(),personnes.get(0).getNom(),personnes.get(0).getPrenom(),personnes.get(0).getType()));
                        model.addItem(inscription);
                        dispose();
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                if (table.equals("Trimestre")){
                    try {
                        Date date1=new SimpleDateFormat("YYYY-MM-DD").parse(textFields.get(1).getText());
                        Date date2=new SimpleDateFormat("YYYY-MM-DD").parse(textFields.get(2).getText());
                        Trimestre trimestre = new Trimestre(Integer.parseInt(textFields.get(0).getText()),new AnneeScolaire(Integer.parseInt((String) comboBoxes.get(1).getSelectedItem())),Integer.parseInt((String) comboBoxes.get(1).getSelectedItem()),date1,date2);
                        model.addItem(trimestre);
                        dispose();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
                if (table.equals("Bulletin")){
                    Bulletin bulletin = new Bulletin(Integer.parseInt(textFields.get(0).getText()),new Trimestre(Integer.parseInt((String) comboBoxes.get(0).getSelectedItem()),null,0,null,null),new Inscription(Integer.parseInt((String) comboBoxes.get(1).getSelectedItem()),null,null),textFields.get(1).getText());
                    model.addItem(bulletin);
                    dispose();
                }
                if (table.equals("Evaluation")){
                    Evaluation evaluation = new Evaluation(Integer.parseInt(textFields.get(0).getText()),new DetailBulletin((Integer) comboBoxes.get(0).getSelectedItem(),null,null,""),Integer.parseInt(textFields.get(1).getText()),textFields.get(2).getText());
                    model.addItem(evaluation);
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