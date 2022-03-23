package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.repository.UserRepository;
import com.film.tdfilmographie.security.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionAuthentification implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private User current;

    /*private List<User> users = new ArrayList<>();
    public GestionAuthentification(PasswordEncoder passwordEncoder){
        User U1 = new User(1,"alex","terrieur", "alexterrieur", "alex@terrieur.com", passwordEncoder.encode("user1"), false);
        User U2 = new User(5,"alain", "terrieur", "alainterrieur", "alain@terrieur.com", passwordEncoder.encode("user2"), false);
        User U3 = new User(3, "marc", "assin", "marcassin", "marc@assin.com", passwordEncoder.encode("admin1"), true);
        User U4 = new User(4, "sarah", "croche", "sarahcroche", "sarah@croche.com", passwordEncoder.encode("user3"), false);
        User U5 = new User(2, "vinc", "dev", "vinc-dev", "vinc@dev.com", passwordEncoder.encode("admin2"), true);
        users.add(U1);
        users.add(U2);
        users.add(U3);
        users.add(U4);
        users.add(U5);
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userRepository.findAll();

       for(User user : userList){
           if(user.getEmail().equals(username)){
               current = user;
               return new Utilisateur(user);
           }
       }
       throw new UsernameNotFoundException(username);
    }

    public User getUser(){
        return current;
    }
}
