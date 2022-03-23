package com.film.tdfilmographie.converter;

import com.film.tdfilmographie.bo.CastRealisateur;
import com.film.tdfilmographie.security.service.Impl.CastRealisateurImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CastRealisateurConverteur implements Converter<String, CastRealisateur>{

    @Autowired
    CastRealisateurImpl castService;

    @Override
    public CastRealisateur convert(String idFormatText) {
        return castService.getCast(Integer.parseInt(idFormatText));
    }
}
