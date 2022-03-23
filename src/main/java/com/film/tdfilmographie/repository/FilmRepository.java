package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.Film;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Integer> {
    public List<Film> findAll();
    public void deleteById(Integer id);
    public Film getById(Integer id);
    public List<Film> findByTitreContaining(String titre);
    public List<Film> findAllByOrderByDateAjoutAsc();
}

