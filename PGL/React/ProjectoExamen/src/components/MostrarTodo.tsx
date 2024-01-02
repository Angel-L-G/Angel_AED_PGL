import React, { useEffect } from 'react'
import UseFindAllPeli from '../hooks/UseFindAllPeli';
import PeliculaCard from './PeliculaCard';
import { useAppContext } from './AppContextProvider';

type Props = {}

const MostrarTodo = (props: Props) => {
    const { peliculas, setPeliculas, filtrar, peliculas2, getAllPelis} = UseFindAllPeli();
    const { peliculasFavoritas, setPeliculasFavoritas } = useAppContext();
    
    console.log(peliculasFavoritas.length);

    useEffect(() => {
        getAllPelis();
    }, [])

    return (
        <div>
            <div>
                <input type="text" onChange={filtrar}/>
            </div>
            {
                (peliculasFavoritas.length > 0)
                ??<div>Peliculas Favoritas</div>
            }
            <br/><br/><br/>
            <div>
                {
                    peliculasFavoritas.map(pelicula => (
                        <PeliculaCard peli={pelicula} />
                    ))
                }
            </div>

            <br/>   
            <div>
            {
                peliculas.map(pelicula => (
                    <PeliculaCard peli={pelicula} />
                ))
            }
            </div>
        </div>
    )
}

export default MostrarTodo;