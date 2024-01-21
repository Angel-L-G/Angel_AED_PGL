import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import { Usuario } from '../components/types';
import { useAppContext } from '../components/AppContextProvider';
import EncryptedStorage from 'react-native-encrypted-storage';
import axios from 'axios';

type Props = {}

const UseUsuario = () => {
    const [usuarios, setUsuarios] = useState<Array<Usuario>>([] as Array<Usuario>);
    const {token} = useAppContext();
    const ruta = "http://192.168.56.1:8080/api/v3/usuarios";
    
    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                let tk = "";
                if(token == null){
                    tk = await EncryptedStorage.getItem("token");
                }else {
                    tk = token;
                }
                
                const response = await axios.get(ruta, { headers: { "Authorization": "Bearer " + tk } });
                setUsuarios(response.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);      
    }, [])

    async function updateUsuario(nombre: string){
        const usuario: Usuario = {
            nombre: nombre,
            email: "",
            password: "",
        }

        console.log(nombre);

        try{
            let tk = "";
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }
            const c = await axios.put(ruta+"/getRol", nombre, { 
                params: { nombre },
                headers: { "Authorization": "Bearer " + tk } 
            });
            //const c = await axios.put(ruta, usuario, { headers: { "Authorization": "Bearer " + tk } });
        } catch (error){
            console.log(error);
        }
    }

    return {
        usuarios,
        updateUsuario
    }
}

export default UseUsuario