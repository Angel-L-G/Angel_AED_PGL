import React, { useEffect, useState } from 'react'
import '../index.css';

type Props = {}

const Practica21 = (props: Props) => {
    const [fechaactual, setfechaactual] = useState<string>("");

    useEffect(() => {
      const timerId = setInterval(
        tick,
        1000
      );
    }, [])
    
    function tick(){
        const newfecha = "" + new Date();
        setfechaactual(newfecha);
        //console.log(newfecha);
    }

    return (
        <div className='conatiner'>
            <h3>Ejemplo reloj dinamico</h3>
            <p>{fechaactual}</p>
        </div>
    )
}

export default Practica21