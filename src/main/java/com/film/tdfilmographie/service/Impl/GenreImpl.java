package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.Genre;

import java.util.List;

public interface GenreImpl {

    public void ajoutGenre(Genre genre);

    public List<Genre> getAllGenres();

    public Genre getGenre(int id);
}
