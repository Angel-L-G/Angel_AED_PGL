import React from 'react';
import axios from 'axios';

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string
}

const UseDeletePeli = () => {
    function deletePeli(event: React.FormEvent<HTMLFormElement>){
        let form: HTMLFormElement = event.currentTarget;

        let inputid: HTMLInputElement = form.idpeli;

        let id = inputid.value;

        let ruta = "http://localhost:3000/peliculas/";

        const axiosDelete = async (ruta: string) => {
            try {
                const response = await axios.delete(ruta+id)
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
        }

        axiosDelete(ruta);
    }

    return {
        deletePeli
    };
}

export default UseDeletePeli