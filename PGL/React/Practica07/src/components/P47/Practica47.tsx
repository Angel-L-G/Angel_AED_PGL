import React from "react";
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from "react-router-dom";
import PokemonCard from "./PokemonCard";
import ListPokemonCard from "./ListPokemonCard";
import PokemonFavorite from './PokemonFavorite';
import AppContextProvider, { useAppContext } from "./AppContextProvider";

type Props = {}

const Practica47 = (props: Props) => {
    
    return (
        <BrowserRouter>
            <AppContextProvider>
                <MiFavorito />
                <Routes>
                    <Route path="/pokemon/:id" element=
                        {<PokemonCard url="https://pokeapi.co/api/v2/pokemon/" />}
                    />
                    <Route path="/" element=
                        {<ListPokemonCard/>}
                    />
                    <Route path="/PokemonFavorite" element= 
                        {<PokemonFavorite />}
                    />
                </Routes>
            </AppContextProvider>
        </BrowserRouter>
    );
}

function MiFavorito(){
    const {url,setUrl}=useAppContext();
    return(
        <div className="container">
            <PokemonCard url={url}/>
        </div>
    );
}

export default Practica47