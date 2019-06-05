package com.company.Model.Class;

public class Enseignement {

    private int id;
    private Classe classe;
    private Discipline discipline;
    private Personne personne;

    public Enseignement(int id, Classe classe, Discipline discipline, Personne personne) {
        this.id = id;
        this.classe = classe;
        this.discipline = discipline;
        this.personne = personne;
    }

    public int getId() {
        return id;
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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Enseignement";
    }
}
