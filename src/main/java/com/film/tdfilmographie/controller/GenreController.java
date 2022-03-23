package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.Genre;
import com.film.tdfilmographie.security.service.Impl.GenreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/genre")
public class GenreController {

    @Autowired
    private GenreImpl genreService;

    @GetMapping
    public String getGenre(Model model) {
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("genres", genreList);
        return "/genre/get-genre.html";
    }

    @GetMapping("/formulaire-ajout-genre")
    public String redirectAddGenre(Model model){
        model.addAttribute("genre", new Genre());
        return "/genre/add-genre.html";
    }

    @PostMapping()
    public String insertFormulaireGenre(@Valid Genre genre, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "/genre/add-genre.html";
        }
        genreService.ajoutGenre(genre);
        redirect.addFlashAttribute("message", "Ajout réussi");
        return "redirect:/admin/genre";
    }

    @GetMapping("delete-genre/{id}")
    public String deleteGenre(@PathVariable String id, RedirectAttributes redirect){
        genreService.deleteGenre(Integer.parseInt(id));
        redirect.addFlashAttribute("message", "Le genre a bien été supprimé !");
        return "redirect:/admin/genre";
    }
}
