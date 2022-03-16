package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.CastRealisateur;

import java.util.List;

public interface CastRealisateurImpl {

    public List<CastRealisateur> getAllCast();

    public void ajoutCast(CastRealisateur cast);

    public CastRealisateur getCast(int id);
}
