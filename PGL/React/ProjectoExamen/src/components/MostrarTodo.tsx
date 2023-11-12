import React from 'react'
import UseFindAllPeli from '../hooks/UseFindAllPeli';

type Props = {}

const MostrarTodo = (props: Props) => {
    const { peliculas, setPeliculas} = UseFindAllPeli();

    return (
        <div>MostrarTodo
            <br/>   
            <p>{
                JSON.stringify(peliculas[0])
            }</p>
        </div>
    )
}

export default MostrarTodo;