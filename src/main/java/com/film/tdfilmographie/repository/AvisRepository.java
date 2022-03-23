package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.Avis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvisRepository extends CrudRepository<Avis, Integer> {

    public Avis getById(Integer id);
    public List<Avis> findAvisByFilmId(Integer id);
    public void deleteById(Integer id);
}
