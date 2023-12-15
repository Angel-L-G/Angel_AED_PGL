import React from 'react'
import UseFindAllPeli from '../hooks/UseFindAllPeli'
import PeliculaCard from './PeliculaCard';
import {useEffect} from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { Pelicula } from '../hooks/Types';

type Props = {}

const CategoryFiltered = (props: Props) => {
    let {peliculas,setPeliculas} = UseFindAllPeli();
    const ruta = "http://localhost:8080/api/v1/categorias";

    let {nombre} = useParams();
    let nombreCategory = nombre ?? "";

    useEffect(() => {
        const getPelicula = async () => {
            let response = await axios.get(ruta);

            let arrPeliculas = response.data;
            let arrTypePeliculas: Array<Pelicula> = [];

            for (let i = 0; i < arrPeliculas.length; i++) {
                if (arrPeliculas[i].categoria == nombreCategory) {
                    arrTypePeliculas[i] = arrPeliculas[i];
                }
            }

            setPeliculas(arrTypePeliculas);
        }

        getPelicula();
    }, []);


    return (
        <div>
            {
                peliculas.map(pelicula => (
                    <PeliculaCard peli={pelicula} />
                ))
            }
        </div>
    )
}

export default CategoryFiltered