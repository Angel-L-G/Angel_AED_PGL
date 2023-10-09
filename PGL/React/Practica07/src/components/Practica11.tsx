import React, { useState } from 'react'

type Props = {}

const ComponenteEstatico = (props: Props) => {
    const [horaactual, sethoraactual] = useState("");

    let dato = 1;

    function actualizar(){
        ComponenteEstatico.atributoestatico++;
        dato++;
        console.log("Estatico: " + ComponenteEstatico.atributoestatico);
        console.log("dato: " + dato);
        //sethoraactual("" +  new Date());
    }

    return (
        <div>
            <h4>ComponenteConEstatico</h4>
            <p>Info en estatico: {ComponenteEstatico.atributoestatico}</p>
            <button onClick={actualizar}>Actualizar</button>
        </div>
    )
}

ComponenteEstatico.atributoestatico = 2;
export default ComponenteEstatico;