package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Inscription extends Requete {

    private int id;
    private Classe classe;
    private Personne personne;
    private String[] entetes = {"Id","Classe","Nom","Prenom"};


    public Inscription(int id, Classe classe, Personne personne) {
        this.id = id;
        this.classe = classe;
        this.personne = personne;
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Inscription VALUES ('"+getId()+"'," +
                "'"+this.classe.getId()+"',"+
                "'"+this.personne.getId()+"')";
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String[] getEntetes() {
        return this.entetes;
    }

    @Override
    public Object getValueAt(int number) {
        if (number == 0) return this.id;
        else if (number == 1) return this.classe.getNom();
        else if (number == 2) return this.personne.getNom();
        else if (number == 3) return this.personne.getPrenom();
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return connexion.remplirChampsRequete("SELECT * FROM Bulletin,Trimestre,Inscription WHERE Trimestre.Id = Bulletin.IdTrimestre AND Bulletin.IdInscription = "+ this.id ,"Bulletin");
    }


    public void setId(int id) {
        this.id = id;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Inscription";
    }
}
