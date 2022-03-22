package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.repository.UserRepository;
import com.film.tdfilmographie.service.Impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class UserService implements UserImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

   /* private List<User> users = new ArrayList<>();
    public UserService(PasswordEncoder passwordEncoder){
        User U1 = new User(1,"alex","terrieur", "alexterrieur", "alex@terrieur.com", passwordEncoder.encode("user1"), false);
        User U2 = new User(2,"alain", "terrieur", "alainterrieur", "alain@terrieur.com", passwordEncoder.encode("user2"), false);
        User U3 = new User(3, "marc", "assin", "marcassin", "marc@assin.com", passwordEncoder.encode("admin1"), true);
        User U4 = new User(4, "sarah", "croche", "sarahcroche", "sarah@croche.com", passwordEncoder.encode("user3"), false);
        User U5 = new User(5, "vinc", "dev", "vinc-dev", "vinc@dev.com", passwordEncoder.encode("admin2"), true);
        users.add(U1);
        users.add(U2);
        users.add(U3);
        users.add(U4);
        users.add(U5);
    }*/

    @Override
    public User getById(int id){
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUser(){
        List<User> userList = userRepository.findAll();
        if(userList.size() == 0){
            return null;
        }
        return userList;
    }

    @Override
    public void addUser(User user){
        User userEntity = new User();
        userEntity.setPrenom(user.getPrenom());
        userEntity.setNom(user.getNom());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setAdmin(user.isAdmin());
        userRepository.save(userEntity);
        //users.add(user);
    }

    @Override
    public void deleteUser(int id){
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            if(user.getId() == id){
                userRepository.deleteById(id);
            }
        }
        //users.removeIf(user -> user.getId() == id);
    }


}
