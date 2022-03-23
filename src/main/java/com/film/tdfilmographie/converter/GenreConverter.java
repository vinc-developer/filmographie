package com.film.tdfilmographie.converter;

import com.film.tdfilmographie.bo.Genre;
import com.film.tdfilmographie.security.service.Impl.GenreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter implements Converter<String, Genre>{

    @Autowired
    GenreImpl genreService;

    @Override
    public Genre convert(String idFormatText) {
        return genreService.getGenre(Integer.parseInt(idFormatText));
    }
}
