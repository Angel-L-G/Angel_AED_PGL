import React from 'react'
import { User } from './Types';
import axios from 'axios';
import { useAppContext } from '../components/AppContextProvider';

const UseSession = () => {
    const {setToken} = useAppContext();
    const rutaRegister = "http://localhost:8080/api/register";
    const rutaLogin = "http://localhost:8080/api/login";

    async function register(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let nick = form.nick.value;
        let password = form.psswrd.value;
        let email = form.email.value;

        let user: User = {
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

    async function login(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();
        let form: HTMLFormElement = event.currentTarget;

        let nick = form.nick.value;
        let password = form.psswrd.value;
        let email = form.email.value;

        let user: User = {
            email: email,
            nombre: nick,
            password: password
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, user);
                console.log(response.data);
                localStorage.setItem('token', response.data);
                setToken(response.data);
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

export default UseSession