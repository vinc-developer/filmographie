package com.film.tdfilmographie.security.service.Impl;

import com.film.tdfilmographie.bo.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserImpl {
    User getById(int id);

    List<User> getAllUser();

    void addUser(User user);

    void deleteUser(int id);
}
