package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.Avis;

import java.util.List;

public interface AvisImpl {

    public void addAvis(Avis avis);

    public List<Avis> getAllAvis(int id);
}
