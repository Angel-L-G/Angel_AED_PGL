import React from 'react'
import axios from 'axios';
import {useState, useEffect} from 'react';

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string
}

const UseFindAllPeli = () => {
    const ruta = "http://localhost:3000/peliculas";
    const [peliculas, setPeliculas] = useState<Array<Pelicula>>([]);

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                setPeliculas(response.data);
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);
    }, [])

    return {
        setPeliculas,
        peliculas
    };
}

export default UseFindAllPeli;