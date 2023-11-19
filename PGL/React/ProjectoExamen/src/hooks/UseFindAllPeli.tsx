import React from 'react'
import axios from 'axios';
import {useState, useEffect} from 'react';
import { ChangeEvent } from 'react';

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string,
    video: string,
    categoria: string
}

const UseFindAllPeli = () => {
    const ruta = "http://localhost:3000/peliculas";
    const [peliculas, setPeliculas] = useState<Array<Pelicula>>([]);
    const [peliculas2, setPeliculas2] = useState<Array<Pelicula>>([]);

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                setPeliculas(response.data);
                setPeliculas2(response.data);
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);      
    }, [])

    function filtrar(filtro: ChangeEvent<HTMLInputElement>) {

        const arrPeliculasFiltradas = peliculas2.filter(p => 
            p.titulo.toLowerCase().includes(filtro.target.value.toLowerCase())
        );

        setPeliculas([...arrPeliculasFiltradas]);
    }


    return {
        setPeliculas,
        peliculas,
        filtrar,
        peliculas2
    };
}

export default UseFindAllPeli;