import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import PeliculaCard from '../components/PeliculaCard';

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

const UseDetallePelicula = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const ruta = "http://localhost:3000/peliculas/";
    const [peli, setPeli] = useState<Pelicula>({} as Pelicula);

    useEffect(() => {
        async function getPeli(){
            let response = await axios.get(ruta+id);
            let aux= {
                id: response.data.id,
                actores: response.data.actores,
                categoria: response.data.categoria,
                argumento: response.data.argumento,
                direccion: response.data.direccion,
                imagen: response.data.imagen,
                titulo: response.data.titulo,
                video: response.data.video
            }

            setPeli(aux);
        }
        getPeli();
    }, [])  
    
    async function deletePeli(){
        axios.delete(ruta + id)
        .then(response => {
            console.log("Deleted post with ID ${id}");
            navigate("/");
        })
        .catch(error => {
            console.error(error);
        });
    }

    return {
        deletePeli,
        peli
    };
}

export default UseDetallePelicula