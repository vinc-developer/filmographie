package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.security.Utilisateur;
import com.film.tdfilmographie.security.service.Impl.FilmImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private FilmImpl filmService;

    @GetMapping
    public String getHome(@AuthenticationPrincipal Utilisateur utilisateur, Model model){
        model.addAttribute("films", filmService.getAllFilm());
        return "home.html";
    }
}
