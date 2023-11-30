import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import axios from 'axios'

type Props = {}

const UsePractica28List = () => {
    const uri: string = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=151";
    const [results, setResults] = useState<Array<string>>([]);

    useEffect(() => {
        async function getPokemonCard(direccion: string) {
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

    return {
        results,
    }
}

export default UsePractica28List