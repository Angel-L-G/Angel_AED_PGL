import React from "react";
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from "react-router-dom";
import PokemonCard from "./PokemonCard";
import CapitalCard from "./CapitalCard";
import ApiCapitales from "./Adicional2";
import ApiUpdate from "./ApiUpdate";
import ApiDelete from "./ApiDelete";

type Props = {}

const Practica44 = (props: Props) => {
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
                <Route path="/updateCapital" element= 
                    {<ApiUpdate />}
                />
                <Route path="/deleteCapital" element= 
                    {<ApiDelete />}
                />
            </Routes>
        </BrowserRouter>
    );
}

export default Practica44