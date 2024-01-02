import React, { useState } from 'react'
import UseDetallePelicula from '../hooks/UseDetallePelicula'
import { GiArmorDowngrade } from "react-icons/gi";
import { GiArmorUpgrade } from "react-icons/gi";
import { useAppContext } from './AppContextProvider';
import UsePeliculaCard from '../hooks/UsePeliculaCard';
import ReactPlayer from 'react-player';
import { Pelicula } from '../hooks/Types';

type Props = {
   peli: Pelicula,
   indiv?: number
}

const PeliculaCard = (props: Props) => {
    let {setPeliculaFavorito, favorito} = UsePeliculaCard();
    const rutaImagenes = "http://localhost:8080/api/v1/files/";
    return (
        <div>
            <a href={'/pelicula/'+props.peli.id}>
                <img src={rutaImagenes+props.peli.imagen}/>
                <h1>{props.peli.titulo}</h1><br />
                <p>{props.peli.direccion}</p><br />
                <p>{props.peli.actores}</p><br />
                <p>{props.peli.argumento}</p><br />
                {/*<p>{props.peli.categoria}</p><br />
                <ReactPlayer
                    url={props.peli.trailer}
                    controls
                    width="300px"
                    height="300px"
                />*/}
            </a>
            <button onClick={() => setPeliculaFavorito(props.peli)}>
                {
                    (favorito)
                    ?<GiArmorUpgrade style={{color: "white",backgroundColor: "rgb(34, 17, 185)", height: 75, width: 75}}/>
                    :<GiArmorDowngrade style={{color: "white",backgroundColor: "rgb(34, 17, 185)", height: 75, width: 75}}/>
                }
                </button>
        </div>
    )
}

export default PeliculaCard