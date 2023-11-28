import React from 'react'
import UseFindAllPartida from '../hooks/UseFindAllPartida'
import UseDeletePartida from '../hooks/UseDeletePartida'

type Props = {}
type Moves = {
    id: number,
    user: string,
    cassilla: string
}

type Partida = {
    id: string,
    winner: string,
    moves: Array<Moves>
}

const MostrarPartidas = (props: Props) => {
    let {partidas} = UseFindAllPartida();
    let {deletePartida} = UseDeletePartida();

    return (
        <div>
            <ol>
                {
                    partidas.map((value, index) => {
                        return <li>
                            {
                            <div>
                                <h2>{value.winner}</h2>

                                <div>
                                    {  
                                        value.moves.map((move, indice) => {
                                        return <ul>
                                            <li>
                                                <p>{move.user + " - " + move.cassilla}</p>
                                            </li>
                                        </ul>
                                        })
                                    }
                                </div>
                            </div>
                            }
                            <button onClick={() => deletePartida(value.id)}>Eliminar</button>
                        </li>;
                    })
                }
            </ol>
        </div>
    )
}

export default MostrarPartidas