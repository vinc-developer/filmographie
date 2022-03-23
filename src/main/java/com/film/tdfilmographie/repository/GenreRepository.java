package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    public List<Genre> findAll();
    public void deleteById(Integer id);
    public Genre getById(Integer id);

}
