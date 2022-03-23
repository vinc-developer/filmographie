package com.film.tdfilmographie.converter;

import com.film.tdfilmographie.bo.CastActeur;
import com.film.tdfilmographie.service.Impl.CastActeurImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CastConverter implements Converter<String, CastActeur> {

    @Autowired
    CastActeurImpl castService;

    @Override
    public CastActeur convert(String idFormatText) {

        return castService.getCast(Integer.parseInt(idFormatText));
    }
}
