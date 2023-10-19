import React from 'react'

type Props = {}

export interface Iprops {
    modificarPadre: Function
}

const CompB = (props: Iprops) => {
    function enviarInfo() {
        const { modificarPadre } = props;
    
        modificarPadre("Pulsado Boton En B");
    }

    return (
        <div className='container'>
            <p>
                <h3>Componente Hijo B</h3>
                <button onClick={enviarInfo}>Enviar info</button>
            </p>
        </div>
    )
}

export default CompB;