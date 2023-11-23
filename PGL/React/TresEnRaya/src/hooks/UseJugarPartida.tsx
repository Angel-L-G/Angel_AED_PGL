import React, { useState } from 'react'

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

const UseJugarPartida = () => {
    const [moves, setMoves] = useState<Array<Moves>>([] as Array<Moves>);
    const [partida, setPartida] = useState<Partida>({} as Partida);
    const [clicked, setClicked] = useState<Array<String>>({} as Array<String>);
    const [contadorMoves, setContadorMoves] = useState(0);
    const [winned, setWinned] = useState(0);

    function checkPosition(id: number, player: string) {
        let ok = true;
        clicked.map((value, index) => {
            if (index == id && value != null && value != undefined) {
                ok = false;
            } else {
                clicked[index] = player;

                let move: Moves;

                move = {
                    id: contadorMoves,
                    user: player,
                    cassilla: index+"" 
                };
            }
        })
        return ok;
    }

    function checkWinner(player: string) {
        const lines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ];

        for (let i = 0; i < lines.length; i++) {
            const [a, b, c] = lines[i];
            if (clicked[a] && clicked[a] === clicked[b] && clicked[a] === clicked[c]) {           
                setWinned(1);
                return clicked[a];
            }
        }
    }

    function jugar(id: number, player: string) {
        if(winned == 1){
            return null;
        }

        if (checkPosition(id, player)) {
            let aux = checkWinner(player);
            if(aux != null){
                return player;
            }
        } else {
            return null;
        }
    }

    return {
        jugar,
        moves
    }
}

export default UseJugarPartida;