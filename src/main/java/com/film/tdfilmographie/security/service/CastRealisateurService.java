package com.film.tdfilmographie.security.service;

import com.film.tdfilmographie.bo.CastRealisateur;
import com.film.tdfilmographie.repository.CastRealisateurRepository;
import com.film.tdfilmographie.security.service.Impl.CastRealisateurImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class CastRealisateurService implements CastRealisateurImpl {

    @Autowired
    private CastRealisateurRepository castRealisateurRepository;

    /*List<CastRealisateur> castListR = new ArrayList<>();

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
    }*/

    @Override
    public List<CastRealisateur> getAllCast() {
        List<CastRealisateur> castListR = castRealisateurRepository.findAll();
        if(castListR.size() == 0){
            return null;
        }
        return castListR;
    }

    @Override
    public void ajoutCast(CastRealisateur cast) {
        castRealisateurRepository.save(cast);
        // this.castListR.add(cast);
    }

    @Override
    public CastRealisateur getCast(int id) {
        CastRealisateur cast = castRealisateurRepository.getById(id);
        if(cast != null){
            return cast;
        }
        return null;
    }

    @Override
    public void deleteCastRealisateur(int id) {
        CastRealisateur cast = castRealisateurRepository.getById(id);
        if(cast != null){
            castRealisateurRepository.deleteById(id);
        }
        //castListR.removeIf(cast -> cast.getId() == id);
    }
}
