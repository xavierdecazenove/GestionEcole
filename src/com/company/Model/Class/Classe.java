package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Classe extends Requete {

    private int id;
    private String nom;
    private Ecole ecole;
    private AnneeScolaire anneeScolaire;
    private Niveau niveau;


    private String[] entetes = {"Id","Nom","AnneeScolaire","Niveau","Ecole"};

    public Classe(int id, Ecole ecole, AnneeScolaire anneeScolaire, Niveau niveau, String nom) {
        this.id = id;
        this.ecole = ecole;
        this.anneeScolaire = anneeScolaire;
        this.niveau = niveau;
        this.nom = nom;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String[] getEntetes() {
        return this.entetes;
    }

    @Override
    public Object getValueAt(int number) {
        if (number == 0) return this.id;
        else if (number == 1) return this.nom;
        else if (number == 2) return this.anneeScolaire.getId();
        else if (number == 3) return this.niveau.getNom();
        else if (number == 4) return this.ecole.getNom();
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return connexion.remplirChampsRequete("SELECT Inscription.*,Classe.Nom,Personne.Nom,Personne.Prenom,Personne.Type FROM Inscription,Classe,Personne WHERE Classe.Id = "+this.id+" AND Inscription.IdPersonne = Personne.Id","Inscription");
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Classe VALUES ("+this.id+"," +
                ""+this.ecole.getId()+"," +
                ""+this.anneeScolaire.getId()+
                ","+this.niveau.getId()+","+
                "'"+this.nom+"')";
    }

    @Override
    public String toString() {
        return "Classe";
    }




    public void setId(int id) {
        this.id = id;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
