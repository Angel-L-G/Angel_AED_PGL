import React from 'react'
import UseDetallePelicula from '../hooks/UseDetallePelicula';
import PeliculaCard from './PeliculaCard';
import { GiArmorDowngrade } from "react-icons/gi";
import { GiArmorUpgrade } from "react-icons/gi";
import { useAppContext } from './AppContextProvider';
import UsePeliculaCard from '../hooks/UsePeliculaCard';
import ReactPlayer from 'react-player';

type Props = {}

function DetallePelicula(props: Props) {
    let { deletePeli, peli } = UseDetallePelicula();
    let {setPeliculaFavorito, favorito} = UsePeliculaCard();


    return (
        <div>
            <img src={"http://localhost:3000/"+peli.imagen}/>
            <h1>{peli.titulo}</h1><br />
            <p>{peli.direccion}</p><br />
            <p>{peli.actores}</p><br />
            <p>{peli.argumento}</p><br />
            <p>{peli.categoria}</p><br />
            <ReactPlayer
                url={peli.video}
                controls
                width="300px"
                height="300px"
            />

            <button onClick={deletePeli}>Borrar</button>
            <a href={'/editarPelicula/'+peli.id}>
                <button >Editar</button>
            </a>

            <button onClick={() => setPeliculaFavorito(peli)}>
                {
                    (favorito)
                    ?<GiArmorUpgrade style={{color: "white",backgroundColor: "rgb(34, 17, 185)", height: 75, width: 75}}/>
                    :<GiArmorDowngrade style={{color: "white",backgroundColor: "rgb(34, 17, 185)", height: 75, width: 75}}/>
                }
            </button>
            
        </div>
    )
}

export default DetallePelicula