package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.Avis;
import com.film.tdfilmographie.bo.Film;
import com.film.tdfilmographie.security.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping()
public class FilmController {

    @Autowired
    private FilmImpl filmService;

    @Autowired
    private GenreImpl genreService;

    @Autowired
    private CastActeurImpl castActeurService;

    @Autowired
    private CastRealisateurImpl castRealisateurService;

    @Autowired
    private AvisImpl avisService;

    @GetMapping("/admin/film/get-all")
    public String getFilm(Model model){
        model.addAttribute("films", filmService.getAllFilm());
        return "/film/get-film.html";
    }

    @GetMapping("/admin/film/formulaire-ajout-film")
    public String redirectAddFilm(Model model){
        model.addAttribute("film", new Film());
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("castsActeur", castActeurService.getAllCast());
        model.addAttribute("castsRealisateur", castRealisateurService.getAllCast());
        return "/film/add-film.html";
    }

    @GetMapping("/private/film/get-one/{id}")
    public String getById(@PathVariable String id, Model model){
        model.addAttribute("film", filmService.getById(Integer.parseInt(id)));
        int incr = 0;
        List<Avis> listAvis = avisService.getAllAvis(Integer.parseInt(id));
        if(listAvis != null){
            for(Avis a : listAvis){
                incr += a.getNote();
            }
            int avg = incr / listAvis.size();
            model.addAttribute("avgAvis", avg);
        } else{
            model.addAttribute("avgAvis", incr);
        }

        return "/film/get-id-film.html";
    }

    @PostMapping("/admin/film")
    public String insertNewFilm(@Valid Film film, BindingResult bindingResult, RedirectAttributes redirect){
        if (bindingResult.hasErrors()) {
            return "redirect:/film";
        }
        filmService.ajoutFilm(film);
        redirect.addFlashAttribute("message", "Le film a bien été ajouté !");
        return "redirect:/admin/film/get-all";
    }

    @GetMapping("/admin/film/delete-film/{id}")
    public String deleteFilm(@PathVariable String id, RedirectAttributes redirect){
        filmService.deleteFilm(Integer.parseInt(id));
        redirect.addFlashAttribute("message", "Le film a bien été supprimé !");
        return "redirect:/admin/film/get-all";
    }
}
