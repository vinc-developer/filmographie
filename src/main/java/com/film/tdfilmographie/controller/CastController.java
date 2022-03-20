package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.CastActeur;
import com.film.tdfilmographie.bo.CastRealisateur;
import com.film.tdfilmographie.service.Impl.CastActeurImpl;
import com.film.tdfilmographie.service.Impl.CastRealisateurImpl;
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
import java.util.List;

@Controller
@RequestMapping("/cast")
public class CastController {

    @Autowired
    private CastActeurImpl castService;

    @Autowired
    private CastRealisateurImpl castRealisateurService;

    @GetMapping
    public String getCast(Model model){
        model.addAttribute("casts", castService.getAllCast());
        model.addAttribute("castsRealisateur", castRealisateurService.getAllCast());
        return "/cast/get-cast.html";
    }

    @GetMapping("/formulaire-ajout-acteur")
    public String redirectAdd(Model model){
        model.addAttribute("cast", new CastActeur());
        return "/cast/add-cast.html";
    }

    @GetMapping("/formulaire-ajout-realisateur")
    public String redirectAddRealisateur(Model model){
        model.addAttribute("cast", new CastRealisateur());
        return "/cast/add-cast-realisateur.html";
    }

    @PostMapping("/add-acteur")
    public String addCast(@Valid CastActeur cast, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "/cast/add-cast.html";
        }

        castService.ajoutCast(cast);

        redirect.addFlashAttribute("message", "Ajout réussi");

        return "redirect:/cast";
    }

    @PostMapping("/add-realisateur")
    public String addCastRealisateur(@Valid CastRealisateur castRealisateur, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "/cast/add-cast-realisateur.html";
        }

        castRealisateurService.ajoutCast(castRealisateur);

        redirect.addFlashAttribute("message", "Ajout réussi");

        return "redirect:/cast";
    }

    @GetMapping("delete-cast-acteur/{id}")
        public String deleteCastActeur(@PathVariable String id, RedirectAttributes redirect){
             castService.deleteCastActeur(Integer.parseInt(id));
            redirect.addFlashAttribute("message", "L'acteur a bien été supprimé !");
            return "redirect:/cast";

        }

    @GetMapping("delete-cast-realisateur/{id}")
    public String deleteCastRealisateur(@PathVariable String id, RedirectAttributes redirect){
        castRealisateurService.deleteCastRealisateur(Integer.parseInt(id));
        redirect.addFlashAttribute("message", "L'acteur a bien été supprimé !");
        return "redirect:/cast";

    }
}
