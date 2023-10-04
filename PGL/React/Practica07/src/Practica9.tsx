import React, { useState } from "react";

type Props = {
    tablaDel: number;
}

const [contador, incrementar] = useState(0);
const tablaDel = 7;

function calcularTabla(){
    if(contador >= 10){
        incrementar( contador - contador);
    }else{
        incrementar( contador + 1);
    }
}

const FCContador = (props: Props) => {
    return (
        <>
            <p>Solucion: </p>
            <p>{tablaDel} * {contador} = {tablaDel*2}</p>
            <button onClick={ calcularTabla}>
                sumar
            </button>
        </>
    );
}

export default FCContador;