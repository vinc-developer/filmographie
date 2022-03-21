package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.service.Impl.UserImpl;
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
@RequestMapping()
public class UserController {

    @Autowired
    UserImpl userService;

    @GetMapping("/admin/user/register")
    public String getRegisterUser(Model model){
        model.addAttribute("user", new User());
        return "/user/register.html";
    }

    @GetMapping("/admin/user/get-all")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "/user/get-all-user.html";
    }

    @GetMapping("/private/user/get-id/{id}")
    public String getByIdUser(@PathVariable String id, Model model){
        model.addAttribute("user", userService.getById(Integer.parseInt(id)));
        return "/user/get-user.html";
    }

    @GetMapping("/login")
    public String getLoginUser(Model model){
        return "/user/login.html";
    }

    @PostMapping("/admin/user/add-register")
    public String register(@Valid User user, BindingResult binding){
        if(binding.hasErrors()){
            return "/user/register.html";
        }
        userService.addUser(user);
        return "redirect:/admin/user/get-all";
    }
}
