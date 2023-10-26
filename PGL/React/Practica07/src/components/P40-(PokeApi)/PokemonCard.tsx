import axios from 'axios';
import React, { useEffect } from 'react'
import { useState } from 'react';


type Props = {}

type Iprops = {
    url: string
}

type PokemonCardData = {
    name: string,
    imageF: string,
    imageB: string,
    imageShinyF: string,
    imageShinyB: string,
    h: number,
    w: number
}

const PokemonCard = (props: Iprops) => {
    const [cardData, setCardData] = useState<PokemonCardData>({} as PokemonCardData);

    const uri: string = props.url;

    useEffect(() => {
        async function getPokemonCard(direccion:string) {
            const response = await axios.get(direccion);
            const newCard: PokemonCardData = {
                name: response.data.name,
                imageF: response.data.sprites.front_default,
                imageB: response.data.sprites.back_default,
                imageShinyF: response.data.sprites.front_shiny,
                imageShinyB: response.data.sprites.back_shiny,
                h: response.data.height,
                w: response.data.weight
            }
            setCardData(newCard);
        }
        
        getPokemonCard(uri);
    }, [])
    

    return (
        <div className='container'>
            <h3>{cardData.name}</h3>
            <br/>
            <p>Height: {cardData.h}, Wheight: {cardData.w}</p>
            <br/>
            <span>
                <img src={cardData.imageF}/>
                <img src={cardData.imageB}/> 
            </span>
            <br/>
            <div>
                <img src={cardData.imageShinyF}/>
                <img src={cardData.imageShinyB}/>
            </div>
        </div>
    )
}

export default PokemonCard;