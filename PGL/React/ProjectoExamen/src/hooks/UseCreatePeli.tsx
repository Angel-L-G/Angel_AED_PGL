import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Navigate, useNavigate } from 'react-router-dom';
import { Categoria, Pelicula } from './Types';

const UseCreatePeli = () => {
    const [id, setId] = useState("001");
    const ruta = "http://localhost:8080/api/v1/peliculas";
    const rutaCategorias = "http://localhost:8080/api/v1/categorias";
    const navigate = useNavigate();

    useEffect(() => {
        async function getId() {
            const response = await axios.get(ruta);
            let peliculas = response.data;
            let idAux;

            for (let i = 0; i < peliculas.length; i++) {
                idAux = peliculas[i].id;
            }

            let id2;

            if (Number(idAux) < 10) {
                id2 = "00" + (Number(idAux) + 1);
            } else if (Number(idAux) < 100) {
                id2 = "0" + (Number(idAux) + 1);
            } else {
                id2 = (Number(idAux) + 1);
            }

            setId("" + id2);
        }

        getId();
    }, []);
    
    async function getCategoria(categoriasDeLaPelicula: Array<Categoria>){
        let categorias: Array<Categoria> = [];

        const axiosFind = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                return response.data;
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
            return null;
        }

        for (let index = 0; index < categorias.length; index++) {
            console.log(index);
            if(categorias[index]){
                categorias[index] = await axiosFind(rutaCategorias +"/"+ categorias[index].id);
                console.log(categorias[index]);
            }
        }

        return categorias;
    }

    async function createPeli(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let titulo = form.titulo.value;
        let direccion = form.direccion.value;
        let actores = form.actores.value;
        let argumento = form.argumento.value;
        let imagen = form.imagen.value ?? "error.png";
        let video = form.video.value ?? "";
        let categoria = form.categoria.value ?? "";

        let categorias = categoria.split(",");
        console.log(categorias);

        //console.log(id, titulo, direccion, actores, argumento, imagen, video);

        const pelicula: Pelicula = {
            id: id,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: imagen,
            categoria: categorias,
            trailer: video
        };

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, pelicula);
                //console.log(response.data);
                navigate("/mostrarPeliculas");
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