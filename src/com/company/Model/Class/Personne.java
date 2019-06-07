package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Personne extends Requete {

    private int id;
    private String nom;
    private String prenom;
    private String type;
    private String[] entetes = {"Id","Nom","Prenom","type"};

    public Personne(int id, String nom, String prenom, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String[] getEntetes() {
        return entetes;
    }

    @Override
    public Object getValueAt(int number) {
        if (number == 0) return this.id;
        else if (number == 1) return this.nom;
        else if (number == 2) return this.prenom;
        else if (number == 3) return this.type;
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        if (this.type.equals("Eleve")){
            return connexion.remplirChampsRequete("SELECT * FROM Inscription WHERE Inscription.IdPersonne = "+this.id,"Inscription");
        }else {
            return null;
        }
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getType() {
        return type;
    }


    @Override
    public String requeteAdd(){
        return "INSERT INTO Personne VALUES ("+getId()+"," +
                "'"+getNom()+"',"+
                "'"+getPrenom()+"',"+
                "'"+getType()+"')";
    }

    @Override
    public String toString() {
        return "Personne";
    }
}
