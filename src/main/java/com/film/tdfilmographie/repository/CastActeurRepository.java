package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.CastActeur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CastActeurRepository extends CrudRepository<CastActeur, Integer> {
    public List<CastActeur> findAll();
    public void deleteById(Integer id);
    public CastActeur getById(Integer id);
}
