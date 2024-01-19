import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Alumno } from '../components/types';

type Props = {
    navigation: any
}

const UseAlumnos = ({navigation}: Props) => {
    const ruta = "http://localhost:8080/api/v2/alumnos";
    const [alumnos, setAlumnos] = useState<Array<Alumno>>(Array<Alumno>);

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                setAlumnos(response.data);
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);      
    }, [])
    
    async function saveAlumno(dni: string, nombre: string, apellidos: string, foto: string, fechanacimiento: number){

        const alumno: Alumno = {
            dni: dni,
            nombre: nombre,
            apellidos: apellidos,
            foto: foto,
            fechanacimiento: fechanacimiento
        };

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, alumno);
                //console.log(response.data);
                navigation.navigate("/ListarAlumnos");
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
    }

    async function findAlumnoById(dni: string){
        try{
            const c = await axios.get(ruta+"/"+dni);
            return c.data;
        } catch (error){
            console.log(error);
        }
        return null;
    }

    return {
        saveAlumno,
        alumnos,
        findAlumnoById,
        
    }
}

export default UseAlumnos