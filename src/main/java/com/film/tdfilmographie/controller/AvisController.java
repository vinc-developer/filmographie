package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.Avis;
import com.film.tdfilmographie.service.Impl.AvisImpl;
import com.film.tdfilmographie.service.Impl.FilmImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/private/avis")
public class AvisController {

    @Autowired
    AvisImpl avisService;

    @Autowired
    FilmImpl filmService;

    @GetMapping("/get-all/{id}")
    public String getAvisList(@PathVariable String id, Model model){
        model.addAttribute("allAvis", avisService.getAllAvis(Integer.parseInt(id)));
        model.addAttribute("film", filmService.getById(Integer.parseInt(id)));
        return "/avis/get-avis.html";
    }

    @GetMapping("/add-avis/{id}")
    public String getAddAvis(@PathVariable String id, Model model){
        model.addAttribute("avis", new Avis());
        model.addAttribute("id", Integer.parseInt(id));
        return "/avis/add-avis.html";
    }

    @PostMapping("/insert/{id}")
    public String addAvis(@PathVariable String id, @Valid Avis avis, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "/avis/add-avis.html";
        }
        avis.setDateAjout(LocalDate.now());
        avis.setIdFilm(Integer.parseInt(id));
        avisService.addAvis(avis);
        redirect.addFlashAttribute("message", "Ajout réussi");
        return "redirect:/private/avis/get-all/" + id;
    }

    @GetMapping("/delete-avis/{id}/{idFilm}")
    public String deleteAvis(@PathVariable String id, @PathVariable String idFilm, RedirectAttributes redirect){
        avisService.deleteAvis(Integer.parseInt(id));
        redirect.addFlashAttribute("message", "L'avis a bien été supprimé !");
        return "redirect:/private/avis/get-all/" + idFilm;
    }
}
