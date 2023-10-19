import React, { useState } from 'react';
import CompA from './CompA';
import CompB from './CompB';

type Props = {}

const Practica35 = (props: Props) => {
    const [dato, setDato] = useState<String>("");

    function modState(datoEnv: String) {
        setDato(datoEnv);
    }
    
    return (
        <div className='container'>
            <h1>EjStateByProps</h1>
            <h2>Mensaje Recibido: {dato}</h2>
            <CompA modificarPadre={modState}/>
            <CompB modificarPadre={modState}/>
        </div>
    )
}

export default Practica35