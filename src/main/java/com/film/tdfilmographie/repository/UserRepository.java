package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findAll();
    public void deleteById(Integer id);
    public User getById(Integer id);
}
