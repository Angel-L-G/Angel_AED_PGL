import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import CrearPelicula from './CrearPelicula';
import UpdatePelicula from './UpdatePelicula';
import MostrarTodo from './MostrarTodo';
import PeliculaCard from './PeliculaCard';
import DetallePelicula from './DetallePelicula';
import AppContextProvider from './AppContextProvider';
import CategoryShow from './CategoryShow';
import CategoryFiltered from './CategoryFiltered';

type Props = {}

const Main = (props: Props) => {
    return (
        <BrowserRouter>
            <AppContextProvider>
            <Navbar />
                <Routes>
                    <Route path="/" element={<MostrarTodo />} />
                    <Route path="/pelicula/:id" element={<DetallePelicula />} />
                    <Route path="/mostrarPeliculas" element={<MostrarTodo />} />
                    <Route path="/crearPelicula" element={<CrearPelicula />} />
                    <Route path="/editarPelicula/:id" element={<UpdatePelicula />} />
                    <Route path="/mostrarCategorias" element={<CategoryShow />} />
                    <Route path="/categorias/:nombre" element={<CategoryFiltered />} />
                </Routes>
            </AppContextProvider>
        </BrowserRouter>
    );
}

function Navbar(){
    return (
        <nav>
            <Link to="/mostrarPeliculas">Inicio</Link> &nbsp;
            <Link to="/crearPelicula">Crear Peliculas</Link> &nbsp;
            <Link to="/mostrarCategorias">Mostrar Categorias</Link> &nbsp;
            {/*<Link to="/"></Link> &nbsp;*/}
        </nav>
    );
}

export default Main