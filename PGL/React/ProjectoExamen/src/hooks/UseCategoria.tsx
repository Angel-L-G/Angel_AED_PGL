import axios from 'axios'
import React, { ChangeEvent, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import UseFindAllPeli from './UseFindAllPeli'

type Category = {
    id: string,
    nombre: string
}

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

const UseCategoria = () => {
    const ruta = "http://localhost:3000/categorias";
    const [categorias, setCategorias] = useState<Array<Category>>([]);
    const {peliculas, setPeliculas} = UseFindAllPeli();
    
    let {nombre} = useParams();
    let nombreCategory = nombre ?? "";
    
    const [id, setId] = useState("001");
    const navigate = useNavigate();

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                setCategorias(response.data);
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);      
    }, [])

    useEffect(() => {
        async function getId() {
            const response = await axios.get(ruta);
            let categorias = response.data;
            let idAux;

            for (let i = 0; i < categorias.length; i++) {
                idAux = categorias[i].id;
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
    
    async function createCategory(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let nombre = form.nombre.value;

        const pelicula: Category = {
            id: id,
            nombre: nombre
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
        //ECONNABORTED
    }

    return {
        createCategory,
        categorias
    }
}

export default UseCategoria