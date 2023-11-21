import React from 'react'

type Props = {}

const Juego = (props: Props) => {
    const arrBotones = [1,2,3,4,5,6,7,8,9];
    const arrMoves = ["Player - 2", "IA - 8", "Player - 6"];

    function jugar(id: number){
        
    }

    return (
        <div className='container'>
            <h1>Tres en raya</h1>
            <div className='grid'>
                {
                    arrBotones.map((value, index) => {
                        return <button onClick={() => jugar(value)} className='button'></button>
                    })
                }
            </div>
            <div>
                <h2>Movimientos</h2>
                <ul>
                    {
                        arrMoves.map((value, index) => {
                            return <li>
                                {value}
                            </li>
                        })
                    }
                </ul>
            </div>
        </div>
    )
}

export default Juego