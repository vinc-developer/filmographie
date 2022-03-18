package com.film.tdfilmographie.service.Impl;

import com.film.tdfilmographie.bo.User;

public interface UserImpl {
    User getById();

    void addUser(User user);
}
