package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.Genre;
import com.film.tdfilmographie.repository.GenreRepository;
import com.film.tdfilmographie.service.Impl.GenreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class GenreService implements GenreImpl {

    @Autowired
    private GenreRepository genreRepo;

    /*List<Genre> genres = new ArrayList<>();

    public GenreService(){
        Genre G1 = new Genre(1,"Horreur");
        Genre G2 = new Genre(2,"Science-fiction");
        Genre G3 = new Genre(3,"Comedie");
        Genre G4 = new Genre(4,"Action");
        Genre G5 = new Genre(5, "Jeunesse");

        genres.add(G1);
        genres.add(G2);
        genres.add(G3);
        genres.add(G4);
        genres.add(G5);
    }*/

    @Override
    public void ajoutGenre(Genre genre) {
        genreRepo.save(genre);
        //this.genres.add(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genrelist = genreRepo.findAll();
        if(genrelist.size() == 0){
            return null;
        }
        return genrelist;
    }

    @Override
    public Genre getGenre(int id) {
        for(Genre genre : genreRepo.findAll()){
           if(genre.getId() == id){
               return genre;
           }
        }
        return null;
    }

    @Override
    public void deleteGenre(int id) {
        List<Genre> genrelist = genreRepo.findAll();
        for(Genre genre : genrelist){
            if(genre.getId() == id){
                genreRepo.deleteById(id);
            }
        }
    }
}
