import Reloj from './Reloj'
import React from 'react';

type Props ={
}

export const RelojesMundiales = (props: Props) => {
    return (
        <div className='container'>
            <h1>Actividad react: Relojes mundiales</h1>
            <Reloj zona="Europe/Madrid" />
            <Reloj zona="America/New_York" />
            <Reloj zona="Europe/London" />
        </div>
    )
}

export default RelojesMundiales;