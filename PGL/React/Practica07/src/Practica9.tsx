import React, { useState } from "react";

type Props = {}

const FCContador = (props: Props) => {
    const [contador, incrementar] = useState(0);
    if(contador > 10){
        incrementar( contador - contador);
    }
    return (
        <>
            <p>Solucion: </p>
            <p>{contador*2}</p>
            <button onClick={() => incrementar( contador + 1) }>
                sumar
            </button>
        </>
    );
}

export default FCContador;