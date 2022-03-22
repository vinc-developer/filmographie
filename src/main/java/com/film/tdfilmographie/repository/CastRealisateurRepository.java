package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.CastRealisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CastRealisateurRepository extends CrudRepository<CastRealisateur, Integer> {
    public List<CastRealisateur> findAll();
    public void deleteById(Integer id);
    public CastRealisateur getById(Integer id);
}
