import React from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';

import Practica11 from '../Practica11';
import RelojesMundiales from './RelojesMundiales';

function Practica38() {
    return(
        <div className="App">
            <BrowserRouter>
                <h3>Mi primer router</h3>
                <Navbar />
                    <Routes>
                        <Route path="/" element={<Practica11 />} />
                        <Route path="/relojesmundiales" element={<RelojesMundiales />} />
                        <Route path="/cronometro" element={<Practica11 />} />
                    </Routes>
            </BrowserRouter>
        </div>
    );
}

function Navbar() {
    return (
        <nav className="Minavbar">
            <Link to="/"> Inicio </Link>
            <Link to="/cronometro"> Cronómetro </Link>
            <Link to="/relojesmundiales"> Relojes mundiales </Link>
        </nav>
    )
}

export default Practica38;