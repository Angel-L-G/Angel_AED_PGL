import React, { useState } from 'react'
import UseJugarPartida from '../hooks/UseJugarPartida';

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

const Juego = (props: Props) => {
    const arrBotones = [1,2,3,4,5,6,7,8,9];
    let { jugar, moves } = UseJugarPartida();

    return (
        <div className='container'>
            <h1>Tres en raya</h1>
            <div className='grid'>
                {
                    arrBotones.map((value, index) => {
                        return <button onClick={() => jugar(index, "Player")} className='button'></button>
                    })
                }
            </div>
            <div>
                <h2>Movimientos</h2>
                <ul>
                    {
                        moves.map((value, index) => {
                            return <li>
                                {JSON.stringify(value)}
                            </li>
                        })
                    }
                </ul>
            </div>
        </div>
    )
}

export default Juego