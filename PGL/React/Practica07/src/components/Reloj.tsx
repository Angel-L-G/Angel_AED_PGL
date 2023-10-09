import React, { useEffect, useState } from 'react'
import '../index.css';

type Props = {
zona?: string;
}

const Reloj = (props: Props) => {
    let zona = props.zona?? "Europe/London";
    const fecha = new Date().toLocaleString( "es-ES",{timeZone: zona });

    const [fechaactual, setfechaactual] = useState<string>("");

    useEffect(() => {
        const timerId = setInterval(
          tick,
          1000
        );
      }, [])
      
      function tick(){
          const newfecha = "" + new Date().toLocaleString("es-ES",{timeZone: zona });
          setfechaactual(newfecha);
          //console.log(newfecha);
      }

    return (
        <>
            <p>
                {zona} - {fecha}
            </p>
        </> 
    )
}

export default Reloj;