import axios from 'axios';
import React, { useEffect } from 'react'
import { useState } from 'react';
import PokemonCard from './PokemonCard';

type Props = {}

const ListPokemonCard = (props: Props) => {
    const uri: string = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=151";
    const [results, setResults] = useState<Array<string>>([]);

    useEffect(() => {
        async function getPokemonCard(direccion:string) {
            const response = await axios.get(direccion);
            const arrAll = response.data.results;
            const aux = [];

            for (let index = 0; index < arrAll.length; index++) {
                aux[index] = arrAll[index].url;
            }
            
            setResults(aux);
        }

        getPokemonCard(uri);
    }, [])


    return (
        <div className='container'>
            {
                results.map((valor, index) => {
                    return <PokemonCard url={valor} />
                })
            }
        </div>
    )
}

export default ListPokemonCard