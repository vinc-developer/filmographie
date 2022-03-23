package com.film.tdfilmographie.security.service.Impl;

import com.film.tdfilmographie.bo.CastRealisateur;

import java.util.List;

public interface CastRealisateurImpl {

    public List<CastRealisateur> getAllCast();

    public void ajoutCast(CastRealisateur cast);

    public CastRealisateur getCast(int id);

    public void deleteCastRealisateur(int id);
}
