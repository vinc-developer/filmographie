package com.film.tdfilmographie.security;

import com.film.tdfilmographie.bo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Utilisateur implements UserDetails {

    private User user;
    List<GrantedAuthority> role = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(user.isAdmin()){
            role.add(new SimpleGrantedAuthority("ROLE_admin"));
            role.add(new SimpleGrantedAuthority("ROLE_user"));
        } else {
            role.add(new SimpleGrantedAuthority("ROLE_user"));
        }

        if(user.isDev()){
            role.add(new SimpleGrantedAuthority("ROLE_dev"));
        }

        return role;
    }

    public Utilisateur() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Utilisateur(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
