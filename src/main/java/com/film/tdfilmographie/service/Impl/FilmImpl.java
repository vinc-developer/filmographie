package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.Film;

import java.util.List;

public interface FilmImpl {

    public List<Film> getAllFilm();

    public void ajoutFilm(Film film);
}
