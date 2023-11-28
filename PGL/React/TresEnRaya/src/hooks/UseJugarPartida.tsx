import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

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
    const [clicked, setClicked] = useState<Array<String>>([] as Array<String>);
    const [contadorMoves, setContadorMoves] = useState(0);
    const [playerNumber, setPlayerNumber] = useState(1);
    const [winned, setWinned] = useState(0);
    const [id, setId] = useState("");
    const ruta = "http://localhost:3000/partidas";
    let navigate = useNavigate();

    async function getId() {
        const response = await axios.get(ruta);
        let partidas = response.data;
        let idAux;

        for (let i = 0; i < partidas.length; i++) {
            idAux = partidas[i].id;
        }

        let id2;

        if (Number(idAux) < 10) {
            id2 = "00" + (Number(idAux) + 1);
        } else if (Number(idAux) < 100) {
            id2 = "0" + (Number(idAux) + 1);
        } else {
            id2 = (Number(idAux) + 1);
        }

        setId("" + id2);
    }

    function savePartida(){
        getId();

        let aux: Partida;
        aux = {
            id: id,
            winner: "Player"+playerNumber,
            moves: moves
        }

        const axiospost = async (ruta: string) => {
            try{
                const response = await axios.post(ruta, aux);
                //console.log(response.data);
                navigate("/showPartidas");
            } catch (error){
                console.log(error);
            }
        }

        axiospost(ruta);
    }

    function checkPosition(id: number, player: string) {
        let ok = true;

        if(!clicked[id]) {
            let aux = clicked;
            aux[id] = player;
            setClicked(aux);
            setPlayerNumber(2);
            setContadorMoves(contadorMoves + 1);
        }

        let value = clicked[id];

        if (value != null && value != undefined) {
            setContadorMoves(contadorMoves + 1);

            let move: Moves;
            move = {
                id: contadorMoves,
                user: player,
                cassilla: id+"" 
            };

            console.log(moves);
            setMoves([...moves, move]);
            console.log(moves);

            if(playerNumber == 1) {
                setPlayerNumber(2);
                console.log("5-1");
            }else if (playerNumber == 2) {
                setPlayerNumber(1);
                console.log("5-2");
            }
            
        } else {
            console.log("ya pulsado");
            ok = false;
        }

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
                savePartida();
                navigate("/showPartidas");
            }
        }
    }

    function jugar(id: number, player: string) {
        if(winned == 1){
            return null;
        }

        if (checkPosition(id, player)) {
            let aux = checkWinner(player);
        } else {
            return null;
        }
    }

    return {
        jugar,
        moves,
        playerNumber,
        winned
    }
}

export default UseJugarPartida;