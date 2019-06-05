package com.company.Model.Class;

public class DetailBulletin {

    private int id;
    private Enseignement enseignement;
    private Bulletin bulletin;
    private String appreciation;

    public DetailBulletin(int id, Enseignement enseignement, Bulletin bulletin, String appreciation) {
        this.id = id;
        this.enseignement = enseignement;
        this.bulletin = bulletin;
        this.appreciation = appreciation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public String toString() {
        return "DetailBulletin";
    }
}
