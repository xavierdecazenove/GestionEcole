package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Bulletin extends Requete {

    private int id;
    private Trimestre trimestre;
    private Inscription inscription;
    private String appreciation;

    private String[] entetes = {"Id","Trimestre","Inscription","Appréciation"};

    public Bulletin(int id, Trimestre trimestre, Inscription inscription, String appreciation) {
        this.id = id;
        this.trimestre = trimestre;
        this.inscription = inscription;
        this.appreciation = appreciation;
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Classe VALUES ('"+getId()+"'," +
                "'"+getTrimestre().getId()+"'," +
                "'"+getInscription().getId()+
                "','"+getAppreciation()+")";
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
        else if (number == 1) return this.trimestre.getNumero();
        else if (number == 2) return this.inscription.getId();
        else if (number == 3) return this.appreciation;
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return connexion.remplirChampsRequete("SELECT Evaluation.* FROM Evaluation,Bulletin,DetailBulletin WHERE "+this.id+" = DetailBulletin.IdBulletin AND DetailBulletin.Id = Evaluation.IdDetailBulletin","Evaluation");
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public String toString() {
        return "Bulletin";
    }
}
