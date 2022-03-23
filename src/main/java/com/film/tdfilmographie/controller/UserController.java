package com.film.tdfilmographie.controller;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.service.Impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Objects;

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

    @GetMapping("/user/inscription")
    public String inscription(Model model){
        model.addAttribute("user", new User());
        return "/user/inscription.html";
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
    public String register(@RequestParam String confirmPassword, @Valid User user, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "/user/register.html";
        }
        if(!Objects.equals(confirmPassword, user.getPassword())){
            redirect.addFlashAttribute("message", "Une erreur c'est produite, merci de verifier les champs");
            return "redirect:/admin/user/register";
        }
        userService.addUser(user);
        redirect.addFlashAttribute("message", "Ajout réussi");
        return "redirect:/admin/user/get-all";
    }

    @PostMapping("/user/add-inscription")
    public String ajoutUtilisateur(@RequestParam String confirmPassword, @Valid User user, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()){
            return "redirect:/user/inscription";
        }
        if(!Objects.equals(confirmPassword, user.getPassword())){
            redirect.addFlashAttribute("message", "Une erreur c'est produite, merci de verifier les champs");
            return "redirect:/user/inscription";
        }
        user.setAdmin(false);
        userService.addUser(user);
        redirect.addFlashAttribute("message", "Inscription réussi");
        return "redirect:/login";
    }


    @PostMapping("/admin/delete-user")
    public String deleteUser(@RequestParam String id, RedirectAttributes redirect){
        userService.deleteUser(Integer.parseInt(id));
        redirect.addFlashAttribute("message", "Suppression réussi");
        return "redirect:/admin/user/get-all";
    }
}
