package com.film.tdfilmographie.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class Film {

    private int id;

    private String titre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSortie;

    private int duree;

    private String synopsis;

    private String urlImage;

    private String urlVideo;

    private Genre genre;

    private List<CastActeur> castActeur;

    private CastRealisateur castRealisateur;

    private List<Avis> avisList;

    public Film() {
    }

    public Film(int id, String titre, LocalDate dateSortie, int duree, String synopsis, String urlImage, String urlVideo, Genre genre, List<CastActeur> castActeur, CastRealisateur castRealisateur, List<Avis> avisList) {
        this.id = id;
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.duree = duree;
        this.synopsis = synopsis;
        this.urlImage = urlImage;
        this.urlVideo = urlVideo;
        this.genre = genre;
        this.castActeur = castActeur;
        this.castRealisateur = castRealisateur;
        this.avisList = avisList;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<CastActeur> getCastActeur() {
        return castActeur;
    }

    public void setCastActeur(List<CastActeur> castActeur) {
        this.castActeur = castActeur;
    }

    public CastRealisateur getCastRealisateur() {
        return castRealisateur;
    }

    public void setCastRealisateur(CastRealisateur castRealisateur) {
        this.castRealisateur = castRealisateur;
    }

    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }
}
