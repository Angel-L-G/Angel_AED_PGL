import React from 'react'
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

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

const UseUpdatePeli = () => {
    let { id } = useParams();
    const navigate = useNavigate();
    function updatePeli(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let idPeli = id ?? "";
        
        let titulo = form.titulo.value;
        let direccion = form.direccion.value;
        let actores = form.actores.value;
        let argumento = form.argumento.value;
        let imagen = form.imagen.value;
        let video = form.video.value;
        let categoria = form.categoria.value;

        let pelicula: Pelicula = {
            id: idPeli,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: imagen,
            video: video,
            categoria: categoria         
        };

        let ruta = "http://localhost:3000/peliculas/";

        const axiosput = async (ruta: string) => {
            try {
                const response = await axios.put(ruta+idPeli, pelicula)
                console.log(response.data);
                navigate("/");
            } catch (error) {
                console.log(error);
            }
        }

        axiosput(ruta);
    }

    return {
        updatePeli
    }
}

export default UseUpdatePeli