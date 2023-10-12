import React, { ChangeEvent, useState } from 'react'

type Props = {}

const Practica28 = (props: Props) => {
    const [txt, setTxt] = useState("")

    function mostrar(event: ChangeEvent<HTMLInputElement>) {
        setTxt(event.currentTarget.value);
    }

    return (
        <div className='container'>
            <input type="text" onChange={mostrar} />
            <h5>Nombre: {txt}</h5>
        </div>
    )
}

export default Practica28