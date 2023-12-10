import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios';

type Props = {
    uri: string
}

type Pokemon = {
    img: string,
    nombre: string,
    peso: number,
    tipo: string,
    img1: string,
    img2: string,
    img3: string
}

const UsePractica28Card = ({uri}: Props) => {
    const [cardData, setCardData] = useState<Pokemon>({} as Pokemon);

    const url: string = uri;

    useEffect(() => {
        async function getPokemonCard(direccion:string) {
            const response = await axios.get(direccion);
            let newCard: Pokemon;
            if(response.data.types.length == 2){
                newCard = {
                    nombre: response.data.name,
                    img: response.data.sprites.front_default,
                    img1: response.data.sprites.back_default,
                    img2: response.data.sprites.front_shiny,
                    img3: response.data.sprites.back_shiny,
                    tipo: response.data.types[0].type.name+", "+response.data.types[1].type.name,
                    peso: response.data.weight
                }
            }else{
                newCard = {
                    nombre: response.data.name,
                    img: response.data.sprites.front_default,
                    img1: response.data.sprites.back_default,
                    img2: response.data.sprites.front_shiny,
                    img3: response.data.sprites.back_shiny,
                    tipo: response.data.types[0].type.name,
                    peso: response.data.weight
                }
            }
            
            setCardData(newCard);
        }
        
        getPokemonCard(url);
    }, [])

    return {
        cardData
    }
}

export default UsePractica28Card