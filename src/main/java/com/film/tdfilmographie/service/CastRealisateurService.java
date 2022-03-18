package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.CastRealisateur;
import com.film.tdfilmographie.service.Impl.CastRealisateurImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class CastRealisateurService implements CastRealisateurImpl {

    List<CastRealisateur> castListR = new ArrayList<>();

    public CastRealisateurService(){
        // Forest Gump
        CastRealisateur C1 = new CastRealisateur(1, "Robert", "Zemeckis");
        //Avatar
        CastRealisateur C2 = new CastRealisateur(2, "James", "Cameron");
        //Baby Sitting
        CastRealisateur C3 = new CastRealisateur(3, "Philippe", "Lacheau");
        //Fast and Furious
        CastRealisateur C4 = new CastRealisateur(4, "F.Gary", "Gray");

        castListR.add(C1);
        castListR.add(C2);
        castListR.add(C3);
        castListR.add(C4);
    }

    @Override
    public List<CastRealisateur> getAllCast() {
        if(castListR.size() == 0){
            return null;
        }
        return castListR;
    }

    @Override
    public void ajoutCast(CastRealisateur cast) {
        this.castListR.add(cast);
    }

    @Override
    public CastRealisateur getCast(int id) {
        for(CastRealisateur cast : castListR) {
            if(cast.getId() == id){
                return cast;
            }
        }
        return null;
    }

    @Override
    public void deleteCastRealisateur(int id) {

    }
}
