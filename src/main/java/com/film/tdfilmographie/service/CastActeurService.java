package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.CastActeur;
import com.film.tdfilmographie.service.Impl.CastActeurImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class CastActeurService implements CastActeurImpl {

    List<CastActeur> castList = new ArrayList<>();

    public CastActeurService(){
        // Forest Gump
        CastActeur C1 = new CastActeur(1, "Tom", "Hanks");
        CastActeur C2 = new CastActeur(2, "Robin", "Wright");

        //Avatar
        CastActeur C3 = new CastActeur(3, "Sam", "Worthington");
        CastActeur C4 = new CastActeur(4, "Zoe", "Saldana");

        //Baby Sitting
        CastActeur C5 = new CastActeur(5, "Philippe", "Lacheau");
        CastActeur C6 = new CastActeur(6, "Alice", "David");
        CastActeur C7 = new CastActeur(7, "Tarek", "Boudali");

        //Fast and Furious
        CastActeur C8 = new CastActeur(8, "Vin", "Diesel");
        CastActeur C9 = new CastActeur(9, "Dwayne", "Johnsons");

        castList.add(C1);
        castList.add(C2);
        castList.add(C3);
        castList.add(C4);
        castList.add(C5);
        castList.add(C6);
        castList.add(C7);
        castList.add(C8);
        castList.add(C9);
    }

    @Override
    public List<CastActeur> getAllCast(){
        if(castList.size() == 0){
            return null;
        }
        return castList;

    }

    @Override
    public void ajoutCast(CastActeur cast) {
        this.castList.add(cast);
    }

    @Override
    public CastActeur getCast(int id) {
        for(CastActeur cast : castList) {
            if(cast.getId() == id){
                return cast;
            }
        }
        return null;
    }

}
