package com.company.Controller;

import com.company.Model.Class.*;

import java.sql.*;

import java.util.ArrayList;

public class Connexion {

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rset;
    private static ResultSetMetaData rsetMeta;

    public Connexion(){
        // Constructeur par défault
    }

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void connexionBDD(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;

        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsRequete(String requete, String table) throws SQLException, ClassNotFoundException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        ArrayList liste;
        liste = new ArrayList<>();

        switch (table){
            case "ING":
                ArrayList<Integer> listIng = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    listIng.add(id);
                }
                return listIng;
            case "NomNiveau":
                ArrayList<String> listNomNiveau = new ArrayList<>();
                while (rset.next()) {
                    String nom = rset.getString(1);
                    listNomNiveau.add(nom);
                }
                return listNomNiveau;
            case "Personne" :
                ArrayList<Personne> listPersonne = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    String prenom = rset.getString(3);
                    String type = rset.getString(4);
                    listPersonne.add(new Personne(id,nom,prenom,type));
                }
                return listPersonne;
            case "AnneeScolaire" :
                ArrayList<AnneeScolaire> listAnneeScolaire = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    listAnneeScolaire.add(new AnneeScolaire(id));
                }
                return listAnneeScolaire;
            case "Bulletin" :
                ArrayList<Bulletin> listBulletin = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idTrimestre = rset.getInt(2);
                    int idInscription= rset.getInt(3);
                    String appreciation = rset.getString(4);
                    int idAnneeScolaire = rset.getInt(6);
                    int numero = rset.getInt(7);
                    Date dateDebut = rset.getDate(8);
                    Date dateFin = rset.getDate(9);
                    listBulletin.add(new Bulletin(id,new Trimestre(idTrimestre,new AnneeScolaire(idAnneeScolaire),numero,dateDebut,dateFin),new Inscription(idInscription,null,null),appreciation));
                }
                return listBulletin;
            case "Classe" :
                ArrayList<Classe> listClasse = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idEcole = rset.getInt(2);
                    int idAnneeSclolaire = rset.getInt(3);
                    int idNiveau = rset.getInt(4);
                    String nom = rset.getString(5);
                    String nomEcole = rset.getString(6);
                    String nomNiveau = rset.getString(7);

                    listClasse.add(new Classe(id,new Ecole(idEcole,nomEcole),new AnneeScolaire(idAnneeSclolaire),new Niveau(idNiveau,nomNiveau),nom));
                }
                return listClasse;
            case "Classe2" :
                ArrayList<Classe> listClasse2 = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idEcole = rset.getInt(2);
                    int idAnneeSclolaire = rset.getInt(3);
                    int idNiveau = rset.getInt(4);
                    String nom = rset.getString(5);

                    listClasse2.add(new Classe(id,new Ecole(idEcole,""),new AnneeScolaire(idAnneeSclolaire),new Niveau(idNiveau,""),nom));
                }
                return listClasse2;
            case "DetailBulletin" :
                ArrayList<DetailBulletin> listDetailBulletin = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idEnseignement = rset.getInt(2);
                    int idBulletin = rset.getInt(3);
                    String appreciation = rset.getString(4);
                    listDetailBulletin.add(new DetailBulletin(id,new Enseignement(idEnseignement,null,null,null),new Bulletin(idBulletin,null,null,appreciation),appreciation));
                }
                return listDetailBulletin;
            case "Discipline" :
                ArrayList<Discipline> listDiscipline = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listDiscipline.add(new Discipline(id,nom));
                }
                return listDiscipline;
            case "Ecole" :
                ArrayList<Ecole> listEcole = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listEcole.add(new Ecole(id,nom));
                }
                return listEcole;
            case "Enseignement" :
                break;
            case "Evaluation" :
                ArrayList<Evaluation> listEvaluation = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idDetailBulletin = rset.getInt(2);
                    int note = rset.getInt(3);
                    String appreciation = rset.getString(4);
                    listEvaluation.add(new Evaluation(id,new DetailBulletin(idDetailBulletin,null,null,appreciation),note,appreciation));
                }
                return listEvaluation;
            case "Inscription" :
                ArrayList<Inscription> listInscription = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idClasse = rset.getInt(2);
                    int idPersonne = rset.getInt(3);
                    String nomClasse = rset.getString(4);
                    String nom = rset.getString(5);
                    String prenom = rset.getString(6);
                    String type = rset.getString(7);

                    listInscription.add(new Inscription(id,new Classe(idClasse,null,null,null,nomClasse),new Personne(idPersonne,nom,prenom,type)));
                }
                return listInscription;
            case "Niveau" :
                ArrayList<Niveau> listNiveau = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listNiveau.add(new Niveau(id,nom));
                }
                return listNiveau;
            case "Trimestre" :
                break;
            default:
                return liste;
        }
        return liste;
    }


