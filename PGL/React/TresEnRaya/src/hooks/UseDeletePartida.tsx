import axios from 'axios';
import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

type Props = {}

const UseDeletePartida = () => {
    const ruta = "http://localhost:3000/partidas/";
    let navigate = useNavigate();

    async function deleteAxios(id: string){
        axios.delete(ruta + id)
        .then(response => {
            console.log("Deleted post with ID ${id}");
            navigate("/");
        })
        .catch(error => {
            console.error(error);
        });
    }
    
    
    function deletePartida(id: string){
        deleteAxios(id);
    }

    return {
        deletePartida
    }
}

export default UseDeletePartida