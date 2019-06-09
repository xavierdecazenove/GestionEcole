package com.company.Model;
import com.company.Controller.Connexion;
import com.company.Controller.Controller;
import com.company.Model.Class.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;


// Classe Modèle permettant l'affiche de formulmaire différents en fonstion du formulaire d'ajout demander
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
        if (table.equals("Evaluations")) {
            JLabel id = new ModelLabel("Id");
            JLabel note = new ModelLabel("Note");
            JLabel appreciation = new ModelLabel("Appreciation");
            JLabel detailBulletin = new ModelLabel("Detail Bulletin");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(note);
            labels.add(appreciation);
            labels.add(detailBulletin);

            return labels;
        }
        if (table.equals("Classe")) {
            JLabel id = new ModelLabel("Id");
            JLabel nom = new ModelLabel("Nom");
            JLabel ecole = new ModelLabel("Ecole");
            JLabel anneeScolaire = new ModelLabel("Année Scolaire");
            JLabel niveau = new ModelLabel("Niveau");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(nom);
            labels.add(ecole);
            labels.add(anneeScolaire);
            labels.add(niveau);

            return labels;
        }
        if (table.equals("Niveau")) {
            JLabel id = new ModelLabel("Id");
            JLabel nom = new ModelLabel("Nom");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(nom);

            return labels;
        }
        if (table.equals("Inscription")){
            JLabel id = new ModelLabel("Id");
            JLabel classe = new ModelLabel("Classes");
            JLabel personne = new ModelLabel("Personnes");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(classe);
            labels.add(personne);

            return labels;
        }
        if (table.equals("Trimestre")){
            JLabel id = new ModelLabel("Id");
            JLabel dateDebut = new ModelLabel("Date début");
            JLabel dateFin = new ModelLabel("Date fin");
            JLabel numero = new ModelLabel("Numéro");
            JLabel anneeScolaire = new ModelLabel("Année Scolaire");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(dateDebut);
            labels.add(dateFin);
            labels.add(numero);
            labels.add(anneeScolaire);

            return labels;
        }
        if (table.equals("Bulletin")){
            JLabel id = new ModelLabel("Id");
            JLabel trimestre = new ModelLabel("Trimestre");
            JLabel inscription = new ModelLabel("Inscription");
            JLabel appreciation = new ModelLabel("Appréciation");

            ArrayList<JLabel> labels = new ArrayList<>();
            labels.add(id);
            labels.add(appreciation);
            labels.add(trimestre);
            labels.add(inscription);

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

        if (table.equals("Niveau")) {
            JTextField id = new JTextField();
            JTextField nom = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(nom);
            return textFields;
        }

        if (table.equals("Evaluations")) {
            JTextField id = new JTextField();
            JTextField note = new JTextField();
            JTextField appreciation = new JTextField();


            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(note);
            textFields.add(appreciation);

            return textFields;
        }

        if (table.equals("Classe")) {
            JTextField id = new JTextField();
            JTextField nom = new JTextField();
            JTextField ecole = new JTextField();
            JTextField anneeScolaire = new JTextField();
            JTextField niveau = new JTextField();


            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(nom);
            textFields.add(ecole);
            textFields.add(anneeScolaire);
            textFields.add(niveau);

            return textFields;
        }

        if (table.equals("Inscription")){
            JTextField id = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);

            return textFields;
        }
        if (table.equals("Trimestre")){
            JTextField id = new JTextField();
            JTextField dateDebut = new JTextField();
            JTextField dateFin = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(dateDebut);
            textFields.add(dateFin);

            return textFields;
        }
        if (table.equals("Bulletin")){
            JTextField id = new JTextField();
            JTextField appreciation = new JTextField();

            ArrayList<JTextField> textFields = new ArrayList<>();
            textFields.add(id);
            textFields.add(appreciation);

            return textFields;
        }
        return new ArrayList<>();
    }

    public static ArrayList<JComboBox> accessComboBox(String table, Connexion connexion) throws SQLException, ClassNotFoundException {

        Controller controller =new Controller(connexion);

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

        if (table.equals("Classe")) {
            ArrayList<Ecole> ecole = connexion.remplirChampsRequete("SELECT * FROM Ecole","Ecole");
            String[] tab = new String[ecole.size()];
            for (int i=0; i<ecole.size(); i++){
                tab[i] = String.valueOf(ecole.get(i).getNom());
            }
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            ArrayList<AnneeScolaire> anneeScolaire = connexion.remplirChampsRequete("SELECT * FROM AnneeScolaire","AnneeScolaire");
            String[] tab1 = new String[anneeScolaire.size()];
            for (int i=0; i<anneeScolaire.size(); i++){
                tab1[i] = String.valueOf(anneeScolaire.get(i).getId());
            }
            JComboBox comboBox1 = new JComboBox(tab1);
            comboBox1.setPreferredSize(new Dimension(150, 50));

            ArrayList<Niveau> niveau = connexion.remplirChampsRequete("SELECT * FROM Niveau","Niveau");
            String[] tab2 = new String[niveau.size()];
            for (int i=0; i<niveau.size(); i++){
                tab2[i] = String.valueOf(niveau.get(i).getNom());
            }
            JComboBox comboBox2 = new JComboBox(tab2);
            comboBox2.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox);
            comboBoxes.add(comboBox1);
            comboBoxes.add(comboBox2);

            return comboBoxes;

        }

        if (table.equals("Evaluations")) {
            ArrayList<DetailBulletin> detailBulletins = connexion.remplirChampsRequete("SELECT * FROM DetailBulletin","DetailBulletin");
            String[] tab = new String[detailBulletins.size()];
            for (int i=0; i<detailBulletins.size(); i++){
                tab[i] = String.valueOf(detailBulletins.get(i).getId());
            }
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox);

            return comboBoxes;
        }
        if (table.equals("Niveau")) {
            return new ArrayList<>();
        }
        if (table.equals("Inscription")){
            ArrayList<Classe> classes = controller.classesBDD();
            String[] tab = new String[classes.size()];
            for (int i=0; i<classes.size(); i++){
                tab[i] = String.valueOf(classes.get(i).getId());
            }
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            ArrayList<Personne> personnes = controller.personnesBDD();
            String[] tab2 = new String[personnes.size()];
            for (int i=0; i<personnes.size(); i++){
                tab2[i] = String.valueOf(personnes.get(i).getNom());
            }
            JComboBox comboBox2 = new JComboBox(tab2);
            comboBox2.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox);
            comboBoxes.add(comboBox2);

            return comboBoxes;
        }

        if (table.equals("Trimestre")){
            ArrayList<AnneeScolaire> anneeScolaires = connexion.remplirChampsRequete("SELECT * FROM AnneeScolaire","AnneeScolaire");
            String[] tab = new String[anneeScolaires.size()];
            for (int i=0; i<anneeScolaires.size(); i++){
                tab[i] = String.valueOf(anneeScolaires.get(i).getId());
            }
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            String[] tab2 = {"1", "2", "3"};
            JComboBox comboBox2 = new JComboBox(tab2);
            comboBox2.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox2);
            comboBoxes.add(comboBox);

            return comboBoxes;
        }
        if (table.equals("Bulletin")){
            ArrayList<Trimestre> trimestres = connexion.remplirChampsGlobal("SELECT * FROM Trimestre","Trimestre");
            String[] tab = new String[trimestres.size()];
            for (int i=0; i<trimestres.size(); i++){
                tab[i] = String.valueOf(trimestres.get(i).getId());
            }
            JComboBox comboBox = new JComboBox(tab);
            comboBox.setPreferredSize(new Dimension(150, 50));

            ArrayList<Inscription> inscriptions = controller.inscriptionsBDD();
                    //connexion.remplirChampsRequete("SELECT * FROM Inscription","Inscription");
            String[] tab2 = new String[inscriptions.size()];
            for (int i=0; i<inscriptions.size(); i++){
                tab2[i] = String.valueOf(inscriptions.get(i).getId());
            }
            JComboBox comboBox2 = new JComboBox(tab2);
            comboBox2.setPreferredSize(new Dimension(150, 50));

            ArrayList<JComboBox> comboBoxes = new ArrayList<>();
            comboBoxes.add(comboBox);
            comboBoxes.add(comboBox2);

            return comboBoxes;
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
        if (table.equals("Evaluations")) {
            return 1;
        }
        if (table.equals("Niveau")) {
            return 0;
        }
        if (table.equals("Classe")) {
            return 3;
        }
        if (table.equals("Inscription")){
            return 2;
        }
        if (table.equals("Trimestre")){
            return 2;
        }
        if (table.equals("Bulletin")){
            return 2;
        }
        return 0;
    }

}
