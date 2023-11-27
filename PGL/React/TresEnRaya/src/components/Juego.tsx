import React, { useState } from 'react'
import UseJugarPartida from '../hooks/UseJugarPartida';
import { useNavigate} from 'react-router-dom';

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
    let { jugar, moves, playerNumber, winned } = UseJugarPartida();
    const [pulsado, setPulsado] = useState<Array<String>>([] as Array<String>);

    function pulsar(index: number, player: string) {
        let aux = [...pulsado];
        let claseCssPlayer = "";

        if(playerNumber == 1){
            claseCssPlayer = "primary";
        }else if (playerNumber == 2) {
            claseCssPlayer = "secundary";
        }else {
            console.log("Error: numPlayer-" + playerNumber);
        }

        aux[index] = claseCssPlayer;
        setPulsado(aux);

        jugar(index, player);

        if(winned==1){
        }

    }

    return (
        <div className='container'>
            <h1>Tres en raya</h1>
            <div className='grid'>
                {
                    arrBotones.map((value, index) => {
                        return <button onClick={() => pulsar(index, "Player"+playerNumber)} className={'button ' + pulsado[index]}></button>
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