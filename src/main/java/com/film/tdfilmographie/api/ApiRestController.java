package com.film.tdfilmographie.api;

import com.film.tdfilmographie.bo.*;
import com.film.tdfilmographie.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private GenreImpl genreService;

    @Autowired
    private CastActeurImpl castActeurService;

    @Autowired
    private CastRealisateurImpl castRealisateurService;

    @Autowired
    private FilmImpl filmService;

    @Autowired
    AvisImpl avisService;

    @GetMapping("/get-all-genre")
    public List<Genre> getAllGenre() {
        return genreService.getAllGenres();
    }

    @GetMapping("/get-all-cast-actor")
    public List<CastActeur> getAllCastActor(){
        return castActeurService.getAllCast();
    }

    @GetMapping("/get-all-cast-producer")
    public List<CastRealisateur> getAllCastProducer() {
        return castRealisateurService.getAllCast();
    }

    @GetMapping("/get-all-film")
    public List<Film> getAllFilm() {
        return filmService.getAllFilm();
    }

    @GetMapping("/get-all-avis-by-film/{id}")
    public List<Avis> getAllAvisByFilm(@PathVariable int id){
        return avisService.getAllAvis(id);
    }
}
