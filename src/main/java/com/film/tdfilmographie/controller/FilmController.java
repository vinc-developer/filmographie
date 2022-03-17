package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.Film;
import com.film.tdfilmographie.service.Impl.CastActeurImpl;
import com.film.tdfilmographie.service.Impl.CastRealisateurImpl;
import com.film.tdfilmographie.service.Impl.FilmImpl;
import com.film.tdfilmographie.service.Impl.GenreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmImpl filmService;

    @Autowired
    private GenreImpl genreService;

    @Autowired
    private CastActeurImpl castActeurService;

    @Autowired
    private CastRealisateurImpl castRealisateurService;

    @GetMapping
    public String getFilm(Model model){
        model.addAttribute("films", filmService.getAllFilm());
        return "/film/get-film.html";
    }

    @GetMapping("/formulaire-ajout-film")
    public String redirectAddFilm(Model model){
        model.addAttribute("film", new Film());
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("castsActeur", castActeurService.getAllCast());
        model.addAttribute("castsRealisateur", castRealisateurService.getAllCast());
        return "/film/add-film.html";
    }

    @GetMapping("/get-one/{id}")
    public String getById(@PathVariable String id, Model model){
        // get by id service
        model.addAttribute("film", filmService.getById(Integer.parseInt(id)));
        model.addAttribute("avgAvis", 3);
        return "/film/get-id-film.html";
    }

    @PostMapping()
    public String insertNewFilm(@Valid Film film, BindingResult bindingResult, RedirectAttributes redirect){
        /*if (bindingResult.hasErrors()) {
            return "redirect:/film";
        }*/

        filmService.ajoutFilm(film);
        redirect.addFlashAttribute("message", "Le film a bien été ajouté !");

        return "redirect:/film";
    }
}
