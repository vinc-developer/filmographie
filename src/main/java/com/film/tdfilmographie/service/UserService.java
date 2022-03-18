package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.User;
import com.film.tdfilmographie.service.Impl.UserImpl;
import org.springframework.stereotype.Service;

@Service()
public class UserService implements UserImpl {

    User userBack = new User(1, "Colas", "Vincent", "vinc-dev", "vinc@dev.com", "Test-123!", true);

    @Override
    public User getById(){
        return userBack;
    }

    @Override
    public void addUser(User user){
        userBack = user;
    }


}
