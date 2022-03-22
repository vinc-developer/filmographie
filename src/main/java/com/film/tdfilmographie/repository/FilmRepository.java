package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
