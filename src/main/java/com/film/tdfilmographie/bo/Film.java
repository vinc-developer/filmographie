package com.film.tdfilmographie.bo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String titre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSortie;

    @NotNull
    private int duree;

    @NotNull
    @Column(columnDefinition = "text")
    private String synopsis;

    @NotNull
    private String urlImage;

    @NotNull
    private String urlVideo;

    @ManyToOne
    private Genre genre;

    @ManyToMany
    private List<CastActeur> castActeur;

    @ManyToOne
    private CastRealisateur castRealisateur;

    private LocalDate dateAjout = LocalDate.now();

    public Film() {
    }

    public Film(int id, String titre, LocalDate dateSortie, int duree, String synopsis, String urlImage, String urlVideo, Genre genre, List<CastActeur> castActeur, CastRealisateur castRealisateur, LocalDate dateAjout) {
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
        this.dateAjout = dateAjout;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
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

}
