package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.sql.SQLException;
import java.util.ArrayList;

public class Evaluation extends Requete {

    private int id;
    private DetailBulletin detailBulletin;
    private int note;
    private String appreciation;

    private String[] entetes = {"Id","Détail Bulletin","Note","Appréciation"};

    public Evaluation(int id, DetailBulletin detailBulletin, int note, String appreciation) {
        this.id = id;
        this.detailBulletin = detailBulletin;
        this.note = note;
        this.appreciation = appreciation;
    }

    @Override
    public String requeteAdd() {
        return "INSERT INTO Evaluation VALUES ("+this.id+"," +
                ""+this.detailBulletin.getId()+","+
                ""+this.note+","+
                "'"+this.appreciation+"')";
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
        else if (number == 1) return this.detailBulletin.getId();
        else if (number == 2) return this.note;
        else if (number == 3) return this.appreciation;
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetailBulletin getDetailBulletin() {
        return detailBulletin;
    }

    public void setDetailBulletin(DetailBulletin detailBulletin) {
        this.detailBulletin = detailBulletin;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public String toString() {
        return "Evaluation";
    }
}
