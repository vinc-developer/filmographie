package com.film.tdfilmographie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avis")
public class AvisController {

    @GetMapping
    public String getAvisList(Model model){
        return "/avis/add-avis.html";
    }
}
