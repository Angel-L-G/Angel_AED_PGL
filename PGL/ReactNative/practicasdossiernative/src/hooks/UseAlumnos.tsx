import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Alumno } from '../components/types';
import EncryptedStorage from 'react-native-encrypted-storage';
import { DrawerActions } from '@react-navigation/native';
import { useAppContext } from '../components/AppContextProvider';

type Props = {
    navigation: any
}

const UseAlumnos = () => {
    const ruta = "http://192.168.56.1:8080/api/v2/alumnos";
    const [alumnos, setAlumnos] = useState<Array<Alumno>>(Array<Alumno>);
    const [alumnosFiltrados, setAlumnosFiltrados] = useState<Array<Alumno>>(Array<Alumno>);
    const {token} = useAppContext();

    useEffect(() => {
        axiosFindAll(ruta);    
    }, [])

    useEffect(() => {
        console.log("AAAAAAAA")
        setAlumnosFiltrados(alumnos);
    }, [alumnos])

    const axiosFindAll = async (ruta: string) => {
        try{
            let tk = "";
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }
            
            const response = await axios.get(ruta, { headers: { "Authorization": "Bearer " + tk } });
            setAlumnos(response.data);
            setAlumnosFiltrados(response.data);
        } catch (error){
            console.log(error);
        }
    }
    
    
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
                let tk = "";
                if(token == null){
                    tk = await EncryptedStorage.getItem("token");
                }else {
                    tk = token;
                }

                const response = await axios.post(ruta, alumno, { headers: { "Authorization": "Bearer " + tk } });

                axiosFindAll(ruta);
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);

        setAlumnos([...alumnos, alumno]);
    }

    async function findAlumnoById(dni: string){
        try{
            let tk = "";
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }

            const c = await axios.get(ruta+"/"+dni, { headers: { "Authorization": "Bearer " + tk } });
            return c.data;
        } catch (error){
            console.log(error);
        }
        return null;
    }

    async function deleteAlumno(dni: string){
        try{
            let tk = "";
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }

            const c = await axios.delete(ruta+"/"+dni, { headers: { "Authorization": "Bearer " + tk } });

            setAlumnos(lista => [...lista.filter(a => a.dni != dni)]);
        } catch (error){
            console.log(error);
        }
    }

    async function updateAlumno(a: Alumno){
        const alumno: Alumno = {
            dni: a.dni,
            nombre: a.nombre,
            apellidos: a.apellidos,
            foto: a.foto,
            fechanacimiento: a.fechanacimiento
        };

        let dni = a.dni;

        try{
            let tk = "";
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }

            const c = await axios.put(ruta, alumno, { headers: { "Authorization": "Bearer " + tk } });

            setAlumnos(lista => [...lista.filter(a => a.dni != dni),alumno]);

            console.log(alumnos);
        } catch (error){
            console.log(error);
        }
    }

    return {
        saveAlumno,
        alumnos,
        findAlumnoById,
        deleteAlumno,
        updateAlumno,
        alumnosFiltrados,
        setAlumnosFiltrados,
    }
}

export default UseAlumnos