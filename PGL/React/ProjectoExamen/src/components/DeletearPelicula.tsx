import React from 'react'
import UseDeletePeli from '../hooks/UseDeletePeli';

type Props = {}

const DeletearPelicula = (props: Props) => {
    const {deletePeli} = UseDeletePeli();

    return (
        <div>
            <form method="post" onSubmit={deletePeli}>
                <label htmlFor="idpeli">Id: </label>
                <input type="text" name="idpeli" id="idpeli" required/>
                <br/>

                <input type="submit" value="enviar" />
            </form>
        </div>
    )
}

export default DeletearPelicula