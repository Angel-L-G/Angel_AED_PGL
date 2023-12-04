import { View, Text } from 'react-native'
import React, { useEffect, useState } from 'react'
import UsePractica28List from './UsePractica28List'

type Props = {}

const UsePractica28Filtrar = () => {
    let {names, results, pokemonUrl} = UsePractica28List();
    const [textoInput, setTextoInput] = useState<string>("")

    function filtrar(txt: string){
        /*if(txt != null && txt.length > 0){
            let aux = [];

            for (let i = 0; i < names.length; i++) {
                if(names[i].includes(txt)){
                    aux.push(results[i]);
                    console.log(results[i]);
                }
            }

            await setFiltered(aux);
        }else{
            await setFiltered([]);
        }*/
        setTextoInput(txt);
    }

    const listaFiltrado = pokemonUrl.filter((pok)=> pok.name.includes(textoInput));
    
    return {
        listaFiltrado,
        filtrar,
        results
    }
}

export default UsePractica28Filtrar