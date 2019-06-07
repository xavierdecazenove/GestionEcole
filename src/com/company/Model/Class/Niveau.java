package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Niveau extends Requete {

    private int id;
    private String nom;
    private String[] entetes = {"Id","Nom"};

    public Niveau(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Niveau VALUES ("+getId()+"," +
                "'"+getNom()+"')";
    }

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
        if (number == 1) return this.nom;
        return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return connexion.remplirChampsRequete("SELECT Classe.*,Ecole.Nom,Niveau.Nom FROM Classe,Ecole,Niveau WHERE Ecole.Id = Classe.IdEcole AND Niveau.Id = "+this.id,"Classe");
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Niveau";
    }
}
