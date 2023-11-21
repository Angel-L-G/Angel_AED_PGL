import React from 'react'

type Props = {}
type Partida = {

}

const MostrarPartidas = (props: Props) => {
    const arrPartidas: Array<Partida> = [];

    return (
        <div>
            <ul>
                {
                    arrPartidas.map((value, index) => {
                        return <li><div>
                            {/*
                                //<h2>{value.id}</h2>

                                {
                                    value.moves.map((move, indice) => {
                                        return <ol>
                                            <li>
                                                <p>{move.user + " - " + move.casilla}</p>
                                            </li>
                                        </ol>
                                    })
                                }
                            */}
                        </div></li>;
                    })
                }
            </ul>
        </div>
    )
}

export default MostrarPartidas