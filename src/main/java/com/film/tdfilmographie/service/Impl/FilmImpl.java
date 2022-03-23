package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.Film;

import java.util.List;

public interface FilmImpl {

    public List<Film> getAllFilm();

    List<Film> getAllRecent();

    public void ajoutFilm(Film film);

    public Film getById(int id);

    public void deleteFilm(int id);

    Object listerFilmAvecTitre(String titre);
}
