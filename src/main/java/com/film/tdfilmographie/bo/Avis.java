package com.film.tdfilmographie.bo;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Entity
public class Avis {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int note;

    @NotNull
    private String commentaire;

    private LocalDate dateAjout = LocalDate.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private Film film;


    public Avis() {
    }

    public Avis(int id, int note, String commentaire, LocalDate dateAjout, User user, Film film) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.dateAjout = dateAjout;
        this.user = user;
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
