import { View, Text } from 'react-native'
import React from 'react'
import axios from 'axios';
import { Usuario } from '../components/types';

type Props = {
  navigation:any
}

const UseSesion = ({navigation}: Props) => {
  const rutaRegister = "http://localhost:8080/api/register";
  const rutaLogin = "http://localhost:8080/api/login";

    async function register(nick: string, password: string, email: string){

        let user: Usuario = {
            email: email,
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, user);
                console.log(response.data);
            } catch (error){
                console.log(error);
            }
        }

        axiospost(rutaRegister);
    }

    async function login(nick: string, password: string){

        let user: Usuario = {
            email: "",
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, user);
                console.log(response.data);
                //localStorage.setItem('token', response.data);
                //setToken(response.data);
            } catch (error){
                console.log(error);
            }
        }

        axiospost(rutaLogin);
    }

  return {
    login,
    register,
  }
}

export default UseSesion