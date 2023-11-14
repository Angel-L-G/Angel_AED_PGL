import React from 'react';
import axios from 'axios';

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

const UseCreatePeli = () => {
    function createPeli(event: React.FormEvent<HTMLFormElement>){
        let form: HTMLFormElement = event.currentTarget;

        let inputid: HTMLInputElement = form.idpeli;
        let inputtitulo: HTMLInputElement = form.titulo;
        let inputdireccion: HTMLInputElement = form.direccion;
        let inputactores: HTMLInputElement = form.actores;
        let inputargumento: HTMLInputElement = form.argumento;
        let inputimagen: HTMLInputElement = form.imagen;
        let inputvideo: HTMLInputElement = form.video;
        let inputcategoria: HTMLInputElement = form.categoria;

        let id = inputid.value;
        let titulo = inputtitulo.value;
        let direccion = inputdireccion.value;
        let actores = inputactores.value;
        let argumento = inputargumento.value;
        let imagen = inputimagen.value;
        let video = inputvideo.value;
        let categoria = inputcategoria.value;

        let pelicula: Pelicula = {
            id: id,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: imagen,
            video: video,
            categoria: categoria        
        };

        let ruta = "http://localhost:3000/peliculas";

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, pelicula);
                console.log(response.data);
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
    }

    return {
        createPeli
    }   
}

export default UseCreatePeli