import React from 'react'
import axios from 'axios';
import {useState, useEffect} from 'react';
import { ChangeEvent } from 'react';
import { Pelicula } from './Types';

const UseFindAllPeli = () => {
    const ruta = "http://localhost:8080/api/v1/peliculas";
    const rutaImg = "http://localhost:8080/api/v1/files/";
    const [peliculas, setPeliculas] = useState<Array<Pelicula>>([]);
    const [peliculas2, setPeliculas2] = useState<Array<Pelicula>>([]);

    const axiosFindAll = async (ruta: string) => {
        try{
            const response = await axios.get(ruta);

            console.log(response.data);

            setPeliculas(response.data);
            setPeliculas2(response.data);
            //console.log(peliculas.data);

            /*for (let index = 0; index < peliculas.length; index++) {
                try{
                    const response = await axios.get(ruta+peliculas[index].imagen);
                    console.log(response.data);
                } catch (error){
                    console.log(error);
                }
            }*/
        } catch (error){
            console.log(error);
        }
    }

    function getAllPelis(){
        axiosFindAll(ruta);  
    }

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
        peliculas2,
        getAllPelis,
    };
}

export default UseFindAllPeli;