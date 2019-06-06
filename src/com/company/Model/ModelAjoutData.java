package com.company.Model;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModelAjoutData {

    public static ArrayList<JLabel> accessLabel(String table) {
        if (table.equals("Personne")) {
            JLabel id = new ModelLabel("Id");
            JLabel nom = new ModelLabel("Nom");
            JLabel prenom = new ModelLabel("Prenom");
            JLabel type = new ModelLabel("Type");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(nom);
            labels.add(prenom);
            labels.add(type);

            return labels;
        }
        if (table.equals("Ecole")) {
            JLabel id = new ModelLabel("Id");
            JLabel nom = new ModelLabel("Nom");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(nom);

            return labels;
        }
        return new ArrayList<>();
    }

    public static ArrayList<JTextField> accessTexField(String table){
        if (table.equals("Personne")) {
            JTextField id = new JTextField();
            JTextField nom = new JTextField();
            JTextField prenom = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(nom);
            textFields.add(prenom);
            return textFields;
        }
        if (table.equals("Ecole")) {
            JTextField id = new JTextField();
            JTextField nom = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(nom);
            return textFields;
        }
        return new ArrayList<>();
    }

    public static ArrayList<JComboBox> accessComboBox(String table){
        if (table.equals("Personne")) {
            String[] tab = {"Enseignant", "Eleve"};
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox);

            return comboBoxes;
        }
        if (table.equals("Ecole")) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public static int accessNumberLabelComboBox(String table){
        if (table.equals("Personne")) {
            return 1;
        }
        if (table.equals("Ecole")) {
            return 0;
        }
        return 0;
    }

}
