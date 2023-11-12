import React from 'react'
import axios from 'axios';

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string
}

const UseUpdatePeli = () => {
    function updatePeli(event: React.FormEvent<HTMLFormElement>){
        let form: HTMLFormElement = event.currentTarget;

        let inputid: HTMLInputElement = form.idpeli;
        let inputtitulo: HTMLInputElement = form.titulo;
        let inputdireccion: HTMLInputElement = form.direccion;
        let inputactores: HTMLInputElement = form.actores;
        let inputargumento: HTMLInputElement = form.argumento;
        let inputimagen: HTMLInputElement = form.imagen;

        let id = inputid.value;
        let titulo = inputtitulo.value;
        let direccion = inputdireccion.value;
        let actores = inputactores.value;
        let argumento = inputargumento.value;
        let imagen = inputimagen.value;

        let pelicula: Pelicula = {
            id: id,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: imagen        
        };

        let ruta = "http://localhost:3000/peliculas/";

        const axiosput = async (rutaDeMoneda: string) => {
            try {
                const response = await axios.put(rutaDeMoneda+id, pelicula)
                console.log(response.data);
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