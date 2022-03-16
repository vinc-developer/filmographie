package com.film.tdfilmographie.bo;

import java.time.LocalDate;

public class Avis {

    private int id;

    private int note;

    private String commentaire;

    private LocalDate dateAjout;

    private User user;

    public Avis() {
    }

    public Avis(int id, int note, String commentaire, LocalDate dateAjout, User user) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.dateAjout = dateAjout;
        this.user = user;
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
