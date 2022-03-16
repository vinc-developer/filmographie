package com.film.tdfilmographie.bo;

import javax.validation.constraints.NotEmpty;

public class CastRealisateur {

    private int id;

    @NotEmpty
    private String prenom;

    @NotEmpty
    private String nom;

    public CastRealisateur() {
    }

    public CastRealisateur(int id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
