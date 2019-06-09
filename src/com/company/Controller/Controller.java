package com.company.Controller;

import com.company.Model.Class.*;

import java.sql.SQLException;
import java.util.ArrayList;


/// Classe permmettant l'affichage des données de chacunes des catégories dans le tableau
public class Controller {

    private Connexion connexion;

    public Controller(Connexion connexion){
        this.connexion = connexion;
    }

    public ArrayList<Ecole> ecolesBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Ecole","Ecole");
    }
    public ArrayList<Niveau> niveauxBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Niveau","Niveau");
    }
    public ArrayList<Classe> classesBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Classe,Ecole,AnneeScolaire,Niveau WHERE Ecole.Id = Classe.IdEcole AND AnneeScolaire.Id = Classe.IdAnneeScolaire AND Niveau.Id = Classe.IdNiveau","Classe");
    }
    public ArrayList<Inscription> inscriptionsBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Inscription,Classe,Personne WHERE Classe.Id = Inscription.IdClasse AND Personne.Id = Inscription.IdPersonne","Inscription");
    }
    public ArrayList<Personne> personnesBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Personne","Personne");
    }
    public ArrayList<Trimestre> trimestresBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Trimestre","Trimestre");
    }
    public ArrayList<Bulletin> bulletinsBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Bulletin,Trimestre,Inscription WHERE Trimestre.Id = Bulletin.IdTrimestre AND Inscription.Id = Bulletin.IdInscription","Bulletin");
    }
    public ArrayList<Evaluation> evaluationsBDD() throws SQLException {
        return this.connexion.remplirChampsGlobal("SELECT * FROM Evaluation,DetailBulletin WHERE DetailBulletin.Id = Evaluation.IdDetailBulletin","Evaluation");
    }
}
