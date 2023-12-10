import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios'

type Props = {}
export type PokemonURL={
    name: string,
    url: string
}
const UsePractica28List = () => {
    const uri: string = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=151";
    const [results, setResults] = useState<Array<string>>([]);
    const [names, setNames] = useState<Array<string>>([]);
    const [pokemonUrl, setPokemonUrl] = useState<Array<PokemonURL>>([])
    useEffect(() => {
        async function getPokemonCard(direccion: string) {
            const response = await axios.get(direccion);
            const arrAll = response.data.results;
            const aux = [];
            const aux2 = [];

            for (let index = 0; index < arrAll.length; index++) {
                aux[index] = arrAll[index].url;
                aux2[index] = arrAll[index].name;
            }

            setPokemonUrl(response.data.results);
            setResults(aux);
            setNames(aux2);
        }

        getPokemonCard(uri);
    }, [])

    return {
        results,
        names,
        pokemonUrl
    }
}

export default UsePractica28List