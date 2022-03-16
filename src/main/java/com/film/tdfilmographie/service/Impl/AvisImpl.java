package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.Avis;

import java.util.List;

public interface AvisImpl {

    public List<Avis> getAllAvis();

    public void addAvis(Avis avis);

    public Avis getAllAvis(int id);
}
