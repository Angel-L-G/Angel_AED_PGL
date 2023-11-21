import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Juego from './Juego';
import MostrarPartidas from './MostrarPartidas';

type Props = {}

const Main = (props: Props) => {
    return (
        <BrowserRouter>
            <Navbar />

            <Routes>
                <Route path="/" element={<Juego />} />
                <Route path="/jugar" element={<Juego />} />
                <Route path="/showPartidas" element={<MostrarPartidas />} />
            </Routes>
        </BrowserRouter>
    );
}

function Navbar(){
    return (
        <nav>
            <Link to="/jugar">Jugar</Link> &nbsp;
            <Link to="/showPartidas">Mostrar Partidas</Link> &nbsp;
            {/*<Link to="/"></Link> &nbsp;*/}
        </nav>
    );
}

export default Main