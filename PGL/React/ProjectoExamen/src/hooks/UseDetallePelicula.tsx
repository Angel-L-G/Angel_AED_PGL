import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import PeliculaCard from '../components/PeliculaCard';
import { Pelicula } from './Types';

const UseDetallePelicula = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const ruta = "http://localhost:8080/api/v1/peliculas/";
    const [peli, setPeli] = useState<Pelicula>({} as Pelicula);

    useEffect(() => {
        async function getPeli(){
            let response = await axios.get(ruta+id);
            let aux= {
                id: response.data.id,
                actores: response.data.actores,
                categorias: response.data.categoria,
                argumento: response.data.argumento,
                direccion: response.data.direccion,
                imagen: response.data.imagen,
                titulo: response.data.titulo,
                trailer: response.data.trailer
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