import React from 'react'
import UseUpdatePeli from '../hooks/UseUpdatePeli'

type Props = {}

const UpdatePelicula = (props: Props) => {
    const {updatePeli} = UseUpdatePeli();

    return (
        <div>
            <form method="post" onSubmit={updatePeli}>
                <label htmlFor="idpeli">Id: </label>
                <input type="text" name="idpeli" id="idpeli" required/>
                <br/>

                <label htmlFor="titulo">Titulo: </label>
                <input type="text" name="titulo" id="titulo" required/>
                <br/>

                <label htmlFor="direccion">Direccion: </label>
                <input type="text" name="direccion" id="direccion" required/>
                <br/>

                <label htmlFor="actores">Actores: </label>
                <input type="text" name="actores" id="actores" required/>
                <br/>

                <label htmlFor="argumento">Argumento: </label>
                <input type="text" name="argumento" id="argumento" required/>
                <br/>

                <label htmlFor="imagen">Imagen: </label>
                <input type="text" name="imagen" id="imagen" required/>
                <br/>

                <input type="submit" value="enviar" />
            </form>
        </div>
    )
}

export default UpdatePelicula