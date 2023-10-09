import React, { useState } from 'react'

type Props = {}

const Practica15 = (props: Props) => {
    const [color, setcolor] = useState("");
    


    return (
        <div className='conatiner'>
            <h1>Botones y CSS</h1>
            <h4 className={color}> Este area muestra los colores</h4>
            <button onClick={()=>setcolor("rosa")} className='button'>rosa</button>
            <button onClick={()=>setcolor("rojo")} className='button'>rojo</button>
            <button onClick={()=>setcolor("verde")} className='button'>verde</button>
            <button onClick={()=>setcolor("azul")} className='button'>azul</button>
        </div>
    )
}

export default Practica15;