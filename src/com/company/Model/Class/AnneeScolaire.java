package com.company.Model.Class;

import com.company.Controller.Connexion;
import com.company.Model.Requete;

import java.util.ArrayList;

public class AnneeScolaire extends Requete {

    private int id;

    public AnneeScolaire(){
        this.id = 0;
    }

    public AnneeScolaire(int id) {
        this.id = id;
    }

    @Override
    public String requeteAdd() {
        return null;
    }

    public int getId() {
        return id;
    }

    @Override
    public String[] getEntetes() {
        return new String[0];
    }

    @Override
    public Object getValueAt(int number) {
        if (number == 0) return this.id;
        else return null;
    }

    @Override
    public ArrayList<Requete> recherche(Connexion connexion) {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnneeScolaire";
    }
}

