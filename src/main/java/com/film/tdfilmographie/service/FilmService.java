package com.film.tdfilmographie.service;

import com.film.tdfilmographie.bo.Avis;
import com.film.tdfilmographie.bo.Film;
import com.film.tdfilmographie.repository.AvisRepository;
import com.film.tdfilmographie.repository.FilmRepository;
import com.film.tdfilmographie.service.Impl.FilmImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class FilmService implements FilmImpl {

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    private FilmRepository filmRepository;

    /*List<Film> filmList = new ArrayList<>();

    public FilmService() {
        //Avatar
        List<CastActeur> castList1 = new ArrayList<>();

        CastActeur C1 = new CastActeur(1, "Sam", "Worthington");
        CastActeur C2 = new CastActeur(2, "Zoe", "Saldana");
        CastRealisateur CR1 = new CastRealisateur(1, "James", "Cameron");

        castList1.add(C1);
        castList1.add(C2);

        Genre G1 = new Genre(2, "Science-fiction");
        LocalDate dateSortie1 = LocalDate.of(2009, 12, 16);

        Film F1 = new Film(1, "Avatar", dateSortie1, 182, "Malgré sa paralysie, Jake Sully, un ancien marine immobilisé dans un fauteuil roulant, est resté un combattant au plus profond de son être. Il est recruté pour se rendre à des années-lumière de la Terre, sur Pandora, où de puissants groupes industriels exploitent un minerai rarissime destiné à résoudre la crise énergétique sur Terre. Parce que l'atmosphère de Pandora est toxique pour les humains, ceux-ci ont créé le Programme Avatar, qui permet à des \" pilotes \" humains de lier leur esprit à un avatar, un corps biologique commandé à distance, capable de survivre dans cette atmosphère létale. Ces avatars sont des hybrides créés génétiquement en croisant l'ADN humain avec celui des Na'vi, les autochtones de Pandora.\n" +
                "Sous sa forme d'avatar, Jake peut de nouveau marcher. On lui confie une mission d'infiltration auprès des Na'vi, devenus un obstacle trop conséquent à l'exploitation du précieux minerai. Mais tout va changer lorsque Neytiri, une très belle Na'vi, sauve la vie de Jake... ", "https://fr.web.img5.acsta.net/c_310_420/medias/nmedia/18/78/95/70/19485155.jpg", "https://www.youtube.com/embed/O1CzgULNRGs", G1, castList1, CR1);
        filmList.add(F1);

        //Fast & Furious 8
        List<CastActeur> castList2 = new ArrayList<>();

        CastActeur C3 = new CastActeur(3, "Vin", "Diesel");
        CastActeur C4 = new CastActeur(4, "Dwayne", "Johnsons");
        CastRealisateur CR2 = new CastRealisateur(2, "F.Gary", "Gray");

        castList2.add(C3);
        castList2.add(C4);

        Genre G2 = new Genre(4, "Action");
        LocalDate dateSortie2 = LocalDate.of(2017, 04, 12);

        Film F2 = new Film(2, "Fast & Furious 8", dateSortie2, 163, "Maintenant que Dom et Letty sont en lune de miel, que Brian et Mia se sont rangés et que le reste de l’équipe a été disculpé, la bande de globetrotteurs retrouve un semblant de vie normale. Mais quand une mystérieuse femme entraîne Dom dans le monde de la criminalité, ce dernier ne pourra éviter de trahir ses proches qui vont faire face à des épreuves qu’ils n’avaient jamais rencontrées jusqu’alors.\n" +
                "\n" +
                "Des rivages de Cuba au rues de New York en passant par les plaines gelées de la mer arctique de Barrents, notre équipe va sillonner le globe pour tenter d'empêcher une anarchiste de déchaîner un chaos mondial et de ramener à la maison l’homme qui a fait d’eux une famille. ", "https://fr.web.img6.acsta.net/c_310_420/pictures/17/03/03/17/27/305158.jpg", "https://www.youtube.com/embed/xFO-pKB13mw", G2, castList2, CR2);
        filmList.add(F2);

        // Babisitting
        List<CastActeur> castList3 = new ArrayList<>();

        CastActeur C5 = new CastActeur(5, "Philippe", "Lacheau");
        CastActeur C6 = new CastActeur(6, "Alice", "David");
        CastActeur C7 = new CastActeur(7, "Tarek", "Boudali");
        CastRealisateur CR3 = new CastRealisateur(3, "Philippe", "Lacheau");

        castList3.add(C5);
        castList3.add(C6);
        castList3.add(C7);

        Genre G3 = new Genre(3, "Comedie");
        LocalDate dateSortie3 = LocalDate.of(2014, 04, 16);

        Film F3 = new Film(3, "Babysitting", dateSortie3, 84, "Faute de baby-sitter pour le week-end, Marc Schaudel confie son fils Remy à Franck, son employé, \"un type sérieux\" selon lui. Sauf que Franck a 30 ans ce soir et que Rémy est un sale gosse capricieux. Au petit matin, Marc et sa femme Claire sont réveillés par un appel de la police. Rémy et Franck ont disparu ! Au milieu de leur maison saccagée, la police a retrouvé une caméra. Marc et Claire découvrent hallucinés les images tournées pendant la soirée.", "https://fr.web.img5.acsta.net/c_310_420/pictures/14/01/22/09/59/509268.jpg", "https://www.youtube.com/embed/30PQMw7TU6M", G3, castList3, CR3);
        filmList.add(F3);

        //Forrest gump
        List<CastActeur> castList4 = new ArrayList<>();

        CastActeur C8 = new CastActeur(8, "Tom", "Hanks");
        CastActeur C9 = new CastActeur(9, "Robin", "Wright");
        CastRealisateur CR4 = new CastRealisateur(4, "Robert", "Zemeckis");

        castList4.add(C8);
        castList4.add(C9);

        LocalDate dateSortie4 = LocalDate.of(1994, 10, 5);

        Film F4 = new Film(4, "Forrest Gump", dateSortie4, 160, "Quelques décennies d'histoire américaine, des années 1940 à la fin du XXème siècle, à travers le regard et l'étrange odyssée d'un homme simple et pur, Forrest Gump. ", "https://fr.web.img4.acsta.net/pictures/15/10/13/15/12/514297.jpg", "https://www.youtube.com/embed/GRe3ZsXAZE4", G3, castList4, CR4);
        filmList.add(F4);

        //Vaiana
        List<CastActeur> castList5 = new ArrayList<>();
        CastActeur C10 = new CastActeur(10, "Auli'i", "Cravlho");
        CastRealisateur CR5 = new CastRealisateur(5, "John", "Musker");
        Genre G5 = new Genre(5, "Jeunesse");

        castList5.add(C10);
        castList5.add(C4);

        LocalDate dateSortie5 = LocalDate.of(2016, 11, 16);

        Film F5 = new Film(5, "Vaiana", dateSortie5, 107, "Il y a 3 000 ans, les plus grands marins du monde voyagèrent dans le vaste océan Pacifique, à la découverte des innombrables îles de l'Océanie. Mais pendant le millénaire qui suivit, ils cessèrent de voyager. Et personne ne sait pourquoi...\n" +
                "Vaiana, la légende du bout du monde raconte l'aventure d'une jeune fille téméraire qui se lance dans un voyage audacieux pour accomplir la quête inachevée de ses ancêtres et sauver son peuple. Au cours de sa traversée du vaste océan, Vaiana va rencontrer Maui, un demi-dieu. Ensemble, ils vont accomplir un voyage épique riche d'action, de rencontres et d'épreuves... En accomplissant la quête inaboutie de ses ancêtres, Vaiana va découvrir la seule chose qu'elle a toujours cherchée : elle-même. ", "https://fr.web.img6.acsta.net/c_310_420/pictures/16/09/14/09/17/148002.jpg", "https://www.youtube.com/embed/JIl74jge_Wg", G5, castList5, CR5);
        filmList.add(F5);
    }*/

    @Override
    public List<Film> getAllFilm() {
        List<Film> filmList = filmRepository.findAll();
        if(filmList.size() == 0){
            return null;
        }
        return filmList;
    }

    @Override
    public List<Film> getAllRecent(){
        List<Film> filmList = filmRepository.findAllByOrderByDateAjoutAsc();
        if(filmList.size() == 0){
            return null;
        }
        return filmList;
    }

    @Override
    public void ajoutFilm(Film film) {
        filmRepository.save(film);
        //filmList.add(film);
    }

    @Override
    public Film getById(int id) {
        Film filmBack = filmRepository.getById(id);
        if(filmBack != null){
            return filmBack;
        }
        return null;
    }

    @Override
    public void deleteFilm(int id) {
        List<Avis> avisBack = avisRepository.findAvisByFilmId(id);
        for(Avis avis : avisBack){
            avisRepository.deleteById(avis.getId());
        }
        Film filmBack = filmRepository.getById(id);
        if(filmBack != null){
            filmRepository.deleteById(id);
        }
        //filmList.removeIf(film -> film.getId() == id);
    }

    @Override
    public Object listerFilmAvecTitre(String titre) {
        return filmRepository.findByTitreContaining(titre);
    }
}
