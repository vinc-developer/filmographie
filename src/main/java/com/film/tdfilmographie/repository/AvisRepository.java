package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.Avis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvisRepository extends CrudRepository<Avis, Integer> {

    public List<Avis> getById(Integer id);
}
