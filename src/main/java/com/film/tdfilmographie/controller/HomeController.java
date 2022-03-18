package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.service.Impl.FilmImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getHome(Model model){
        model.addAttribute("user", null);
        model.addAttribute("films", filmService.getAllFilm());
        return "home.html";
    }
}
