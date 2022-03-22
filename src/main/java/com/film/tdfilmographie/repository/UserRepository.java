package com.film.tdfilmographie.repository;

import com.film.tdfilmographie.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
