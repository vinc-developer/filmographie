package com.film.tdfilmographie.service;


import com.film.tdfilmographie.bo.Avis;
import com.film.tdfilmographie.service.Impl.AvisImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service()
public class AvisService implements AvisImpl {

    List<Avis> avisList = new ArrayList<>();

    public AvisService(){
        LocalDate D1 = LocalDate.of(2009, 12, 16);
        Avis A1 = new Avis(1, 2, "bon filme", D1 , null);
        LocalDate D2 = LocalDate.of(2019, 3, 26);
        Avis A2 = new Avis(2, 3, "vivement le prochain", D2, null);
        LocalDate D3 = LocalDate.of(2022, 5, 1);
        Avis A3 = new Avis(3, 1, "null, les acteurs joue très mal", D3, null);
        LocalDate D4 = LocalDate.of(2017, 6, 10);
        Avis A4 = new Avis(4, 5, "film exeptionnelle", D4, null);
        LocalDate D5 = LocalDate.of(2015, 8, 21);
        Avis A5 = new Avis(5, 3, "j'ai pleurer a la fin", D5, null);
        LocalDate D6 = LocalDate.of(2018, 1, 31);
        Avis A6 = new Avis(6, 2, "très décu de la fin", D6, null);
        LocalDate D8 = LocalDate.of(2020, 4, 19);
        Avis A7 = new Avis(7, 4, "Un film génial a voir et revoir", D8, null);
        LocalDate D9 = LocalDate.of(2016, 11, 17);
        Avis A8 = new Avis(8, 1, "Ma plus grosse déception", D9, null);

        avisList.add(A1);
        avisList.add(A2);
        avisList.add(A3);
        avisList.add(A4);
        avisList.add(A5);
        avisList.add(A6);
        avisList.add(A7);
        avisList.add(A8);
    }

    @Override
    public List<Avis> getAll(int id) {
        System.out.println(id);
        if(avisList.size() == 0){
            return null;
        }
        return avisList;
    }

    @Override
    public void addAvis(Avis avis) {
        this.avisList.add(avis);
    }

    @Override
    public Avis getAllAvis(int id) {
        for(Avis avis : avisList){
            if(avis.getId() == id){
                return avis;
            }
        }
        return null;
    }
}
