import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Navigate, useNavigate } from 'react-router-dom';
import { Categoria, Pelicula } from './Types';
import UseCategoria from './UseCategoria';
import { useAppContext } from '../components/AppContextProvider';

type Pelicula64 = {
    id: number,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    nameImagen: string,
    imagen: string,
    trailer: string,
    categorias: Categoria[]
}

const UseCreatePeli = () => {
    const ruta = "http://localhost:8080/api/v2/peliculas/files64";
    const rutaCategorias = "http://localhost:8080/api/v1/categorias";

    const {token} = useAppContext();
    const navigate = useNavigate();
    const {findCategoryById} = UseCategoria();
    
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
        let strIdcategorias = form.categoria.value ?? "";
        let img64 = form.imagen64.value;

        let idCategorias = strIdcategorias.split(",");
        //console.log(idCategorias);

        let arrCatgs: Array<Categoria> = [];

        for (let index = 0; index < idCategorias.length; index++) {
            let c = await findCategoryById(idCategorias[index]);
            if(c != null){
                arrCatgs.push(c);
            }
        }

        const pelicula: Pelicula64 = {
            id: 0,
            titulo: titulo,
            direccion: direccion,
            actores: actores,
            argumento: argumento,
            imagen: img64,
            nameImagen: imagen,
            categorias: arrCatgs,
            trailer: video
        };

        const axiospost = async (ruta: string) => {
            try{
                console.log("TOOOOOOOOKKKEEEEEEEENNNNNNNNNN");
                console.log(token);
                console.log("Peliiiiiiiiiiiiiii");
                console.log(pelicula);
                const response = await axios.post(ruta, pelicula, { headers: { "Authorization": "Bearer " + token } });
                console.log(response.data);
                navigate("/mostrarPeliculas");
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
    }

    return {
        createPeli,
    }   
}

export default UseCreatePeli