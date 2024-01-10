import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import PeliculaCard from '../components/PeliculaCard';
import { Pelicula } from './Types';
import AppContextProvider, { useAppContext } from '../components/AppContextProvider';

const UseDetallePelicula = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const ruta = "http://localhost:8080/api/v1/peliculas/";
    const rutaV3 = "http://localhost:8080/api/v3/peliculas/";
    const [peli, setPeli] = useState<Pelicula>({} as Pelicula);
    const [token, setToken] = useState("");

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

        setToken(localStorage.getItem('token')??"");
    }, [])  
    
    async function deletePeli(){
        console.log(token);
        await axios.delete(rutaV3 + id, { headers: { "Authorization": "Bearer " + token }})
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