import React from 'react';
import axios from 'axios';

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string,
    video?: string,
    categoria?: string
}

const UseCreatePeli = () => {
    function createPeli(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let id = form.idpeli.value;
        let titulo = form.titulo.value;
        let direccion = form.direccion.value;
        let actores = form.actores.value;
        let argumento = form.argumento.value;
        let imagen = form.imagen.value;
        let video = form.video.value;
        let categoria = form.categoria.value;

        //console.log(id, titulo, direccion, actores, argumento, imagen, video);

        const pelicula: Pelicula = {
            id: id,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: imagen,
            categoria: categoria   
        };

        console.log(pelicula);

        let ruta = "http://localhost:3000/peliculas";

        console.log(ruta);

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, pelicula);
                console.log(response.data);
                //navigate("/mostrarPeliculas");
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
        //ECONNABORTED
    }

    return {
        createPeli
    }   
}

export default UseCreatePeli