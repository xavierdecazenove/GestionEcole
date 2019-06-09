package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Trimestre extends Requete {

    private int id;
    private AnneeScolaire anneeScolaire;
    private int numero;
    private Date dateDebut;
    private Date datefin;

    private String[] entetes = {"Id","Année Scolaire","Numéro","Date début", "Date fin"};

    public Trimestre(int id, AnneeScolaire anneeScolaire, int numero, Date dateDebut, Date datefin) {
        this.id = id;
        this.anneeScolaire = anneeScolaire;
        this.numero = numero;
        this.dateDebut = dateDebut;
        this.datefin = datefin;
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Trimestre VALUES ("+getId()+"," +
                ""+getAnneeScolaire().getId()+","+
                ""+getNumero()+","+
                "'"+getDateDebut()+"',"+
                "'"+getDatefin()+"')";
    }

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
        else if (number == 1) return this.anneeScolaire.getId();
        else if (number == 2) return this.numero;
        else if (number == 3) return this.dateDebut;
        else if (number == 4) return this.datefin;
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return connexion.remplirChampsRequete("SELECT * FROM Bulletin,Trimestre,Inscription WHERE Trimestre.Numero = "+this.numero+" AND Trimestre.IdAnneeScolaire = "+this.anneeScolaire.getId()+" AND "+this.id+" = Bulletin.IdTrimestre AND Inscription.Id = Bulletin.IdInscription","Bulletin");
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Trimestre";
    }
}
