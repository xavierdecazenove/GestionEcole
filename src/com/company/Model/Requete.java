package com.company.Model;

import com.company.Controller.Connexion;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Requete {
    // Ajoute un élément dans la table spécifiées
    public abstract String requeteAdd();
    // Récupère l'idée de l'élément
    public abstract int getId();
    // Récupère l'entête de l'élément pour l'affichage dans le tableau
    public abstract String[] getEntetes();
    // Récupère les données de l'élément afin de l'afficher dans le tableau
    public abstract Object getValueAt(int number);
    // Recherche un élément fils de l'élément courant EXEMPLE : les niveaux que possède une école
    public abstract ArrayList<Requete> recherche(Connexion connexion) throws SQLException, ClassNotFoundException;
}
