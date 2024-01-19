import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Alumno } from '../components/types';
import EncryptedStorage from 'react-native-encrypted-storage';

type Props = {
    navigation: any
}

const UseAlumnos = ({navigation}: Props) => {
    const ruta = "http://172.26.16.0:8080/api/v2/alumnos";
    const [alumnos, setAlumnos] = useState<Array<Alumno>>(Array<Alumno>);

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const tk = EncryptedStorage.getItem("token");
                const response = await axios.get(ruta, { headers: { "Authorization": "Bearer " + tk } });
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
                const tk = EncryptedStorage.getItem("token");
                const response = await axios.post(ruta, alumno, { headers: { "Authorization": "Bearer " + tk } });
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
            const tk = EncryptedStorage.getItem("token");
            const c = await axios.get(ruta+"/"+dni, { headers: { "Authorization": "Bearer " + tk } });
            return c.data;
        } catch (error){
            console.log(error);
        }
        return null;
    }

    async function deleteAlumno(dni: string){
        try{
            const tk = EncryptedStorage.getItem("token");
            const c = await axios.delete(ruta+"/"+dni, { headers: { "Authorization": "Bearer " + tk } });
            return c.data;
        } catch (error){
            console.log(error);
        }
        return null;
    }

    async function updateAlumno(dni: string, nombre: string, apellidos: string, foto: string, fechanacimiento: number){
        const alumno: Alumno = {
            dni: dni,
            nombre: nombre,
            apellidos: apellidos,
            foto: foto,
            fechanacimiento: fechanacimiento
        };

        try{
            const tk = EncryptedStorage.getItem("token");
            const c = await axios.put(ruta, alumno, { headers: { "Authorization": "Bearer " + tk } });
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
        deleteAlumno,
        updateAlumno
    }
}

export default UseAlumnos