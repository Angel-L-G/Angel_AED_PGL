import React, { useState } from 'react'

type ContadoresState ={
    contadorAzul: number,
    contadorVerde: number
}

const Practica12= () => {
    const [colorState, setColorState] = useState("ninguno");
    const [contadores, setcontadores] = useState({ contadorAzul:0, contadorVerde:0} as ContadoresState)
    function eligeColor(color : string){
        setColorState(color);
        let nuevoContadores ={} as ContadoresState;
        if (color == "verde"){
            nuevoContadores = {...contadores, contadorVerde: contadores.contadorVerde+1}
        }else if(color == "azul"){
            nuevoContadores = {...contadores, contadorAzul: contadores.contadorAzul+1}
        }
        setcontadores(nuevoContadores);
    }

    return (
        <>
            <h3>Realizando saludos:</h3>
            <p>Color elegido: {colorState}</p>
            <button onClick={()=>eligeColor("verde")}>verde</button>
            <button onClick={()=>eligeColor("azul")}>azul</button>
            <h5>Contadores</h5>
            <p>Verde: {contadores.contadorVerde}</p>  
            <br/>
            <p>Azul: {contadores.contadorAzul}</p>  
        </>
    )
}

export default Practica12