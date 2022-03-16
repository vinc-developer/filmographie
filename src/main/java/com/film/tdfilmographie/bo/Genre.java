package com.film.tdfilmographie.bo;

import javax.validation.constraints.NotEmpty;

public class Genre {

    private int id;

    @NotEmpty
    private String libelle;

    public Genre() {
    }

    public Genre(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
