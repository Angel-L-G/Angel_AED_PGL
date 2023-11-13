import React from 'react'
import UseFindAllPeli from '../hooks/UseFindAllPeli';
import PeliculaCard from './PeliculaCard';

type Props = {}

const MostrarTodo = (props: Props) => {
    const { peliculas, setPeliculas} = UseFindAllPeli();

    return (
        <div>MostrarTodo
            <br/>   
            <p>
            {
                peliculas.map(pelicula => (
                    <PeliculaCard peli={pelicula} />
                ))
            }
            </p>
        </div>
    )
}

export default MostrarTodo;