/// requete pour aller chercher les données nécessaires à afficher le tableau de chaque catégories
    public ArrayList remplirChampsGlobal(String requete, String table) throws SQLException {

        rset = stmt.executeQuery(requete);
        rsetMeta = rset.getMetaData();

        ArrayList liste;
        liste = new ArrayList<>();

        switch (table){
            case "Personne" :
                ArrayList<Personne> listPersonne = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    String prenom = rset.getString(3);
                    String type = rset.getString(4);
                    listPersonne.add(new Personne(id,nom,prenom,type));
                }
                return listPersonne;
            case "AnneeScolaire" :
                ArrayList<AnneeScolaire> listAnneeScolaire = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    listAnneeScolaire.add(new AnneeScolaire(id));
                }
                return listAnneeScolaire;
            case "Bulletin" :
                ArrayList<Bulletin> listBulletin = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idTrimestre = rset.getInt(2);
                    int idInscription= rset.getInt(3);
                    String appreciation = rset.getString(4);
                    int idAnneeScolaire = rset.getInt(6);
                    int numero = rset.getInt(7);
                    Date dateDebut = rset.getDate(8);
                    Date dateFin = rset.getDate(9);
                    listBulletin.add(new Bulletin(id,new Trimestre(idTrimestre,new AnneeScolaire(idAnneeScolaire),numero,dateDebut,dateFin),new Inscription(idInscription,null,null),appreciation));
                }
                return listBulletin;
            case "Classe" :
                ArrayList<Classe> listClasse = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idEcole = rset.getInt(2);
                    int idAnneeSclolaire = rset.getInt(3);
                    int idNiveau = rset.getInt(4);
                    String nom = rset.getString(5);
                    String nomEcole = rset.getString(7);
                    String nomNiveau = rset.getString(10);

                    listClasse.add(new Classe(id,new Ecole(idEcole,nomEcole),new AnneeScolaire(idAnneeSclolaire),new Niveau(idNiveau,nomNiveau),nom));
                }
                return listClasse;
            case "DetailBulletin" :
                ArrayList<DetailBulletin> listDetailBulletin = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idEnseignement = rset.getInt(2);
                    int idBulletin = rset.getInt(3);
                    String appreciation = rset.getString(4);
                    listDetailBulletin.add(new DetailBulletin(id,new Enseignement(idEnseignement,null,null,null),new Bulletin(idBulletin,null,null,appreciation),appreciation));
                }
                return listDetailBulletin;
            case "Discipline" :
                ArrayList<Discipline> listDiscipline = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listDiscipline.add(new Discipline(id,nom));
                }
                return listDiscipline;
            case "Ecole" :
                ArrayList<Ecole> listEcole = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listEcole.add(new Ecole(id,nom));
                }
                return listEcole;
            case "Enseignement" :
                ArrayList<Enseignement> listEnseignement = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idClasse = rset.getInt(2);
                    int idDiscipline = rset.getInt(3);
                    int idPersonne = rset.getInt(4);
                    int idAnneeScolaire = rset.getInt(7);
                    String nomClasse = rset.getString(9);
                    String nomDiscipline = rset.getString(11);
                    String nom = rset.getString(13);
                    String prenom = rset.getString(14);
                    String type = rset.getString(15);
                    listEnseignement .add(new Enseignement(id,new Classe(idClasse,null,new AnneeScolaire(idAnneeScolaire),null,nomClasse),new Discipline(idDiscipline,nomDiscipline),new Personne(idPersonne,nom,prenom,type)));
                }
                return listEnseignement;
            case "Evaluation" :
                ArrayList<Evaluation> listEvaluation = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idDetailBulletin = rset.getInt(2);
                    int note = rset.getInt(3);
                    String appreciation = rset.getString(4);
                    listEvaluation.add(new Evaluation(id,new DetailBulletin(idDetailBulletin,null,null,appreciation),note,appreciation));
                }
                return listEvaluation;
            case "Inscription" :
                ArrayList<Inscription> listInscription = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idClasse = rset.getInt(2);
                    int idPersonne = rset.getInt(3);
                    String nomClasse = rset.getString(8);
                    String nom = rset.getString(10);
                    String prenom = rset.getString(11);
                    String type = rset.getString(12);

                    listInscription.add(new Inscription(id,new Classe(idClasse,null,null,null,nomClasse),new Personne(idPersonne,nom,prenom,type)));
                }
                return listInscription;
            case "Niveau" :
                ArrayList<Niveau> listNiveau = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    String nom = rset.getString(2);
                    listNiveau.add(new Niveau(id,nom));
                }
                return listNiveau;
            case "Trimestre" :
                ArrayList<Trimestre> listTrimestre = new ArrayList<>();
                while (rset.next()) {
                    int id = rset.getInt(1);
                    int idAnneeScolaire = rset.getInt(2);
                    int numero = rset.getInt(3);
                    Date debut = rset.getDate(4);
                    Date fin = rset.getDate(5);
                    listTrimestre.add(new Trimestre(id,new AnneeScolaire(idAnneeScolaire),numero,debut,fin));
                }
                return listTrimestre;
            default:
                return liste;
        }
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }

}