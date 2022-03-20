package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.CastActeur;

import java.util.List;

public interface CastActeurImpl {

    public List<CastActeur> getAllCast();

    public void ajoutCast(CastActeur cast);

    public CastActeur getCast(int id);

    public void deleteCastActeur(int id);
}
