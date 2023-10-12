import React, { useRef, useState } from 'react'

type Props = {}

const Practica25 = (props: Props) => {
    const [arrAleatorio, setArrAleatorio] = useState<Array<number>>([]);
    const arrRef = useRef<Array<number>>([]);

    function generarAleatorio() {
        arrRef.current.push(Math.floor(Math.random()*100));
    }

    function mostrarAleatorio() {
        setArrAleatorio([...arrRef.current]);
    }

    return (
        <div className='container'>
            <button className='button' onClick={() => generarAleatorio()}>Generar Aleatorio</button>
            <button className='button' onClick={() => mostrarAleatorio()}>Mostrar</button>
            <p>{arrAleatorio}</p>
        </div>
    )
}

export default Practica25