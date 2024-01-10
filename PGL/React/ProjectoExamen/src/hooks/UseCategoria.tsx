import axios from 'axios'
import React, { ChangeEvent, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import UseFindAllPeli from './UseFindAllPeli'
import { Categoria } from './Types'

const UseCategoria = () => {
    const ruta = "http://localhost:8080/api/v1/categorias";
    const rutaV2 = "http://localhost:8080/api/v2/categorias";
    const [categorias, setCategorias] = useState<Array<Categoria>>([]);
    const {peliculas, setPeliculas} = UseFindAllPeli();
    
    let {nombre} = useParams();
    let nombreCategory = nombre ?? "";
    
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
    
    async function createCategory(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let nombre = form.nombre.value;

        const pelicula: Categoria = {
            id: "",
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

        axiospost(rutaV2);
    }

    async function findCategoryById(id: number){
        try{
            const c = await axios.get(ruta+"/"+id);
            return c.data;
        } catch (error){
            console.log(error);
        }
        return null;
    }

    return {
        createCategory,
        categorias,
        findCategoryById
    }
}

export default UseCategoria