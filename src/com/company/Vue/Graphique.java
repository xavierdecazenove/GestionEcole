package com.company.Vue;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

import com.company.Controller.Connexion;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;

public class Graphique extends JFrame {
    private JPanel pnl;
    private Connexion connexion;

    public Graphique(Connexion connexion) throws SQLException, ClassNotFoundException {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.setSize(1280, 600);
        this.setLocationRelativeTo(null);
        pnl = new JPanel(new BorderLayout());

        ArrayList<String> nomNiveau = connexion.remplirChampsRequete("SELECT Niveau.Nom FROM Niveau","NomNiveau");
        ArrayList<String> personnes;

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i=0; i<nomNiveau.size(); i++){
            personnes = connexion.remplirChampsRequete("SELECT Personne.Id FROM Personne,Classe,Inscription,Niveau WHERE Personne.Id = Inscription.IdPersonne AND Classe.Id = Inscription.IdClasse AND Classe.IdNiveau = Niveau.Id AND Niveau.Nom = '"+nomNiveau.get(i)+"'","ING");
            pieDataset.setValue(nomNiveau.get(i), personnes.size());
        }
        JFreeChart pieChart = ChartFactory.createPieChart("Nombres d'élèves par niveaux", pieDataset, true, false, false);
        ChartPanel cPanel = new ChartPanel(pieChart);
        cPanel.setPreferredSize(new Dimension(400,400));

        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset( );
        lineDataset.addValue( 15 , "Inscriptions" , "2015" );
        lineDataset.addValue( 30 , "Inscriptions" , "2016" );
        lineDataset.addValue( 60 , "Inscriptions" ,  "2017" );
        lineDataset.addValue( 120 , "Inscriptions" , "2018" );
        lineDataset.addValue( 240 , "Inscriptions" , "2019" );
        lineDataset.addValue( 300 , "Inscriptions" , "2020" );
        JFreeChart lineChart = ChartFactory.createLineChart("Nombres d'inscriptions par année", "Nombres d'inscriptions", "Année", lineDataset, PlotOrientation.VERTICAL, true,true,false);
        ChartPanel cPanel1 = new ChartPanel(lineChart);
        cPanel1.setPreferredSize(new Dimension(400,400));


        ArrayList<Integer> personneNumber;
        ArrayList<String> row = new ArrayList<>();
        row.add("< 10");
        row.add("BETWEEN 10 AND 15");
        row.add("> 15");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int j=0; j<row.size(); j++){
            for (int i=0; i<nomNiveau.size(); i++){
                personneNumber = connexion.remplirChampsRequete("SELECT COUNT(Personne.Id) FROM Personne,Inscription,Bulletin,DetailBulletin,Evaluation,Classe,Niveau WHERE Personne.Id = Inscription.IdPersonne AND Inscription.Id = Bulletin.IdInscription AND Bulletin.Id = DetailBulletin.IdBulletin AND DetailBulletin.Id = Evaluation.IdDetailBulletin AND Inscription.IdClasse = Classe.Id AND Niveau.Id = Classe.IdNiveau AND Niveau.Nom = '"+nomNiveau.get(i)+"' AND Evaluation.Note "+row.get(j),"ING");
                dataset.addValue(personneNumber.get(0), row.get(j), nomNiveau.get(i));
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("Moyennes des élèves par niveaux", "", "Nombre d'élèves", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cPanel2 = new ChartPanel(barChart);
        cPanel2.setPreferredSize(new Dimension(400,400));

        pnl.add(cPanel,BorderLayout.WEST);
        pnl.add(cPanel1,BorderLayout.EAST);
        pnl.add(cPanel2,BorderLayout.CENTER);
        this.setContentPane(this.pnl);
        this.setVisible(true);
    }
}
