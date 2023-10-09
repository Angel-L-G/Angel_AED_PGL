import React, { useState } from "react";

type Props = {
    tablaDel: number;
}

const Tabla = (props: Props) => {
    const [contador, incrementar] = useState(0);

    function calcularTabla(){
        if(contador >= 10){
            incrementar( contador - contador);
        }else{
            incrementar( contador + 1);
        }
    }

    return (
        <div className="container">
            <p className="p">Solucion: </p>
            <p className="p">{props.tablaDel} * {contador} = {props.tablaDel*contador}</p>
            <button onClick={ calcularTabla} className=".button">
                sumar
            </button>
        </div>
    );
}

export default Tabla;