import { View, Text } from 'react-native'
import React, { useContext } from 'react'
import axios from 'axios';
import { Usuario } from '../components/types';
import EncryptedStorage from "react-native-encrypted-storage";
import AppContextProvider, { AppContext } from '../components/AppContextProvider';

type Props = {
  navigation:any
}

const UseSesion = ({navigation}: Props) => {
    const {setUser} = useContext(AppContext);
    const ruta = "http://172.26.16.0:8080/api/v1";

    async function register(nick: string, password: string, email: string){

        let user: Usuario = {
            email: email,
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta+"/register", user);
                console.log(response.data);
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);

        navigation.navigate("Login");
    }

    async function login(nick: string, password: string){
        let user: Usuario = {
            email: "",
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta+"/login", user);
                console.log(response.data);
                if(response.status == 403){
                    // PARA EN CASO DEL 403
                }else {
                    setUser(user);
                    EncryptedStorage.setItem("token", response.data);
                }
                //localStorage.setItem('token', response.data);
                
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);

        navigation.navigate("DrawerNav");
    }

  return {
    login,
    register,
  }
}

export default UseSesion