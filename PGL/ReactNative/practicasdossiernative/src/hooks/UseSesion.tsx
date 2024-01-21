import { View, Text } from 'react-native'
import React, { useContext } from 'react'
import axios from 'axios';
import { Usuario } from '../components/types';
import EncryptedStorage from "react-native-encrypted-storage";
import AppContextProvider, { AppContext } from '../components/AppContextProvider';
import AsyncStorage from '@react-native-async-storage/async-storage';

type Props = {
  navigation:any
}

const UseSesion = () => {
    const {setUser,setToken,setRol} = useContext(AppContext);
    //const ruta = "http://172.26.16.0:8080/api/v1";
    const ruta = "http://192.168.56.1:8080/api/v1";

    async function register(nick: string, password: string, email: string, navigation: any){

        let user: Usuario = {
            email: email,
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta+"/register", user);
                if(response.status>199 && response.status < 300){
                    navigation.navigate("Login");
                }
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);  
    }

    async function login(nick: string, password: string, navigation: any){
        let user: Usuario = {
            email: "",
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta+"/login", user);
                if(response.status>199 && response.status < 300){
                    setUser(user);
                    setToken(response.data);
                    await EncryptedStorage.setItem("token", response.data);
                    navigation.navigate("DrawerNav");

                    const tk = response.data;

                    const rolFromBack = await axios.get(ruta+"/"+tk);
                    setRol(rolFromBack.data);
                    AsyncStorage.setItem('rol', rolFromBack.data);
                }else {
                    
                }
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
    }

  return {
    login,
    register,
  }
}

export default UseSesion