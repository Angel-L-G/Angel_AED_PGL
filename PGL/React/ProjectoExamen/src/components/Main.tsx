import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import CrearPelicula from './CrearPelicula';
import DeletearPelicula from './DeletearPelicula';
import UpdatePelicula from './UpdatePelicula';
import MostrarTodo from './MostrarTodo';

type Props = {}

const Main = (props: Props) => {
    return (
        <BrowserRouter>
        <Navbar />
            <Routes>
                <Route path="/" element={<MostrarTodo />} />
                <Route path="/mostrarPeliculas" element={<MostrarTodo />} />
                <Route path="/crearPelicula" element={<CrearPelicula />} />
                <Route path="/borrarPelicula" element={<DeletearPelicula />} />
                <Route path="/editarPelicula" element={<UpdatePelicula />} />
            </Routes>
        </BrowserRouter>
    );
}

function Navbar(){
    return (
        <nav>
            <Link to="/mostrarPeliculas">Inicio</Link> &nbsp;
            <Link to="/crearPelicula">Crear Peliculas</Link> &nbsp;
            <Link to="/borrarPelicula">Borrar Peliculas</Link> &nbsp;
            <Link to="/editarPelicula">Editar Peliculas</Link> &nbsp;
            {/*<Link to="/"></Link> &nbsp;*/}
        </nav>
    );
}

export default Main