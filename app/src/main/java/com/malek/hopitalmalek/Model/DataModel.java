package com.malek.hopitalmalek.Model;

public class DataModel {
    String id,nom,prenom,cin,motDePasse,specialite,message,choix,date;

    public DataModel(String id, String nom, String prenom,
                     String cin,String message,String choix,String date,
                     String motDePasse,String specialite) {
        this.id = id;
        this.nom = nom;
        this.message=message;
        this.choix=choix;
        this.date=date;
        this.prenom = prenom;
        this.cin = cin;
        this.motDePasse = motDePasse;
        this.specialite=specialite;
    }

    public String getMessage() {
        return message;
    }

    public String getChoix() {
        return choix;
    }

    public String getDate() {
        return date;
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
