const docGenre = document.getElementById('docGenre');
const btnGenre = document.getElementById('btn-genre-doc');

const docActeur = document.getElementById('docActor');
const btnActeur = document.getElementById('btn-actor-doc');

const docRealisateur = document.getElementById('docProducer');
const btnRealisateur = document.getElementById('btn-producer-doc');

const docFilm = document.getElementById('docFilm');
const btnFilm = document.getElementById('btn-film-doc');

const docAvis = document.getElementById('docAvis');
const btnAvis = document.getElementById('btn-avis-doc');

btnGenre.onclick = () =>{
    if(docGenre.style.display === 'none'){
        docGenre.style.display = "block"
    }else{
        docGenre.style.display = 'none'
    }
}

btnActeur.onclick = () =>{
    if(docActeur.style.display === 'none'){
        docActeur.style.display = "block"
    }else{
        docActeur.style.display = 'none'
    }
}

btnRealisateur.onclick = () =>{
    if(docRealisateur.style.display === 'none'){
        docRealisateur.style.display = "block"
    }else{
        docRealisateur.style.display = 'none'
    }
}

btnFilm.onclick = () =>{
    if(docFilm.style.display === 'none'){
        docFilm.style.display = "block"
    }else{
        docFilm.style.display = 'none'
    }
}

btnAvis.onclick = () =>{
    if(docAvis.style.display === 'none'){
        docAvis.style.display = "block"
    }else{
        docAvis.style.display = 'none'
    }
}
