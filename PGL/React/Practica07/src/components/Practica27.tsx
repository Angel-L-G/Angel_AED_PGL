import React, { useEffect, useRef, useState } from 'react'

type Props = {}

const Practica27 = (props: Props) => {
    const inputSegs = useRef<HTMLInputElement>({} as HTMLInputElement);
    const pRes = useRef<HTMLHeadingElement>({} as HTMLHeadingElement);
    const [active, setActive] = useState<boolean>(false);
    const [fecha, setFecha] = useState(0)

    function actualizarhora(){
        //setFecha()
    }

    useEffect(() => {
        const timerId = setInterval(
          tick,
          1000
        );
      }, [])
      
      function tick(){
          const newfecha = "" + new Date();
          //setFecha(newfecha);
          //console.log(newfecha);
      }


    function playStop(){
        if(!active){
            setActive(true);
            let inputSegsObj = inputSegs.current;
            let num = parseInt(inputSegsObj.innerText);
            setFecha(num);

        }else{
            setActive(false);

        }
    }

    return (
        <div>
            <h1>Introduzca los segundos</h1>
            <br/>
            <input type="number"></input>
            <br/>
            <button className='button' onClick={() => playStop()}>Enviar</button>
            <h2 ref={pRes}></h2>
        </div>
    )
}

export default Practica27