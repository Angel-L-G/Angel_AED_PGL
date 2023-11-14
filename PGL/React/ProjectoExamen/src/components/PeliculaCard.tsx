import React from 'react'

type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string,
    video: string,
    categoria: string
}

type Props = {
   peli: Pelicula 
}

const PeliculaCard = (props: Props) => {
    return (
        <div>
            <img src={"http://localhost:3000/"+props.peli.imagen}/>
            <h1>{props.peli.titulo}</h1><br />
            <p>{props.peli.direccion}</p><br />
            <p>{props.peli.actores}</p><br />
            <p>{props.peli.argumento}</p><br />
            <p>{props.peli.categoria}</p><br />
            <p>{props.peli.video}</p>
        </div>
    )
}

export default PeliculaCard