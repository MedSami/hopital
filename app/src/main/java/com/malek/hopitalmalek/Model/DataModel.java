package com.malek.hopitalmalek.Model;

public class DataModel {
    String id,nom,prenom,cin,motDePasse,specialite;

    public DataModel(String id, String nom, String prenom, String cin, String motDePasse,String specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.motDePasse = motDePasse;
        this.specialite=specialite;
    }


    public String getId() {
        return id;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}
