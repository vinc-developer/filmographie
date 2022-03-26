package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.Genre;
import com.film.tdfilmographie.repository.GenreRepository;
import com.film.tdfilmographie.service.Impl.GenreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class GenreService implements GenreImpl {

    @Autowired
    private GenreRepository genreRepo;

    /*List<Genre> genres = new ArrayList<>();

    public GenreService(){
        Genre G1 = new Genre(1,"Horreur");
        Genre G2 = new Genre(2,"Science-Fiction");
        Genre G3 = new Genre(3,"Comedie");
        Genre G4 = new Genre(4,"Action");
        Genre G5 = new Genre(5, "Jeunesse");
        Genre g6 = new Genre(6, "Aventure");
        Genre G4 = new Genre(7,"Drame");
        Genre g6 = new Genre(8, "Documentaire");

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
        Genre genreBack = genreRepo.getById(id);
        if(genreBack != null){
           return genreBack;
        }
        return null;
    }

    @Override
    public void deleteGenre(int id) {
        Genre genreBack = genreRepo.getById(id);
        if(genreBack != null){
            genreRepo.deleteById(id);
        }
    }
}
