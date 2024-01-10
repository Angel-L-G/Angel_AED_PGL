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
import Register from './Register';
import Login from './Login';

type Props = {}

const Main = (props: Props) => {
    return (
        <BrowserRouter>
            <AppContextProvider>
            <Navbar />
                <Routes>
                    <Route path="/" element={<MostrarTodo />} />
                    <Route path="/register" element={<Register/>} />
                    <Route path="/login" element={<Login />} />
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
            <Link to="/login">Login </Link>
            <Link to="/register">Register </Link>
            <Link to="/mostrarPeliculas">Inicio </Link>
            <Link to="/crearPelicula">Crear Peliculas </Link>
            <Link to="/mostrarCategorias">Mostrar Categorias </Link>
            {/*<Link to="/"></Link> &nbsp;*/}
        </nav>
    );
}

export default Main