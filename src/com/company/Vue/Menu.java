package com.company.Vue;

import com.company.Controller.Connexion;
import com.company.Controller.Controller;
import com.company.Model.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu extends JFrame implements ActionListener {

    private JPanel container = new ModelContainer();

    private JPanel menu = new JPanel();
    private JPanel edit = new JPanel();
    private JPanel content = new JPanel();
    private JPanel choix = new JPanel();

    private JButton supprimer = new ModelButton("Supprimer",new ImageIcon("asset/supprimer.png"));
    private JButton ajouter = new ModelButton("Ajouter",new ImageIcon("asset/ajouter.png"));
    private JButton rechercher = new ModelButton("Rechercher",new ImageIcon("asset/rechercher.png"));

    private JButton ecole = new ModelButton("Ecoles",new ImageIcon("asset/ecole.png"));
    private JButton niveau = new ModelButton("Niveaux",new ImageIcon("asset/niveau.png"));
    private JButton classe = new ModelButton("Classes",new ImageIcon("asset/classe.png"));
    private JButton inscription = new ModelButton("Inscriptions",new ImageIcon("asset/inscription.png"));
    private JButton personne = new ModelButton("Personnes",new ImageIcon("asset/personne.png"));
    private JButton trimestre = new ModelButton("Trimestres",new ImageIcon("asset/trimestre.png"));
    private JButton bulletin = new ModelButton("Bulletins",new ImageIcon("asset/bulletin.png"));
    private JButton evaluation = new ModelButton("Evaluations",new ImageIcon("asset/evaluation.png"));


    private JTable table;
    private ModelTableau modelTableau;

    private Connexion connexion;

    public Menu(Connexion connexion){

        this.connexion = connexion;
        // Initialisation : BarMenu en header
        BarMenu barMenu = new BarMenu(this, connexion);

        this.setTitle("Projet Java");
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.container.setLayout(new BorderLayout());

        // Initialisation : Grille pour le header Menu
        this.menu.setLayout(new GridLayout(1,3));
        this.menu.add(barMenu.getButton1());
        this.menu.add(barMenu.getButton2());
        this.menu.add(barMenu.getButton3());

        // Initialisation : Grille pour le bottom Menu
        this.edit.setLayout(new GridLayout(1,3));
        this.edit.add(this.rechercher);
        this.edit.add(this.ajouter);
        this.edit.add(this.supprimer);

        // Initialisation : Grille pour les Boutons de Gauche
        this.choix.setLayout(new GridLayout(8,1));
        this.choix.add(this.ecole);
        this.choix.add(this.niveau);
        this.choix.add(this.classe);
        this.choix.add(this.inscription);
        this.choix.add(this.personne);
        this.choix.add(this.trimestre);
        this.choix.add(this.bulletin);
        this.choix.add(this.evaluation);

        // Initialisation : Tableau
        this.content.setLayout(new GridBagLayout());
        this.modelTableau = new ModelTableau(this.connexion,new ArrayList<>(),new String[0],"init");
        table = new JTable(this.modelTableau);
        JScrollPane column = new JScrollPane(table);

        // Initialisation : Couleur transparent pour le centre de la grille
        this.content.add(column);
        this.content.setBackground(new Color(0,0,0,0));

        // Initialisation : Listeneur pour les boutons du Menu
        this.ajouter.addActionListener(this);
        this.rechercher.addActionListener(this);
        this.supprimer.addActionListener(this);
        this.ecole.addActionListener(this);
        this.niveau.addActionListener(this);
        this.classe.addActionListener(this);
        this.inscription.addActionListener(this);
        this.personne.addActionListener(this);
        this.trimestre.addActionListener(this);
        this.bulletin.addActionListener(this);
        this.evaluation.addActionListener(this);

        // Initialisation : COntraintes de position
        this.container.add(this.content, BorderLayout.CENTER);
        this.container.add(this.edit, BorderLayout.SOUTH);
        this.container.add(this.menu, BorderLayout.NORTH);
        this.container.add(this.choix, BorderLayout.WEST);
        this.setContentPane(this.container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Controller controller = new Controller(connexion);

        // Action : Supprime de la table et de la BDD l'element sélectionner
        if(button.getText().equals("Supprimer")){
            int[] selection = table.getSelectedRows();
            for(int i = selection.length - 1; i >= 0; i--){
                modelTableau.removeItem(selection[i]);
            }
        }
        // Action : Affiche un formulaire pour ajouter un nouvel élément à la BDD
        if(button.getText().equals("Ajouter")){
            if(modelTableau.getTable().equals("Ecole")){
                Ajout ajout = new Ajout(modelTableau,"Ecole", ModelAjoutData.accessLabel("Ecole"), ModelAjoutData.accessTexField("Ecole"),ModelAjoutData.accessComboBox("Ecole"),ModelAjoutData.accessNumberLabelComboBox("Ecole"));
                ajout.setVisible(true);
            }
            if(modelTableau.getTable().equals("Niveau")){
            }
            if(modelTableau.getTable().equals("Classe")){
            }
            if(modelTableau.getTable().equals("Inscription")){
            }
            if(modelTableau.getTable().equals("Personne")){
                Ajout ajout = new Ajout(modelTableau,"Personne", ModelAjoutData.accessLabel("Personne"), ModelAjoutData.accessTexField("Personne"),ModelAjoutData.accessComboBox("Personne"),ModelAjoutData.accessNumberLabelComboBox("Personne"));
                ajout.setVisible(true);
            }
            if(modelTableau.getTable().equals("Trimestre")){
            }
            if(modelTableau.getTable().equals("Bulletin")){
            }
            if(modelTableau.getTable().equals("Evaluation")){
            }
        }
        // Action : Recherche l'élément en lien avec celui sélectionner dans l'arbre des dépendances de la BDD
        if(button.getText().equals("Rechercher")){
            int[] selection = table.getSelectedRows();
            for(int i = selection.length - 1; i >= 0; i--){
                try {
                    modelTableau = modelTableau.rechercheItem(selection[i]);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }



        //****** Action : Charge un nouveau model de tableau en fonction du bouton appuyer ******//


        if (button.getText().equals("Ecoles")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.ecolesBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Niveaux")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.niveauxBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Classes")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.classesBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Inscriptions")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.inscriptionsBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Personnes")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.personnesBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Trimestres")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.trimestresBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Bulletins")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.bulletinsBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (button.getText().equals("Evaluations")){
            try {
                modelTableau = modelTableau.changeItemOnClick(controller.evaluationsBDD());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private JComponent createAlternating(AbstractTableModel model)
    {
        JTable table = new JTable( model )
        {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                //  Alternate row color

                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);

                return c;
            }
        };

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.changeSelection(0, 0, false, false);
        return new JScrollPane( table );
    }
}
