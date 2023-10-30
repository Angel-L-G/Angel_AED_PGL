import React from "react";
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from "react-router-dom";
import PokemonCard from "./PokemonCard";
import CapitalCard from "./CapitalCard";
import ApiCapitales from "./Adicional2";

type Props = {}

const Practica43 = (props: Props) => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/pokemon/:id" element=
                    {<PokemonCard url="https://pokeapi.co/api/v2/pokemon/" />}
                />
                <Route path="/capital/:id" element=
                    {<CapitalCard url="http://localhost:3000/capitales/" />}
                />
                <Route path="/crearCapital" element= 
                    {<ApiCapitales />}
                />
            </Routes>
        </BrowserRouter>
    );
}

export default Practica43