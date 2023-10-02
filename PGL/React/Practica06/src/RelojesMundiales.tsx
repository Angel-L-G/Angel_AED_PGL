import Reloj from './Reloj'
import React from 'react';

type Props ={
}

export const RelojesMundiales = (props: Props) => {
    return (
        <>
            <h1>Actividad react: Relojes mundiales</h1>
            <Reloj zona="Europe/Madrid" />
            <Reloj zona="America/New_York" />
            <Reloj zona="Europe/London" />
        </>
    )
}

export default RelojesMundiales;