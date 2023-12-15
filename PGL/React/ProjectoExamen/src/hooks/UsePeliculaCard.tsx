import React, { useState } from 'react'
import { useAppContext } from '../components/AppContextProvider';
import { Pelicula } from './Types';

const UsePeliculaCard = () => {
    let { peliculasFavoritas, setPeliculasFavoritas } = useAppContext();
    const [favorito, setFavorito] = useState(false);

    function setPeliculaFavorito(peli: Pelicula){
        peliculasFavoritas.map(pelicula => {
            if(peli.id == pelicula.id){
                setFavorito(true);
            }
        });
        
        if(!favorito){
            setPeliculasFavoritas([...peliculasFavoritas, peli]);
            setFavorito(true);
        }else{
            let arrAux = peliculasFavoritas;
            arrAux = arrAux.filter((pelicula) => pelicula.titulo !== peli.titulo);
            setPeliculasFavoritas(arrAux);
            setFavorito(false);
        }    
    }

    return {
        setPeliculaFavorito,
        favorito
    }
}

export default UsePeliculaCard