import React, { ChangeEvent } from 'react'

type Props = {}

export interface Iprops {
    modificarPadre: Function
}

const CompA = (props: Iprops) => {
    function enviarInfo(evt: ChangeEvent<HTMLInputElement>) {
        const { modificarPadre } = props;
        
        modificarPadre(evt.currentTarget.value);
    }

    return (
        <div className='container'>
            <p>
                <h3>Componente Hijo A</h3>
                <input type="text" onChange={enviarInfo}/>
            </p>
        </div>
    )
}

export default CompA;