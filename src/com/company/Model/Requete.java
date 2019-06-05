package com.company.Model;

import com.company.Controller.Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Requete {
    public abstract String requeteAdd();
    public abstract int getId();
    public abstract String[] getEntetes();
    public abstract Object getValueAt(int number);
    public abstract ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException;
}
