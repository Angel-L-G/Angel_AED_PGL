import React from 'react'

type Props = {
zona?: string;
}

const Reloj = (props: Props) => {
    let zona = props.zona?? "Europe/London";
    const fecha = new Date().toLocaleString( "es-ES",{timeZone: zona });
    return (
        <>
            {zona}
            {fecha}
        </> 
    )
}

export default Reloj