import axios from 'axios'
import React, { useEffect, useState } from 'react';

type Props = {}

type Moves = {
    id: number,
    user: string,
    cassilla: string
}

type Partida = {
    id: string,
    winner: string,
    moves: Array<Moves>
}

const UseFindAllPartida = () => {
    const [partidas, setPartidas] = useState<Array<Partida>>([] as Array<Partida>);
    const ruta = "http://localhost:3000/partidas";

    useEffect(() => {
        const axiosFindAll = async (ruta: string) => {
            try{
                const response = await axios.get(ruta);
                setPartidas(response.data);
                //console.log(peliculas.data);
            } catch (error){
                console.log(error);
            }
        }
        
        axiosFindAll(ruta);      
    }, [])

    return {
        partidas
    }
}

export default UseFindAllPartida